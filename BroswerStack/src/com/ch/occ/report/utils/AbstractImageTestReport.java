
package com.ch.occ.report.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ch.occ.bean.ImageTextBean;
import com.ch.occ.email.EmailUtility;
import com.ch.occ.reports.TestCaseImageDetail;
import com.ch.occ.utils.FileUtility;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.occ.utils.constants.FileConstants;
/**
 * @author 11:59:11 AM Prasanna Kumar Reddy Mar 6, 2016
 */
public class AbstractImageTestReport implements FileConstants {
	static ArrayList<ImageTextBean> allImagesList = new ArrayList<ImageTextBean>();
	ArrayList<ImageTextBean> imageList = new ArrayList<ImageTextBean>();

	HashMap<String, String> logFiles = new HashMap<String, String>();
	HashMap<String, String> errorMsgs = new HashMap<String, String>();

	@BeforeClass
	public void initializeImages() throws Exception {
		// htmlContent = generateMainReport();
	}

	public void setErrorLogFile(String suiteName, Throwable trace) {
		String errorFile = REPORTS_HOME + getCurrentDate() + ".log";
		try {
			PrintWriter printWriter = new PrintWriter(errorFile);
			trace.printStackTrace(printWriter);
			printWriter.close();
			logFiles.put(suiteName, "./" + getCurrentDate() + ".log");
			errorMsgs.put(suiteName, trace.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void quitDriver() throws Exception {
		generateImageReport(allImagesList);
		SeleniumUtils.quitDriver();
	}

	public void populateImages(String suiteName) throws Exception {
		imageList = FileUtility.readAllImages(suiteName);
		allImagesList.addAll(imageList);
	}

	public void assertCSSEntities() {
		for (Iterator<ImageTextBean> iterator = imageList.iterator(); iterator.hasNext();) {
			ImageTextBean imageBean = iterator.next();
			ImageTextUtility.testCSSEntitiesOfImage(imageBean);
		}
	}

	public void testImageVerification() throws Exception {
		ArrayList<ImageTextBean> imageList = FileUtility.readAllImages("");

		for (Iterator<ImageTextBean> iterator = imageList.iterator(); iterator.hasNext();) {
			ImageTextBean imageBean = (ImageTextBean) iterator.next();
			ImageTextUtility.testCSSEntitiesOfImage(imageBean);
		}
		generateImageReport(imageList);
	}

	public void generateImageReport(ArrayList<ImageTextBean> beans) throws Exception {
		String starthtml = "<html>";
		String head = FileUtility.readContent(HEAD_FILE);
		String body = "<body bgcolor=\"#f1f1c1\">";
		String endhtml = "</body></html>";

		System.out.println(logFiles);
		HashMap<String, ArrayList<TestCaseImageDetail>> map = new HashMap<String, ArrayList<TestCaseImageDetail>>();

		for (Iterator<ImageTextBean> iterator = beans.iterator(); iterator.hasNext();) {
			ImageTextBean imageTextBean = (ImageTextBean) iterator.next();
			String suite = imageTextBean.getSuite();
			ArrayList<TestCaseImageDetail> list = map.get(suite);
			if (null == list) {
				ArrayList<TestCaseImageDetail> images = new ArrayList<TestCaseImageDetail>();
				TestCaseImageDetail testCaseDetail = new TestCaseImageDetail(imageTextBean);
				String logFile = logFiles.get(suite);
				String error = errorMsgs.get(suite);
				if (null != logFile) {
					testCaseDetail.setLogFile(logFile);
					testCaseDetail.setErrorlog(error);
				}
				images.add(testCaseDetail);
				map.put(suite, images);
			} else {
				list.add(new TestCaseImageDetail(imageTextBean));
			}
		}
		String content = "";
		String endtable = "</table>";

		if (beans.size() > 0) {
			String starttable = FileUtility.readContent(TABLEDETAIL_HEAD_FILE);
			Set<String> keySet = map.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				ArrayList<TestCaseImageDetail> list = map.get(key);

				boolean flag = false;
				content = content + "<tr><td rowspan=" + list.size() + ">" + key + "</td>";
				for (Iterator<TestCaseImageDetail> iterator2 = list.iterator(); iterator2.hasNext();) {
					TestCaseImageDetail testCaseResult = (TestCaseImageDetail) iterator2.next();

					content = content + "<td>" + testCaseResult.getTestCaseName() + "</td><td>"
							+ testCaseResult.getHeight() + "</td><td>" + testCaseResult.getWidth() + "</td><td>"
							+ testCaseResult.getTop() + "</td><td>" + testCaseResult.getLeft() + "</td><td>"
							+ testCaseResult.getRight() + "</td><td>" + testCaseResult.getMarginright() + "</td><td>"
							+ testCaseResult.getMarginleft() + "</td><td>" + testCaseResult.getMargintop() + "</td><td>"
							+ testCaseResult.getMarginbottom() + "</td><td>" + testCaseResult.getBottom() + "</td><td>"
							+ testCaseResult.getFontSize() + "</td><td>" + testCaseResult.getColor() + "</td><td>"
							+ testCaseResult.getResult() + "</td>";
					if (true == flag) {
						content = content + "</tr>";
					} else {
						if (logFiles.get(key) == null) {
							content = content + "<td rowspan=" + list.size() + "></td><td rowspan=" + list.size()
									+ "></td></tr>";
						} else {
							content = content + "<td rowspan=" + list.size() + "><a target=\"_balnk\" href=\""
									+ testCaseResult.getLogFile() + "\">Error Log</a></td><td rowspan=" + list.size()
									+ ">" + testCaseResult.getErrorlog() + "</td></tr>";
						}
						flag = true;
					}
				}
			}
			content = starttable + content + endtable;
		}

		String htmlContent = starthtml + head + body + content + endhtml;
		String currentDate = getCurrentDate();
		FileUtility.writeHTMLContent(REPORTS_HOME + "ImageReport" + currentDate + ".html", htmlContent);
		EmailUtility.sendEmail("Test Report at :: " + currentDate, htmlContent);
	}

	protected static ArrayList<TestCaseImageDetail> getAllTestCasesDetailResults(ArrayList<ImageTextBean> beans) {
		ArrayList<TestCaseImageDetail> testCases = new ArrayList<TestCaseImageDetail>();
		for (Iterator<ImageTextBean> iterator = beans.iterator(); iterator.hasNext();) {
			ImageTextBean imageBean = (ImageTextBean) iterator.next();
			testCases.add(new TestCaseImageDetail(imageBean));
		}
		return testCases;
	}

	public static String getCurrentDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMMYYhhmmss");
		String str = df.format(date);
		return str;
	}
}

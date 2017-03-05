set project=.
echo %project%
java -cp %project%\resources\classes;%project%\lib\* org.testng.TestNG %project%\resources\suitexmls\AllMethods.xml
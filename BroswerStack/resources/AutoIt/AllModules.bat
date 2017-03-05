@echo on
title OCC_LENOX BAT FILE

echo %1

echo %*

echo %2

ant -f D:/prasanna/workspace/OCC_Automation/build.xml %*

@rem test = Account Mangement

@rem targets cart checkout browseandshopone browseandshoptwo homepage search 
set projectLocation=D:\Users\Fresh2FWProject\V3Repo\UI_AUtomation_Selenium
cd\
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*;
java org.testng.TestNG testng.xml
pause
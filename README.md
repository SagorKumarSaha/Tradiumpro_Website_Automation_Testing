# Tradiumpro Website Automation Testing

## Modules I have tested through Automation Testing -->
1. Sign-up
2. Login
3. Logout
4. Reset or Change the login password
5. Forgot password
6. Security method unavailable?
7. Security - Enable Device verification, Enable Two-factor Authentication, Add Security Question, Create Anti-Phishing Code ### (Here I have fetched the verification code from the email and completed all verifications)


## To run this automation testing -->

1. Download this zip file
2. Import this zip file in Eclipse IDE.
3. You have to download Chromedriver for selenuim which is available on selenium website.
4. In the eclipse IDE, Open Tradium_Automation_Testing_latestVersion -> src/test/java -> test.com -> Driver.java
5. In Driver.java. System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\All drivers for selenium\\chromedriver-win64\\chromedriver.exe"); change this chromedriver file location with your chromedriver location.

6. You have to run this automation testing in the following sequence ->

    singup.java -> login.java -> ForgotPassword.java -> Reset_password.java -> Security_settings.java -> Two_FA_and_security_method.java -> Logout.java

   then it will run perfectly without any error.

7. I have changed all the emails in all my Java files. So you can run the test for once perfectly. You do not need to change any emails.

If you have any issues, please don't hesitate to contact me.
Email - sagorsaha746@gmail.com

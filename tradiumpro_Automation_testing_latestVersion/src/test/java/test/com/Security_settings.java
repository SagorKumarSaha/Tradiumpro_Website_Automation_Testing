package test.com;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Security_settings extends Driver {

	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public void yopmail() throws InterruptedException {

		driver.get("https://yopmail.com/en/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// enter email name
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys("ok00@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);

		String s0 = driver.findElement(By.cssSelector("div[class='bname']")).getText();
		if (s0.contains("ok00@yopmail.com")) {
			System.out.println("Email signed in...");
		} else {
			System.out.println("Error in Email sign in...");
		}

	}

	@SuppressWarnings("deprecation")
	@Test(priority = 2)
	public void login() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://tradiumpro.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(3000);

		// login button
		driver.findElement(By.cssSelector("a[class='HeaderNew_loginBtn__fbbEJ']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);

		// email field
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("ok00@yopmail.com");
		Thread.sleep(1000);

		// password field
		driver.findElement(By.id("password")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("Sa1234567");
		Thread.sleep(1000);

		// login button
		WebElement e = driver.findElement(By.cssSelector("button[type='submit']"));
		if (e.isEnabled() == true) {
			System.out.println("Clicking the login button...");
			e.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(2000);
		} else {
			System.out.println("Button is not visible...");
			Thread.sleep(2000);
		}

		String s = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/h2")).getText();
		if (s.contains("Dashboard")) {
			System.out.println(" Test passed...");
		} else {
			System.out.println(" Test failed...");
		}

	}

	@SuppressWarnings("deprecation")
	@Test(priority=3)
	public void security() throws InterruptedException {

		// security button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[1]/div/div[2]/div/a[2]"))
				.click();
		Thread.sleep(3000);

		// Login 2FA - enable button
		WebElement aa = driver.findElement(By.cssSelector("button[class='button-small button-grad-2 rounded-pill px-4']"));
		if (aa.getText().contains("Enable")) {
			System.out.println("2FA is Disabled... Let's enable it..");
			aa.click();
			Thread.sleep(2000);

			// getCode button
			driver.findElement(By.cssSelector(
					"button[class='button-black button-small CodeVerificationInput_getCodeButton__smS8K']")).click();;
			Thread.sleep(2000);

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(2000);

			// get_code from yopmail
			//driver.findElement(By.id("refresh")).click();
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Thread.sleep(5000);
			WebElement iframe = driver.findElement(By.name("ifmail"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			String a = driver.findElement(By.cssSelector("p[style='font-size: 25px; margin: 10px 0']")).getText();
			Thread.sleep(2000);

			// switch to tradiumpro
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(2000);

			// verification code
			driver.findElement(By.name("email_verify_code")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("email_verify_code")).sendKeys(a);
			Thread.sleep(2000);

			// continue button
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(2000);

			WebElement aa1 = driver
					.findElement(By.cssSelector("button[class='button-small button-grad-2 rounded-pill px-4']"));
			if (aa1.getText().contains("Disable")) {
				System.out.println("2FA is enabled.... Test passed..");
			} else {
				System.out.println("2FA is not enabled... Test failed..");
			}

		} else {
			System.out.println("2FA is is already enabled....");
		}
		
		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[3]/div[3]/div[1]/div[2]/h5"));
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(2000);

		// Device verification
		Thread.sleep(2000);
		WebElement s = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[2]/div[2]/button"));
		if (s.getText().contains("Enable")) {
			System.out.println("Device verification Enabling...");
			s.click();
			Thread.sleep(2000);

			// getCode button
			driver.findElement(By.cssSelector("button[class='button-black button-small CodeVerificationInput_getCodeButton__smS8K']")).click();;
			Thread.sleep(2000);

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));

			// get_code from yopmail
			Thread.sleep(2000);
			//driver.findElement(By.id("refresh")).click();
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Thread.sleep(5000);
			WebElement iframe = driver.findElement(By.name("ifmail"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			String a = driver.findElement(By.cssSelector("p[style='font-size: 25px; margin: 10px 0']")).getText();
			Thread.sleep(2000);

			// switch to tradiumpro
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(2000);

			// verification code
			driver.findElement(By.name("email_verify_code")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("email_verify_code")).sendKeys(a);
			Thread.sleep(2000);

			// continue button
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(2000);

			WebElement aa1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[2]/div[2]/button"));
			if (aa1.getText().contains("Disable")) {
				System.out.println("Device verification Test passed..");
			} else {
				System.out.println("Device verification Test failed..");
			}

		} else {
			System.out.println("Already enabled...");
		}

		// scroll
		WebElement scrol = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/h4"));
		js.executeScript("arguments[0].scrollIntoView();", scrol);
		Thread.sleep(2000);

		// anti-phishing code
		WebElement s1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[4]/div[2]/button"));
		if (s1.getText().contains("Create")) {
			System.out.println("Anti-Phishing Code Enabling...");
			s1.click();
			Thread.sleep(2000);

			// new code
			driver.findElement(By.name("new_anti_phishing_code")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("new_anti_phishing_code")).sendKeys("000000");
			Thread.sleep(2000);

			// getCode button
			driver.findElement(By.cssSelector("button[class='button-black button-small CodeVerificationInput_getCodeButton__smS8K']")).click();;
			Thread.sleep(2000);

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));

			// get_code from yopmail
			Thread.sleep(2000);
			//driver.findElement(By.id("refresh")).click();
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Thread.sleep(5000);
			WebElement iframe = driver.findElement(By.name("ifmail"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			String a = driver.findElement(By.cssSelector("p[style='font-size: 25px; margin: 10px 0']")).getText();
			Thread.sleep(2000);

			// switch to tradiumpro
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(2000);

			// verification code
			driver.findElement(By.name("email_verify_code")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("email_verify_code")).sendKeys(a);
			Thread.sleep(2000);

			// continue button
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(2000);

			// scroll
			WebElement scroll1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/h4"));
			js.executeScript("arguments[0].scrollIntoView();", scroll1);
			Thread.sleep(2000);

			WebElement aa2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[4]/div[2]/button"));
			if (aa2.getText().contains("Change")) {
				System.out.println("Anti-phishing code Test passed..");
			} else {
				System.out.println("Anti-phishing code Test failed..");
			}

		} else {
			System.out.println("Anti-Phishing Code already enabled...");
		}

	}

}

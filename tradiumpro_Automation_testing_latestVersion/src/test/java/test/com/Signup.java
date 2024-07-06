package test.com;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Signup extends Driver {
	
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
		driver.findElement(By.name("login")).sendKeys("sagor11@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);

		String s0 = driver.findElement(By.cssSelector("div[class='bname']")).getText();
		if (s0.contains("sagor11@yopmail.com")) {
			System.out.println("Email signed in...");
		} else {
			System.out.println("Error in Email sign in...");
		}

	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=2)
	public void sign_up() throws InterruptedException {
		
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://tradiumpro.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//login button
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section/div/header/div/a")).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//sign up for free
		driver.findElement(By.cssSelector("a[class='auth_layout_link__DLDhE']")).click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//email field
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("sagor11@yopmail.com");
		Thread.sleep(1000);
		
		//password field
		driver.findElement(By.name("password")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("Sa1234567");
		Thread.sleep(2000);
		
		//confirm password
		driver.findElement(By.id("password_confirm")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password_confirm")).sendKeys("Sa1234567");
		Thread.sleep(2000);
		
		//checkbox selection
		WebElement e = driver.findElement(By.cssSelector("span[class='Checkbox_tick__UL5OD']"));
		if(e.isSelected()==false) {
			System.out.println("Check box is not selected... selecting checkbox..");
			e.click();
			Thread.sleep(2000);
		}else {
			System.out.println("Check box is already selected...");
		}

		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.cssSelector("button[type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(2000);
		
		//signup button
		WebElement e2 = driver.findElement(By.cssSelector("button[type='submit']"));
		if(e2.isEnabled()==true) {
			System.out.println("Clicking the signup button...");
			e2.click();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		}else {
			System.out.println("Cann't click signup button...");
		}
		
		//getcode button
		driver.findElement(By.cssSelector("button[class='button-black button-small CodeVerificationInput_getCodeButton__smS8K']")).click();
		Thread.sleep(3000);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 3, description = "get code and write it in tradiumpro")
	public void yopmail_getCode() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);

		// get_code
		//driver.findElement(By.id("refresh")).click();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement iframe = driver.findElement(By.name("ifmail"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		String a = driver.findElement(By.cssSelector("p[style='font-size: 25px; margin: 10px 0']")).getText();
		Thread.sleep(2000);

		// write code in tradiumpro
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);

		// verification code
		driver.findElement(By.name("email_verify_code")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("email_verify_code")).sendKeys(a);
		Thread.sleep(2000);
		
		// Verify code button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 4)
	public void login() throws InterruptedException {

		// email field
		Thread.sleep(1500);
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("sagor11@yopmail.com");
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
			System.out.println("Sign up Test passed...");
		} else {
			System.out.println("Sign up Test failed...");
		}

	}

}
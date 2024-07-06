package test.com;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Reset_password extends Driver{
	
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void yopmail() throws InterruptedException {
		
		driver.get("https://yopmail.com/en/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//enter email name
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys("sagor11@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String s0 = driver.findElement(By.cssSelector("div[class='bname']")).getText();
		if(s0.contains("sagor11@yopmail.com")) {
			System.out.println("Email signed in...");
		}else {
			System.out.println("Error in Email sign in...");
		}
			
	}
	
	
	@SuppressWarnings("deprecation")
	@Test(priority=2)
	public void login() throws InterruptedException {
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://tradiumpro.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//login button
		driver.findElement(By.cssSelector("a[class='HeaderNew_loginBtn__fbbEJ']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		//email field
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("sagor11@yopmail.com");
		Thread.sleep(1000);
		
		//password field
		driver.findElement(By.id("password")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("Sa1234567");
		Thread.sleep(1000);
		
		//login button
		WebElement e  = driver.findElement(By.cssSelector("button[type='submit']"));
		if(e.isEnabled()==true) {
			System.out.println("Clicking the login button...");
			e.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(2000);
		}else {
			System.out.println("Button is not visible...");
			Thread.sleep(2000);
		}
		
		String s = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/h2")).getText();
		if(s.contains("Dashboard")) {
			System.out.println(" Log in done...");
		}else {
			System.out.println(" Log in failed...");
		}
		
	}
	
	@Test(priority=3)
	public void reset_password() throws InterruptedException {
		
		//security button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[1]/div/div[2]/div/a[2]")).click();
		Thread.sleep(2000);
		
		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/h4"));
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(2000);
		
		//change button
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[3]/div[2]/button")).click();
		Thread.sleep(2000);
		
		//old password
		driver.findElement(By.name("old_password")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("old_password")).sendKeys("Sa1234567");
		Thread.sleep(2000);
		
		//new password
		driver.findElement(By.name("new_password")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("new_password")).sendKeys("Sa1234567");
		Thread.sleep(2000);
		
		//confirm password
		driver.findElement(By.name("password_confirm")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("password_confirm")).sendKeys("Sa1234567");
		Thread.sleep(2000);
		
		//get code button
		driver.findElement(By.cssSelector("button[class='button-black button-small CodeVerificationInput_getCodeButton__smS8K']")).click();
		Thread.sleep(3000);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=4,description="")
	public void yopmail_getcode() throws InterruptedException {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		
		//get_code
		//driver.findElement(By.id("refresh")).click();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement iframe = driver.findElement(By.name("ifmail"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		String a = driver.findElement(By.cssSelector("p[style='font-size: 25px; margin: 10px 0']")).getText();
		Thread.sleep(2000);
		
		//write code in tradiumpro
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		
		//verification code
		driver.findElement(By.name("email_verify_code")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("email_verify_code")).sendKeys(a);
		Thread.sleep(3000);
		
		//continue button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		
		String a0 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[3]/div[1]/div[2]/h5")).getText();
		if(a0.contains("Login Password")) {
			System.out.println("Reset password Test passed...");
		}else {
			System.out.println("Reset password Test failed...");
		}
		
	}

}

package test.com;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ForgotPassword extends Driver{
	
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
		driver.findElement(By.name("login")).sendKeys("ok00@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String s0 = driver.findElement(By.cssSelector("div[class='bname']")).getText();
		if(s0.contains("ok00@yopmail.com")) {
			System.out.println("Email signed in...");
		}else {
			System.out.println("Error in Email sign in...");
		}
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Test(priority=2)
	public void forgotpassword() throws InterruptedException {
		
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://tradiumpro.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// login button
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[class='HeaderNew_loginBtn__fbbEJ']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//forgot password
		driver.findElement(By.cssSelector("a[href='/forgot-password']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//email field
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("ok00@yopmail.com");
		Thread.sleep(2500);
		
		//continue button
		WebElement eb = driver.findElement(By.cssSelector("button[type='submit']"));
		if(eb.isEnabled()) {
			System.out.println("Clicking the continue button...");
			eb.click();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Thread.sleep(3000);
		}else {
			System.out.println("Continue button is not visible...");
			Thread.sleep(3000);
		}
			
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=3, description="get code and write it in tradiumpro")
	public void yopmail_getCode() throws InterruptedException {
		
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
		driver.findElement(By.name("code")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("code")).sendKeys(a);
		Thread.sleep(2000);
		
		//new pass
		driver.findElement(By.name("password")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("Sa1234567");
		Thread.sleep(2000);
		
		//confirm pass
		driver.findElement(By.name("password_confirm")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("password_confirm")).sendKeys("Sa1234567");
		Thread.sleep(2000);
		
		//continue button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		
		//login button
		driver.findElement(By.cssSelector("a[class='button button-grad-1 rounded-pill Form_button__p_vJe Form_forgoPassButton__L4_Ue']")).click();
		Thread.sleep(3000);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test(priority=4)
	public void login() throws InterruptedException {
		
		//email field
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("ok00@yopmail.com");
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
			System.out.println(" Test passed...");
		}else {
			System.out.println(" Test failed...");
		}
		
	}

}

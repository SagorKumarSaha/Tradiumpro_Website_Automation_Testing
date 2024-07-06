package test.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends Driver{
	
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void login() throws InterruptedException {
		
		driver.get("https://tradiumpro.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
			System.out.println(" Test passed...");
		}else {
			System.out.println(" Test failed...");
		}
		
	}

}

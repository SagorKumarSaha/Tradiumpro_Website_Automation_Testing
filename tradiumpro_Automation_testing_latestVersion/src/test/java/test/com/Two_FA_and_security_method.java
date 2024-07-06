package test.com;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Two_FA_and_security_method extends Driver {

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

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://tradiumpro.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		// login button
		Thread.sleep(3000);
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
		
		// get code button
		driver.findElement(By.cssSelector("button[class='button-black button-small CodeVerificationInput_getCodeButton__smS8K']")).click();
		Thread.sleep(3000);

		// switch to yopmail
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
		Thread.sleep(3000);

		// verify code button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);

		String s = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/h2")).getText();
		if (s.contains("Dashboard")) {
			System.out.println(" Login passed...");
		} else {
			System.out.println(" Login failed...");
		}

	}

	@SuppressWarnings("deprecation")
	@Test(priority = 3)
	public void security_question() throws InterruptedException {

		// security button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[1]/div/div[2]/div/a[2]"))
				.click();
		Thread.sleep(3000);

		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/h4"));
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(2000);
		
		//create button
		WebElement e = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[5]/div[2]/button"));
		if(e.getText().contains("Create")) {
			System.out.println("No security question is present... let's add one..");
			e.click();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Thread.sleep(2000);
			
			//add button
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[3]/form/button")).click();
			Thread.sleep(2000);
			
			//question field
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div")).click();
			Thread.sleep(2500);
			WebElement d = driver.findElement(By.xpath("//*[@id=\"react-select-2-listbox\"]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(d).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(2000);
			actions.moveToElement(d).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(2000);
			actions.moveToElement(d).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			
			//answer field
			driver.findElement(By.name("answer_key0")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("answer_key0")).sendKeys("Lamborghini");
			Thread.sleep(2000);
			
			//save button
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[3]/form/button")).click();
			Thread.sleep(2000);
			
			//get code button
			driver.findElement(By.xpath("//*[@id=\"react-tabs-3\"]/div/div[3]/button")).click();
			Thread.sleep(3000);
			
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
			driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/button")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(3000);
			
			// scroll
			WebElement scroll1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/h4"));
			js.executeScript("arguments[0].scrollIntoView();", scroll1);
			Thread.sleep(2000);

			//check
			WebElement e1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[5]/div[2]/button"));
			if(e1.getText().contains("Update")) {
				System.out.println("Security question added successfully...");
			}else {
				System.out.println("Security question not added...");
			}
			
			
		}else {
			System.out.println("Security question is present already...");
		}	
		
	}


	@SuppressWarnings("deprecation")
	@Test(priority = 4)
	public void security_method() throws InterruptedException {
		Thread.sleep(3000);
		
		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[3]/div[3]/div[1]/div[2]/h5"));
		js.executeScript("arguments[0].scrollIntoView();", scroll1);
		Thread.sleep(2000);

		// enable button click
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/div[4]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);

		// security method unavailable
		driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);

		// checkbox click
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("label[class='Checkbox_checkbox__A3sh8']")).click();
		Thread.sleep(2000);

		// continue button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);

		// Enter new mail
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("no00@yopmail.com");
		Thread.sleep(2000);

	}

	@SuppressWarnings("deprecation")
	@Test(priority = 5)
	public void new_yopmail() throws InterruptedException {

		// again open yopmail for new mail
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(3));
		driver.get("https://yopmail.com/en/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		// enter email name
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		Thread.sleep(1500);
		driver.findElement(By.name("login")).sendKeys("no00@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);

		String s0 = driver.findElement(By.cssSelector("div[class='bname']")).getText();
		if (s0.contains("no00@yopmail.com")) {
			System.out.println("Email signed in...");
		} else {
			System.out.println("Error in Email sign in...");
		}

		// switch to reset security verification tab
		driver.switchTo().window(tabs.get(2));
		Thread.sleep(2000);

		// get code button
		driver.findElement(
				By.cssSelector("button[class='button-black button-small CodeVerificationInput_getCodeButton__smS8K']"))
				.click();
		Thread.sleep(2500);

		// switch to yopmail tab
		driver.switchTo().window(tabs.get(3));
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

		// switch to tradiumpro
		driver.switchTo().window(tabs.get(2));
		Thread.sleep(2000);

		// verification code
		driver.findElement(By.name("email_verify_code")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("email_verify_code")).sendKeys(a);
		Thread.sleep(2000);

		// reset button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		// start answering questions
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		
		//answer
		driver.findElement(By.xpath("//*[@id=\"cl84b291h0005k8t5ur60f0po\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"cl84b291h0005k8t5ur60f0po\"]")).sendKeys("lamborghini");
		Thread.sleep(2000);
		
		//submit button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		
		// return to dashboard button
		driver.findElement(By.cssSelector("button[class='button-wide']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String g = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/h2")).getText();
		if(g.contains("Dashboard")) {
			System.out.println(" All Test passed...");
		}else {
			System.out.println(" Test failed...");
		}

	}

}

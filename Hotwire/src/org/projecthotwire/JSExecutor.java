package org.projecthotwire;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

//before run this code kindly change setProperty path

//javascript executor 
public class JSExecutor {
	public static WebDriver cdriver;

	// sendkeys and click and getattribute
	public static void jS() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) cdriver;

		// signin
		WebElement signin = cdriver.findElement(By.xpath("//span[text()='Sign in']"));
		js.executeScript("arguments[0].click()", signin);
		Thread.sleep(2000);

		// username
		WebElement username = cdriver.findElement(By.id("email"));
		js.executeScript("arguments[0].setAttribute('value','faff@gmail.com')", username);
		Object email = js.executeScript("return arguments[0].getAttribute('value')", username);
		System.out.println(email.toString());

		// password
		WebElement password = cdriver.findElement(By.id("password"));
		js.executeScript("arguments[0].setAttribute('value','sdaf@123214l')", password);
		Object pass = js.executeScript("return arguments[0].getAttribute('value')", password);
		System.out.println(pass.toString());

		// login
		WebElement login = cdriver.findElement(By.xpath("//span[text()='Sign In']"));
		js.executeScript("arguments[0].click()", login);

	}

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shpra\\eclipse-workspace\\Hotwire\\Driver\\chromedriver.exe");

		cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://www.hotwire.com/");

		String title = cdriver.getTitle();
		String currentUrl = cdriver.getCurrentUrl();
		System.out.println(title + " : " + currentUrl);

		// calling jS method
		jS();

		cdriver.close();

	}
}

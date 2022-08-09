package org.projecthotwire;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

//before run this code kindly change setProperty path
// kindly change the path of screenshot before run

public class Screenshot {
	public static WebDriver cdriver;

	// screenshot
	public static void ss(String snap) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) cdriver;
		File sorce = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\shpra\\eclipse-workspace\\Hotwire\\photo\\" + snap + ".jpg");
		FileUtils.copyFile(sorce, destination);
	}

	// Javascript executor -- highlighting and taking screenshot of that
	public static void highlight() throws InterruptedException, IOException {
		// cdriver.findElement(By.xpath("(//a[text()='Flights'])[1]")).click();

		// highlighting goingTo textbox
		JavascriptExecutor js = (JavascriptExecutor) cdriver;
		WebElement goingTo = cdriver.findElement(By.xpath("(//button[@aria-label='Going to'])[1]"));
		js.executeScript("arguments[0].setAttribute('style','background:orange; border:20px solid blue')", goingTo);

		// highlighting findAFlight button
		WebElement findAFlight = cdriver.findElement(By.xpath("(//button[text()='Find a flight'])"));
		js.executeScript("arguments[0].setAttribute('style','background:orange; font-size:20px; text-align:left')",
				findAFlight);
		// taking screenshot
		ss("flight");
		Thread.sleep(1000);

	}

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shpra\\eclipse-workspace\\Hotwire\\Driver\\chromedriver.exe");

		cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://www.hotwire.com/flights/");

		String title = cdriver.getTitle();
		String currentUrl = cdriver.getCurrentUrl();
		System.out.println(title + " : " + currentUrl);

		// calling highlight method
		highlight();

		cdriver.close();

	}
}

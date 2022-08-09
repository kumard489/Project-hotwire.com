package org.projecthotwire;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class ActionAndRobot {
	public static WebDriver cdriver;
	public static Actions action;
	public static Robot robot;

	public static void booking() throws AWTException, InterruptedException {

		// booking hotel

		// Destination
		WebElement destination = cdriver.findElement(By.xpath("//input[contains(@placeholder,'Where would ')]"));
		destination.sendKeys("ecr");
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		// Selecting dates
		// Check-in
		WebElement strtDate = cdriver.findElement(By.xpath("(//div[text()='28'])[1]"));
		action.moveToElement(strtDate).click().perform();
		Thread.sleep(2000);
		// Check-out
		WebElement endDate = cdriver.findElement(By.xpath("(//div[text()='31'])[1]"));
		action.moveToElement(endDate).click().perform();
		Thread.sleep(2000);

		// Guests
		cdriver.findElement(By.xpath("(//div[@class='guest-picker'])")).click();
		Thread.sleep(2000);
		// Room
		WebElement room = cdriver.findElement(By.xpath("(//span[text()='Increase'])[1]"));
		action.moveToElement(room).click().perform();
		Thread.sleep(2000);
		// Adults
		WebElement adults = cdriver.findElement(By.xpath("(//span[text()='Increase'])[2]"));
		action.moveToElement(adults).doubleClick().perform();
		Thread.sleep(2000);
		// Children
		WebElement children = cdriver.findElement(By.xpath("(//span[text()='Increase'])[3]"));
		action.moveToElement(children).doubleClick().click().build().perform();
		Thread.sleep(2000);
		// done
		cdriver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(2000);

		// Find a hotel
		WebElement findAHotel = cdriver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		action.moveToElement(findAHotel).click().perform();
		// access denied
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

		// action class using in my project
		action = new Actions(cdriver);
		// robot class using in my project
		robot = new Robot();

		// calling booking method
		booking();

		cdriver.close();

	}
}

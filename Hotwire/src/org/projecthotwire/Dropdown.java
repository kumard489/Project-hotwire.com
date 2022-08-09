package org.projecthotwire;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//before run this code kindly change setProperty path

public class Dropdown {
	public static WebDriver cdriver;

	public static void dropdown() {
		WebElement countryCode = cdriver.findElement(By.xpath("//select[@id='countryCode']"));
		// scrolling
		JavascriptExecutor js = (JavascriptExecutor) cdriver;
		js.executeScript("arguments[0].scrollIntoView()", countryCode);

		// selection india by using select class and methods
		Select op = new Select(countryCode);
		op.selectByValue("+91,India");
		System.out.println("Avalible countries list");
		System.out.println("-----------------------");
		List<WebElement> countriesList = op.getOptions();

		for (int i = 0; i < countriesList.size(); i++) {
			System.out.println(countriesList.get(i).getText());
		}

	}

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shpra\\eclipse-workspace\\Hotwire\\Driver\\chromedriver.exe");

		cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get(
				"https://www.hotwire.com/app?referrer=mat_click_id%3D90406d5756f6432da2defbac93ce8362-20220806-5788%26link_click_id%3D1084439412978431887&mat_click_id=90406d5756f6432da2defbac93ce8362-20220806-5788");

		String title = cdriver.getTitle();
		String currentUrl = cdriver.getCurrentUrl();
		System.out.println(title + " : " + currentUrl);
		System.out.println(" ");
		// calling dropdown method
		dropdown();

		cdriver.close();

	}
}

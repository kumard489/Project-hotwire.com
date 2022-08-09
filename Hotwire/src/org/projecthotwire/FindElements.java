package org.projecthotwire;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//before run this code kindly change setProperty path

public class FindElements {
	public static WebDriver cdriver;

	// website does not contains any tables.
	// that is why i am using findElements for same process like webtable.
	public static void findElements() throws InterruptedException {
		System.out.println(cdriver.findElement(By.xpath("//h3[text()='Popular amenities']")).getText());
		System.out.println("-----------------");
		// Popular amenities
		WebElement div = cdriver
				.findElement(By.xpath("//div[contains(@class,'uitk-layout-grid uitk-layout-grid-gap-f')]"));
		JavascriptExecutor js = (JavascriptExecutor) cdriver;
		js.executeScript("arguments[0].scrollIntoView()", div);
		List<WebElement> list = div.findElements(By.tagName("li"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}

	}

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shpra\\eclipse-workspace\\Hotwire\\Driver\\chromedriver.exe");

		cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get(
				"https://vacation.hotwire.com/Chicago-Hotels-Four-Seasons-Hotel-Chicago.h25748.Hotel-Information?gaiaId=178248&tmid=32708840316&currency=USD&rfrr=Header.Currency.USD&exp_dp=690&chkin=8%2F6%2F2022&chkout=8%2F7%2F2022&rm1=a2&paandi=true");

		String title = cdriver.getTitle();
		String currentUrl = cdriver.getCurrentUrl();
		System.out.println(title + " : " + currentUrl);
		System.out.println(" ");
		// calling findelements method
		findElements();

		cdriver.close();

	}
}

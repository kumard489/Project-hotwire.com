package org.projecthotwire;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.beust.ah.A;

//before run this code kindly change setProperty path

public class WindowHandling {
	public static WebDriver cdriver;

	public static void windows() throws AWTException, InterruptedException {
		// --note:this website is not allowing for second tab in automation it shows
		// --it shows access denied
		// --i hope it will work by using vpn
		// --and below webpage is used in dropdown class
		// --but it works manually

		// getTheApp @ parent window
		cdriver.findElement(By.xpath("//a[text()='Get the app']")).click();

		// get windows id
		Set<String> allWin = cdriver.getWindowHandles();
		List<String> winList = new ArrayList<String>();
		cdriver.switchTo().window(winList.get(1));
		Thread.sleep(3000);

		// text box @ child window
		WebElement phno = cdriver.findElement(By.xpath("//input[@id='phoneNumber']"));
		// scroll by using JS executor
		JavascriptExecutor js = (JavascriptExecutor) cdriver;
		js.executeScript("arguments[0].click()", phno);
		js.executeScript("arguments[0].setAttribute('value','1223435436')", phno);
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

		// calling windows method
		windows();

		cdriver.close();

	}

}

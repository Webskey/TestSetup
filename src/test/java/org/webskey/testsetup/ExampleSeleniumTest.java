package org.webskey.testsetup;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExampleSeleniumTest {

	private static FirefoxDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "c:/SeleniumGecko/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Before
	public void openHomePage(){
		driver.get("http://www.google.com");
	}
	
	@Test
	public void test() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
		search.submit();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.className("LC20lb")).getText().contains("Selenium - Web Browser Automation"));
	}
}

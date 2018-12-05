package org.webskey.testsetup.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImagesPage extends BasePage {

	private WebDriver driver;

	public ImagesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void search(String phrase) {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(phrase);
		search.submit();
	}

	public boolean isResultDisplayed(String phrase) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement result = driver.findElement(By.xpath("//*[@id=\"uXQhbgOwJDe-nM:\"]"));
		return result.isDisplayed();	
	}
}

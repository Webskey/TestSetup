package org.webskey.testsetup.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public ImagesPage goToImages() {
		driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/a")).click();
		return new ImagesPage(driver);
	}
	
	public void search(String phrase) {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(phrase);
		search.submit();
	}
	
	public boolean isResultContainingPhrase(String phrase) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement result = driver.findElement(By.className("LC20lb"));

		return result.getText().contains(phrase);
	}
}

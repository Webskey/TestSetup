package org.webskey.testsetup.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo(String adress) {
		driver.get(adress);
	}
}

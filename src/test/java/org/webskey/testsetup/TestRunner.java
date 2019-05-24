package org.webskey.testsetup;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.webskey.testsetup.pages.BrowserDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
features = {"classpath:features/"})
public class TestRunner {
	
	@AfterClass
	public static void shutDown() {
		BrowserDriver.INSTANCE.getWebDriver().quit();
	}
}
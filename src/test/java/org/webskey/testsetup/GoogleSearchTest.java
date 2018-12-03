package org.webskey.testsetup;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchTest {

	private static FirefoxDriver driver;
	private WebElement search;
	private WebElement result;

	@Before("@google")
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "c:/SeleniumGecko/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@After("@google")
	public static void tearDown() {
		driver.quit();
	}

	@Given("^I am on google main page$")
	public void i_am_on_google_main_page() throws Exception {
		driver.get("http://www.google.com");
	}

	@When("^I type \"([^\"]*)\"$")
	public void i_type(String searchPhrase) throws Exception {
		search = driver.findElement(By.name("q"));
		search.sendKeys(searchPhrase);
	}

	@When("^I sumbit$")
	public void i_sumbit() throws Exception {
		search.submit();
	}

	@Then("^I get result containing \"([^\"]*)\" phrase$")
	public void i_get_result_containing_phrase(String searchPhrase) throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		result = driver.findElement(By.className("LC20lb"));
		assertTrue(result.getText().contains(searchPhrase));
	}
}

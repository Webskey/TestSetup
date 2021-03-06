package org.webskey.testsetup;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.webskey.testsetup.pages.BrowserDriver;
import org.webskey.testsetup.pages.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchTest {

	private WebDriver driver;
	private HomePage homePage;

	@Before("@google")
	public void setUp() {
		driver = BrowserDriver.INSTANCE.getWebDriver();
	}

	@After("@google")
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Given("^I am on google main page$")
	public void i_am_on_google_main_page() throws Exception {
		homePage = new HomePage(driver);
		homePage.goTo("http://www.google.com");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchPhrase) throws Exception {
		homePage.search(searchPhrase);
	}

	@Then("^I get result containing \"([^\"]*)\" phrase$")
	public void i_get_result_containing_phrase(String searchPhrase) throws Exception {
		assertTrue(homePage.isResultContainingPhrase(searchPhrase));
	}
}

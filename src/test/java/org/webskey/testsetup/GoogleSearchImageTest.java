package org.webskey.testsetup;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.webskey.testsetup.pages.BrowserDriver;
import org.webskey.testsetup.pages.HomePage;
import org.webskey.testsetup.pages.ImagesPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchImageTest {

	private WebDriver driver;
	private HomePage homePage;
	private ImagesPage imagesPage;

	@Before("@google")
	public void setUp() {
		driver = BrowserDriver.INSTANCE.getWebDriver();
	}

	@After("@google")
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Given("^I am on google page$")
	public void i_am_on_google_page() throws Exception {
		homePage = new HomePage(driver);
		homePage.goTo("http://www.google.com");
	}

	@When("^I go to google images$")
	public void i_go_to_google_images() throws Exception {
		imagesPage = homePage.goToImages();
	}

	@When("^I search for \"([^\"]*)\" phrase$")
	public void i_search_for_phrase(String phrase) throws Exception {
		imagesPage.search(phrase);
	}

	@Then("^I get result page with images of \"([^\"]*)\"$")
	public void i_get_result_page_with_images_of(String phrase) throws Exception {
		assertTrue(imagesPage.isResultDisplayed(phrase));
	}
}

package org.webskey.testsetup;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExampleTestSteps {

	private String today;
	private String actualAnswer;

	private String isItFriday(String day) {
		if(day.equals("Friday"))
			return "Yes";
		return "Nope";
	}

	@Given("^today is \"([^\"]*)\"$")
	public void today_is(String today) throws Exception {
		this.today = today;
	}

	@When("^I ask whether it's Friday yet$")
	public void i_ask_whether_it_s_Friday_yet() throws Exception {		
		actualAnswer = isItFriday(today);
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String expectedAnswer) throws Exception {
		assertEquals(expectedAnswer, actualAnswer);
	}
}

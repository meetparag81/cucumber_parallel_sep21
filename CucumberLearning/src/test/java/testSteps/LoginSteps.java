package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginSteps {
	LoginPage LP;
	 @Given("User is on Facebook.com")
	public void user_is_on_facebook_com() {
	    
	    
	}

	@When("User Enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() {
	    System.out.println();
	}

	@Then("User is on Home Page")
	public void user_is_on_home_page() {
	   
	}

	@And("User clics on the Homedropdown")
	public void user_clics_on_the_homedropdown() {
	   
	}

}

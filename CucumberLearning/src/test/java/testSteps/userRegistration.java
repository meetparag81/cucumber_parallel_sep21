package testSteps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class userRegistration {
	@When("user is on RegistrationPage")
	public void user_is_on_registration_page() {
	    System.out.println("user_is_on_registration_page");
	}

	@When("user enters following details")
	public void user_enters_following_details(DataTable dataTable) {
	  List<String> userlist = dataTable.asList(String.class);
	  for (String e : userlist) {
		System.out.println(e);
	}
	}

	@Then("user is on the registrationPage")
	public void user_is_on_the_registration_page() {
		System.out.println("user_is_on_the_registration_page");
	}

	@When("user enters following details withcolumnname")
	public void user_enters_following_details_withcolumnname(DataTable dataTable) {
		List<Map<String, String>> usermap = dataTable.asMaps(String.class,String.class);
		System.out.println(usermap);
	}

	
}

package testSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UberSteps {
	
	@Given("User wants to select car type\"Sedan\" from app")
	public void user_wants_to_select_car_type_sedan_from_app() {
	   
	}

	@When("User selects cartype\"Sedan\" and  pickuppint {string} and destinaion {string}")
	public void user_selects_cartype_sedan_and_pickuppint_and_destinaion(String pickpoint , String destination) {
	    System.out.println(pickpoint);
	}

	@Then("Driver starts the journey")
	public void driver_starts_the_journey() {
	    
	}

	@Then("Driver ends the journey")
	public void driver_ends_the_journey() {
	   
	}

	@Then("User pays {int} INR")
	public void user_pays_inr(Integer int1) {
	    
	}

	@Given("User wants to select car type\"SUV\" from app")
	public void user_wants_to_select_car_type_suv_from_app() {
	    
	}

	@Given("User wants to select car type\"Mini car\" from app")
	public void user_wants_to_select_car_type_mini_car_from_app() {
	   
	}

}

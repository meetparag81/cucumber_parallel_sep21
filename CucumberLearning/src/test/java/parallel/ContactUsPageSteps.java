package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountsPage;
import pages.LoginPage;
import pages.contactUsPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.ResourceHelper;

public class ContactUsPageSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(factory.DriverFactory.getDriver());
	private AccountsPage AccountPage= new AccountsPage(DriverFactory.getDriver());
	private  contactUsPage CUP;
	ConfigReader CR= new ConfigReader();

	
	

	@When("User fills the form {string} and {int}")
	public void user_fills_the_form_and(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();		
		List<Map<String, String>> testdata = reader.getData(ResourceHelper.GetResourcePath("\\src\\test\\resources\\Testdata\\Data.xlsx"), sheetname);
		String heading = testdata.get(rownumber).get("SubjectHeading");
		String email = testdata.get(rownumber).get("email");
		String orderref = testdata.get(rownumber).get("message");
		String message = testdata.get(rownumber).get("orderref");
		CUP=AccountPage.ClickonContactUS();
		 CUP.fillContactUsForm(heading, email, orderref, message);
		


		
	}



	
	
	@Given("User Navigates to contact us page")
	public void user_navigates_to_contact_us_page() {

		DriverFactory.getDriver();
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		//Properties prop = CR.Init_prop();
		//  String username = prop.get("username").toString();
		//String password = prop.get("password").toString();
	   
	
	   
	   
	}


	

	
	@When("Users clicks on SendButton")
	public void users_clicks_on_send_button() {
	   
	   // CUP.clickSend();
	}
	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expected) {
		//String actual = CUP.getSuccessMessg();
	//	Assert.assertEquals(actual,expected );
		
	}


}
	


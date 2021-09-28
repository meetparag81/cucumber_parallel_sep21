package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import RestApi.RestAPI;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPageHire;
import pages.OnOffBoardingPage;
import pages.PeopleProfilePage;
import utilities.ConfigReader;
import utilities.Constants;
import utilities.ExcelReader;
import utilities.ResourceHelper;

public class ESSSteps {
	ConfigReader CR= new ConfigReader();
	LoginPageHire Lph= new LoginPageHire(DriverFactory.getDriver());	
	private List<Map<String, String>> testdata;
	private String excelpath="\\src\\test\\resources\\Testdata\\Data.xlsx";
	ExcelReader reader = new ExcelReader();	
	private String Sheetname;
	private HomePage homepage;
	private PeopleProfilePage Peoplepage;
	private OnOffBoardingPage OnOffBoardingPage; 
	
	
	@When("Update Personal Information TDS Validation {string} {int}")
	public void update_personal_information_tds_validation(String sheetname, Integer int1) throws InvalidFormatException, IOException {
	   
		testdata = reader.getData(ResourceHelper.GetResourcePath(excelpath), sheetname);
	}

	@Given("User gets a randon employee using {string} {string} {string} {string} {string} {string}")
	public void user_gets_a_randon_employee_using(String EmployeeID, String Environment, String testcompanyCODE, String ej_PositionType, String cust_EmployeeClass,String EmploymentType) {
        String URL = "";            
        
        if (Environment.equals("SIT"))
        {
        	URL = CR.Init_prop().getProperty("SITAPIURL");
            
        }
        if (Environment.equals("PREVIEW"))
        {
        	URL = CR.Init_prop().getProperty("SITAPIURL");
            
        }
        if (Environment.equals("UAT"))
        {
        	
        	URL = CR.Init_prop().getProperty("UATAPIURL");
            
        }
        else
        {
            Assert.fail("Environment is Not specified in Config");
        }
        String URI = "";
        Constants.restURL = URL;
        if (EmployeeID.trim().equals(""))
        {
            URI = "EmpJob?$format=json&$select=employmentNav/jobInfoNav,positionNav,userId,managerId,position,businessUnit,costCenter,customString28,customString36,customString37,customString38,eventReason,employmentNav/isContingentWorker,employmentNav/jobInfoNav/company,employmentNav/jobInfoNav/positionNav/type,employmentNav/jobInfoNav/positionNav/cust_EmploymentType,employmentNav/jobInfoNav/positionNav/cust_EmployeeClass&$inlinecount=allpages&$top=1&$expand=employmentNav/jobInfoNav,positionNav&$filter=employmentNav/isContingentWorker+eq+false +and+employmentNav/jobInfoNav/company+eq+'" + testcompanyCODE + "'+and+employmentNav/jobInfoNav/positionNav/type+eq+'" + ej_PositionType + "'+and+employmentNav/jobInfoNav/positionNav/cust_EmploymentType+eq+'" + EmploymentType + "'+and+employmentNav/jobInfoNav/positionNav/cust_EmployeeClass+eq+'" + cust_EmployeeClass + "'+and+emplStatus+eq+'56734'";
            Constants.employeeID = RestAPI.GetEmployeeIDwithinyear(URL, URI);
        }
        else
        {
            Constants.employeeID = EmployeeID.trim();
        }
    }

	@Given("Entered the randomly generated Employee ID in the Search Field and click on Search")
	public void entered_the_randomly_generated_employee_id_in_the_search_field_and_click_on_search() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Capture the user name and Email id")
	public void capture_the_user_name_and_email_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User Proxy in as Employee")
	public void user_proxy_in_as_employee() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Click on My Profile tile from home page")
	public void click_on_my_profile_tile_from_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Click on the edit from the national ID information and enter all the details {string}")
	public void click_on_the_edit_from_the_national_id_information_and_enter_all_the_details(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("capture the approver and approve the request for NationalID update")
	public void capture_the_approver_and_approve_the_request_for_national_id_update() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Validate employee profile is updated with the national id")
	public void validate_employee_profile_is_updated_with_the_national_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Log generated with the required details {string} {string}")
	public void log_generated_with_the_required_details(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}

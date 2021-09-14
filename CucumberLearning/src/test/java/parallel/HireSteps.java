package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePageHire;
import pages.LoginPage;
import pages.LoginPageHire;
import pages.OnOffBoardingPage;
import pages.PeopleProfilePage;
import utilities.ConfigReader;
import utilities.Constants;
import utilities.ExcelReader;
import utilities.ResourceHelper;

public class HireSteps {
	ConfigReader CR= new ConfigReader();
	LoginPageHire Lph= new LoginPageHire(DriverFactory.getDriver());	
	private List<Map<String, String>> testdata;
	private String excelpath="\\src\\test\\resources\\Testdata\\Data.xlsx";
	private String Sheetname;
	private HomePageHire hph;
	private PeopleProfilePage Peoplepage;
	private OnOffBoardingPage OnOffBoardingPage; 
	
	
	
	@When("User validates an Hourly Intern TDS Validation with {string} {int}")
	public void user_validates_an_hourly_intern_tds_validation_with(String string, Integer int1) {
	    
	    
	}
	
		
		@Given("User has sucessfully launched the {string} {string}")
		public void user_has_sucessfully_launched_the(String sheetname, String URL) throws InvalidFormatException, IOException {
			Constants.Sheetname=sheetname;
			ExcelReader reader = new ExcelReader();		
			  testdata = reader.getData(ResourceHelper.GetResourcePath(excelpath), sheetname);
			String url = testdata.get(0).get("URL");
			DriverFactory.getDriver().get(url);

		}

	


	@Given("User Proxy in as HR OPS CurrentWave")
	public void user_proxy_in_as_hr_ops_current_wave() throws InvalidFormatException, IOException, InterruptedException {
		
		String username = CR.Init_prop().getProperty("username");
		String password = CR.Init_prop().getProperty("password");
		hph=Lph.LoginThePage(username, password);
		ExcelReader reader = new ExcelReader();
		//testdata=reader.getData(excelpath, Constants.Sheetname);
		String proxyuser = testdata.get(0).get("proxyuser");
		Peoplepage=hph.ProxyNow(proxyuser);
		
	}

	@Given("User Selects On\\/OffBoarding from the selection list")
	public void user_selects_on_off_boarding_from_the_selection_list() {
		OnOffBoardingPage=	Peoplepage.SelectOptionfromHomeDropdown("On/Offboarding 1.0");
		
	}

	@Given("User Selects Process from the On\\/OffBoarding Dashboard")
	public void user_selects_process_from_the_on_off_boarding_dashboard() {
		
		try {
			OnOffBoardingPage.SelectProcessfromOnOffBoardingDropdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("User Selects the Onboarding Tab {string}")
	public void user_selects_the_onboarding_tab(String country) {
		country=testdata.get(0).get("Country");
		 if(country.equals("USA"))
         {
			 OnOffBoardingPage.clickonUSOnboardingTab();
         }
         else
         {
        	 OnOffBoardingPage.clickonGlobalFullTimeOnboardingTab();
         }
		
		
	}

	@Given("User Clicks on Start button")
	public void user_clicks_on_start_button() {
		
		OnOffBoardingPage.clickonStart();
	}

	@Given("User fills the Intern hourly hire set up information {string} {string} {string}")
	public void user_fills_the_intern_hourly_hire_set_up_information(String tdsstartDateType, String tdsstartDate, String tdscompanycode) throws InterruptedException {
		
		OnOffBoardingPage.SwitchToFrame();
		OnOffBoardingPage.USPreverificationSteps();
		OnOffBoardingPage.NewHireSetupInformation(tdsstartDateType, tdsstartDate, tdscompanycode);
	}

	@Given("User fills the Job Information details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_fills_the_job_information_details(String CompanyCode, String EventReason, String iCIMSActionType, String PositionNo, String RestURL, String ej_PositionType, String cust_EmployeeClass, String EmploymentType, String PositionType, String RequisitionID, String RequisitionType, String ReportsToManager,String OnboardingAlias,String NEOlocation, String NEODate ) {
		
	}
		

	@Given("User Selects the US\\/Global FullTime Onboarding")
	public void user_selects_the_us_global_full_time_onboarding() {
		
	
	}

	@Given("User performs a search using the Position Number {string}")
	public void user_performs_a_search_using_the_position_number(String String) {
	
		
	}

	@Given("User selects the rehire record from the work Queue")
	public void user_selects_the_rehire_record_from_the_work_queue() {
		
		
	}

	@Given("User fills US\\/Global Pre Onboarding details for Intern Hire  {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_fills_us_global_pre_onboarding_details_for_intern_hire(String Country, String CompanyCode, String EventReason, String iCIMSActionType, String DOB, String PositionType, String PositionNo, String ej_PositionType, String cust_EmployeeClass, String EmploymentType) {
		{
            if (Country.equals(""))
            {
                Assert.fail("Please Fill the 'Country' Column in the TDS");
            }
            if (DOB.equals(""))
            {
                Assert.fail("Please Fill the 'DOB' Column in the TDS");
            }
            if (CompanyCode.equals(""))
            {
                Assert.fail("Please Fill the 'CompanyCode' Column in the TDS");
            }
            if (EventReason.equals(""))
            {
                Assert.fail("Please Fill the 'EventReason' Column in the TDS");
            }
            if (iCIMSActionType.equals(""))
            {
                Assert.fail("Please Fill the 'iCIMSActionType' Column in the TDS");
            }
            if (PositionType.equals(""))
            {
                Assert.fail("Please Fill the 'PositionType' Column in the TDS");
            }
            if (PositionNo.equals(""))
            {
                if (ej_PositionType.equals(""))
                {
                    Assert.fail("Please Fill the 'ej_PositionType' Column in the TDS");
                }
                if (cust_EmployeeClass.equals(""))
                {
                    Assert.fail("Please Fill the 'cust_EmployeeClass' Column in the TDS");
                }
                if (EmploymentType.equals(""))
                {
                    Assert.fail("Please Fill the 'EmploymentType' Column in the TDS");
                }
            }
        }
	}

	@Given("User navigates to MPH Page and select the record")
	public void user_navigates_to_mph_page_and_select_the_record() {
		
	}

	@Given("User completes the remaining steps for Intern Hourly Hire and submit {string} {string}")
	public void user_completes_the_remaining_steps_for_intern_hourly_hire_and_submit(String String, String String2) {
		
	}

	@Given("User searches the Hired Intern using first name and last name")
	public void user_searches_the_hired_intern_using_first_name_and_last_name() {
		
		
	}

	@Given("User changes the hire date")
	public void user_changes_the_hire_date() {
	
	
	}
}

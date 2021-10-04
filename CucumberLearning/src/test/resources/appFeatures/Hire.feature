
Feature: Hire Functionality
  This feature is to test Hire functionality

 

  
  Scenario Outline: Change the Hire date within 7 days from start date, before payroll is processed
    When User validates an Hourly Intern TDS Validation with "<sheetname>" <rownumber> 
    Given User has sucessfully launched the "<sheetname>" "<Enviornment>"
    And User Proxy in as HR OPS CurrentWave
	And User Selects On/OffBoarding from the selection list
	And User Selects Process from the On/OffBoarding Dashboard
	And User Selects the Onboarding Tab '<Country>'
	And User Clicks on Start button
	And User fills the Intern hourly hire set up information '<StartDateType>' '<StartDate>' '<CompanyCode>'	
	And User fills the Job Information details '<CompanyCode>' '<EventReason>' '<iCIMSActionType>' '<PositionNo>' '<RestURL>' '<ej_PositionType>' '<cust_EmployeeClass>' '<EmploymentType>' '<PositionType>' '<RequisitionID>' '<RequisitionType>' '<ReportsToManager>' '<OnboardingAlias>' '<NEOlocation>' '<NEODate>'
	And User Selects the US/Global FullTime Onboarding
	And User performs a search using the Position Number '<PositionNo>'
	And User selects the rehire record from the work Queue
	And User fills US/Global Pre Onboarding details for Intern Hire  '<DOB>' '<Gender>' '<MaritalStatus>' '<SSN>' '<IsHomePhone>' '<Disablility>' '<EmergencyContactName>' '<EmergencyRelationship>' '<EmergencyPhoneType>' '<EmergencyPhoneNumber>' '<EvacuationAssistance>'
	And User navigates to MPH Page and select the record
	And User completes the remaining steps for Intern Hourly Hire and submit '<CompanyCode>' '<WorkFactor>'
	And User searches the Hired Intern using first name and last name
	And User changes the hire date
	
	
	
    
    Examples: 
      |sheetname                        |rownumber|
      | Change_Hire_Date_B4_Pay_Process |1        |
      

Feature: ESS Data Change
	To Test the ESS data change functionality
	
	Scenario Outline: 
	Scenario Outline: BPRTESS02 - Update National ID
	When Update Personal Information TDS Validation "<sheetname>" <rownumber> 
	Given User has sucessfully launched the '<Enviornment>' and landed at Homepage
	And User gets a randon employee using '<EmployeeID>' '<Environments>' '<testcompanyCODE>' '<ej_PositionType>' '<cust_EmployeeClass>' '<EmploymentType>'
	And Entered the randomly generated Employee ID in the Search Field and click on Search
	And Capture the user name and Email id
	And User Proxy in as Employee
	And Click on My Profile tile from home page
	And Click on the edit from the national ID information and enter all the details '<Country>'
	And capture the approver and approve the request for NationalID update
	And Validate employee profile is updated with the national id
	Then Log generated with the required details '<TestSuite>' '<testcompanyCODE>'

	
Examples: 
      |sheetname|rownumber|Enviornment|
      | Address |1        |Enviornments|
      	
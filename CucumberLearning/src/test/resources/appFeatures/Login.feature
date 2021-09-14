Feature: TestLoginFeaturewithscenariooutline
Scenario Outline: Test the Loginfeatture withmulyiple data
Given User is on LoginPage
When user enters"<username>"
And User enters "<password>"
And  User clicks on Login button
Then user gets the title of the page
And page title should be"<title>"
Examples:
|username|password|title|
|borawakepp4@gmail.com|borawake81|My Store|
|incorrectusername|incorrectpassword|My Store|



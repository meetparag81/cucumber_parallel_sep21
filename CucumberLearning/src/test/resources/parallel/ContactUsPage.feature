Feature: ContactUsPage

Scenario Outline: Contact Us scenario with different set of data
Given user has already logged in to application
|username|password|
|borawakepp4@gmail.com|borawake81|

When User fills the form "<sheetname>" and <rownumber>
And Users clicks on SendButton
Then it shows a successful message "Your message has been successfully sent to our team."
Examples:
|sheetname|rownumber|
|Contacts| 0|
|Contacts|1|


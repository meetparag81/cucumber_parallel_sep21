Feature:Userregisteredtosite
Scenario:Regiter multiple users
When user is on RegistrationPage
When user enters following details
|bparag|bparag@gmail.com|pune|67876778|
|jkumar|jkumar@gmail.com|mumba|67876778|
Then user is on the registrationPage

Scenario:Regiter multiple users
When user is on RegistrationPage 
When user enters following details withcolumnname
|username|emailid|city|telephone|
|bparag|bparag@gmail.com|pune|67876778|
|jkumar|jkumar@gmail.com|mumba|67876778|
Then user is on the registrationPage

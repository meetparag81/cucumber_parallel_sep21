Feature: LoginToFecebook
Scenario:Logintest
verify that user is able to login on Facebook.com
Given User is on Facebook.com
When User Enters "bparag" and "bparag" 
And clicks on Login button
Then User is on Home Page
And User clics on the Homedropdown








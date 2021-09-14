#used to underdstand background keyword

Feature: CheckorderdetailsinAmazon.com site
  I want to use this template to check order details in Amazon Homepage

  Background:
  Given a registered user is given.
    Given a user is on amazonloginPage
    When user enters username
    When user enters password
    And user clicks on LoginButton

  Scenario: check previous order details
    
    When user clicks on OrderLink
    Then user checks the previous order Details
    
      Scenario: check open order details
    
    When user clicks on Open Orders Link
    Then user checks the Open order Details
    
      Scenario: check open order details
    
    When user clicks on cancelled Orders Link
    Then user checks the cancelled order Details
    

  
 

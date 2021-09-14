
@tag
Feature: UberBooking
  Book a car using Uber app

  @smoke
  Scenario: Bookig cab Sedan
    Given User wants to select car type"Sedan" from app
    When User selects cartype"Sedan" and  pickuppint "Pune" and destinaion "Mumbai"
    Then Driver starts the journey
    And Driver ends the journey
    Then User pays 1000 INR

  @Regression
  Scenario: Bookig cab SUV
    Given User wants to select car type"SUV" from app
    When User selects cartype"Sedan" and  pickuppint "Pune" and destinaion "Banglore"
    Then Driver starts the journey
    And Driver ends the journey
    Then User pays 1000 INR
    @Production
  Scenario: Bookig cab Sedan
    Given User wants to select car type"Mini car" from app
    When User selects cartype"Sedan" and  pickuppint "Pune" and destinaion "Lonavala"
    Then Driver starts the journey
    And Driver ends the journey
    Then User pays 1000 INR
    

    
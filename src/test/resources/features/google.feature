@google
Feature: Google
  Searching in google
  
  Scenario: Search 'Selenium' phrase in google
    Given I am on google main page
    When I search for "Selenium"
    Then I get result containing "Selenium" phrase
    
  Scenario: Search 'Puppy' phrase in google images
    Given I am on google page
    When I go to google images
    And I search for "Puppy" phrase
    Then I get result page with images of "Puppy"   
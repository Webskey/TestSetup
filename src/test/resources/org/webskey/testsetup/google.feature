@google
Feature: Google
  Searching in google
  
  Scenario: Search 'Selenium' phrase in google
    Given I am on google main page
    When I type "Selenium"
    And I sumbit
    Then I get result containing "Selenium" phrase
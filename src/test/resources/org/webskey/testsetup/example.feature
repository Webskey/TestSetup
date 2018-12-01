Feature: example
  This is example description of feature.
  
  Scenario Outline: Today is or is not Friday
    Given today is "<day>"
    When I ask whether it's Friday yet
    Then I should be told "<answer>"

  Examples:
    | day | answer |
    | Friday | Yes |
    | Sunday | Nope |
    | anything else! | Nope |
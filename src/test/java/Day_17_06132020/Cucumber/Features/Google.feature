Feature: Google Test scenarios
# scenario outline:  for multiple iteration
  Scenario Outline: TC01: Allow user to google search number on search result
    # you can use AND and When does not matter
    Given I navigate to google home page
    And I enter a keyword <Cars> on search field
    And I click on search icon
    And I capture search result and print
    And I click on More Icon
    Then I can select the value <more>

    Examples:
    | Cars |more|
    | Lexus |Videos|
    | Bmw   |Books|

    # Scenario: is only for one E2E test
    Scenario: TC02: Allow user to go to Google Sign in








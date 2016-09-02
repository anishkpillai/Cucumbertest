Feature: Test the google search
  Different scenarios for google search

  Scenario Outline: Search with keyword
    Given I navigate to Home Page
    When I search for keyword "<word>"
    Then I see search results with "<word>"
    And I close the browser

    Examples: 
      | word   |
      | apple  |
      | orange |
      | grapes |

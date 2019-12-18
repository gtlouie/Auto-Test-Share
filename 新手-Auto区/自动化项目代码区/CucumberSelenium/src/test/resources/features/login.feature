Feature: We want to test search function
  @Sprint1
  Scenario: test search function
    Given I am on Baidu page
    When  I input content
      | Fields         | Values       |
      |seachContent    |selenium      |
    And   I click the button

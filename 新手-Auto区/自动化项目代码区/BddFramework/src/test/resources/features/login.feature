@sprint1

Feature: We want to test login function

  @Mock
  Scenario: Customer input error account
    Given Interface expected to return results
      |code|ERR_NULL|
    Given I am on login page
    When  I input content
      | account     | jack       |
      | password    | 123456     |
      | code        | 123        |
    And   I click the button
    Then  I can see
      |loginMsg| 用户名密码错误  |


  @Mock
  Scenario: Customer input right account
    Given Interface expected to return results
      |code|200|
    Given I am on login page
    When  I input content
      | account     |  louie     |
      | password    | 123456     |
      | code        | 111111     |
    And   I click the button
    Then  I can see
      |loginMsg|  登录成功 |











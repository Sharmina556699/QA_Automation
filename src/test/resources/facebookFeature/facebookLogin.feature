@facebookLogin
Feature: Facebook Login
  Scenario Outline: Login with correct username and password
    Given User navigate to the login page
    When User enter the username "<username>"
    And User enter the password "<password>"
    And User click on the login button
    Then User should login successfully
    Examples:
      | username | password   |  |
      | liza23   | sharmina14 |  |



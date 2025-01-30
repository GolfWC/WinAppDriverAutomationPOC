Feature: Travelers Search Login

  Background:
    Given I am open the application
    When I enter my username and password
    Then I should be logged in the application


  Scenario: Verify if the application logout with valid credentials
    When I click on the logout button
    Then I should be logged out of the application


  Scenario Outline: Verify if the application logout with invalid username
    When I click on the logout button
    And  I click on exit application button
    And I enter invalid administrator "<username>" and valid "<password>"
    When I click on admin exit application button
    Then I should see an error message pop up
    And I re enter exit the application with valid credentials

        Examples:
            | username   | password   |
            | invalid    | securiport |


    Scenario Outline: Verify if the application logout with invalid password
    When I click on the logout button
    And  I click on exit application button
    And I enter valid administrator "<username>" and invalid "<password>"
    When I click on admin exit application button
    Then I should see an error message pop up
    And I re enter exit the application with valid credentials

        Examples:
            | username   | password   |
            | Admin      | invalid    |


    Scenario Outline: Verify if the application logout with invalid username and password
    When I click on the logout button
    And  I click on exit application button
    And I enter invalid administrator "<username>" and invalid "<password>"
    When I click on admin exit application button
    Then I should see an error message pop up
    And I re enter exit the application with valid credentials

        Examples:
            | username   | password   |
            | invalid    | invalid    |


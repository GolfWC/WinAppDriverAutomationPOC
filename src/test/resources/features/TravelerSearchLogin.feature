
Feature: Travelers Search Login

    Background:
        Given I am open the application



    Scenario: Verify application Login with valid credentials
        When I enter my username and password
        Then I should be logged in the application
        And I close the application


    Scenario Outline: Verify application Login with invalid username
        When I enter my invalid "<username>" and "<password>"
        And I click on the login button
        Then I should see an error message pop up
        And I exit the application

        Examples:
            | username | password |
            | user1    | securiport |



    Scenario Outline: Verify application Login with invalid password
        When I enter my "<username>" and invalid "<password>"
        And I click on the login button
        Then I should see an error message pop up
        And I exit the application

        Examples:
            | username | password |
            | Admin    | password1 |


    Scenario Outline: Verify application Login with invalid username and password
        When I enter my invalid "<username>" and invalid "<password>"
        And I click on the login button
        Then I should see an error message pop up
        And I exit the application

        Examples:
            | username | password |
            | user1    | password1 |














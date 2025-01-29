
Feature: Travelers Search Login

    Background:
        Given I am open the application
        When I enter my username and password
        Then I should be logged in the application

@smoke
    Scenario: Verify if the application and Login and logout with valid credentials
        When I click on the logout button
        Then I should be logged out of the application

@smoke
    Scenario: Validate travel search by last name
        When I search for a travel by last name
        And I click on the search button
        Then I should see the travel details displayed
        When I click on the logout button
        Then I should be logged out of the application


#    Scenario: Validate travel search by year
#        Given I am open the application
#        When I enter my username and password
#        Then I should be logged in the application
#        When I search for a travel by year
#        And I click on the search button
#        Then I should see an error message pop up
#        When I click on the logout button
#        Then I should be logged out of the application
#









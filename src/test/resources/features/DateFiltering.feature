Feature: Date Filtering

      Scenario: Validate travel search by year
        Given I am open the application
        When I enter my username and password
        Then I should be logged in the application
        When I search for a travel by year
        And I click on the search button
        Then I should see an error message pop up
        When I click on the logout button
        Then I should be logged out of the application
#
Feature:


#    Scenario: Verify if the application and Login and logout with valid credentials
#        Given I am open the application
#        When I enter my username and password
#        Then I should be logged in the application
#        When I click on the logout button
#        Then I should be logged out of the application



    Scenario: Validate travel search by last name
        Given I am open the application
        When I enter my username and password
        Then I should be logged in the application
        When I search for a travel by last name
        And I click on the search button
        Then I should see the travel details displayed
        When I click on the logout button
        Then I should be logged out of the application



#    Scenario: Open the application and Login with valid credentials
#        Given I am open the application
#        When I enter my username and password
#        Then I should be logged in the application
#        When I click on the logout button
#        Then I should be logged out of the application
#
#
#    Scenario: Open the application and Login with valid credentials
#        Given I am open the application
#        When I enter my username and password
#        Then I should be logged in the application
#        When I click on the logout button
#        Then I should be logged out of the application
#
#
#
#
#    Scenario: Open the application and Login with valid credentials
#        Given I am open the application
#        When I enter my username and password
#        Then I should be logged in the application
#        When I click on the logout button
#        Then I should be logged out of the application
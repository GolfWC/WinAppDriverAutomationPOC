Feature: Travelers Search Main Screen

  Background:
    Given I am open the application
    When I enter my username and password
    Then I should be logged in the application

@smoke
    Scenario Outline: Validate travel search by last name with unique lastname
        When I search for a travel by valid last name "<last_name>"
        And I click on the search button
        Then I should see the travel details displayed
        When I click on the logout button
        Then I should be logged out of the application

        Examples:
            | last_name |
            | RAY      |

    Scenario Outline: Verify travel search by last name who's last name contains same string
        When I search for a travel by valid last name "<last_name>"
        And I click on the search button
        Then I should see multiple travels details display who's last name contains same string
        When I click on the logout button
        Then I should be logged out of the application

        Examples:
            | last_name |
            | Si      |

    Scenario Outline: Validate travel search by last name with invalid lastname
        When I search for a travel by invalid last name "<last_name>"
        And I click on the search button
        Then I should not see the travel details displayed
        When I click on the logout button
        Then I should be logged out of the application

        Examples:
            | last_name |
            | ZvYEYZ     |






  Scenario: Validate travel search by exact last name
    When I search for a travel by last name
    And I click on exact last name check box
    Then I should see the exact traveler last name  details displayed
    When I click on the logout button
    Then I should be logged out of the application



    Scenario: Validate travel search by document
        When I search for a travel by document
        Then I should see the traveler details display respect to type of document
        When I click on the logout button
        Then I should be logged out of the application


    Scenario: Validate travel search by exact document
        When I search for a travel by document
        And I click on exact document check box
        Then I should see the traveler details display respect to exact traveler document type
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by first name
        When I search for a travel by first name
        Then I should see the traveler details display respect to first name
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by exact first name
        When I search for a travel by first name
        And I click on exact first name check box
        Then I should see the traveler details display respect to exact first name
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by Visa ID
        When I search for a travel by Visa ID
        Then I should see the traveler details display respect to Visa ID
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by exact Visa ID
        When I search for a travel by Visa ID
        And I click on exact Visa ID check box
        Then I should see the traveler details display respect to exact Visa ID
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by Date of Birth
        When I search for a travel by Date of Birth
        Then I should see the traveler details display respect to Date of Birth
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by Date of Birth range
        When I search for a travel by Date of Birth range
        Then I should see the traveler details display respect to Date of Birth range
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by Enrollment Date
        When I search for a travel by Enrollment Date
        Then I should see the traveler details display respect to Enrollment Date
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by Enrollment Date range
        When I search for a travel by Enrollment Date range
        Then I should see the traveler details display respect to Enrollment Date range
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by gender
        When I search for a travel by gender
        Then I should see the traveler details display respect to gender provided
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by mode of travel
        When I search for a travel by mode of travel
        Then I should see the traveler details display respect to mode of travel provided
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by all fields
        When I search for a travel by All fields
        Then I should see the traveler details display respect to all fields provided
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by free text Box
        When I search for a traveler by free text Box
        Then I should see the traveler details display respect to free text Box provided
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate travel search by exact free text Box
        When I enter message in free text Box
        And I click on exact free text check box
        Then I should see the traveler details display respect to exact free text Box provided
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate if all Nationalities are checked
        When I click on Nationalities
        And I will see all nationalities checked
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate if all Stations are checked
        When I click on Stations
        And I will see all stations checked
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate if all Users are checked
        When I click on Users
        And I will see all users checked
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate if all Carriers are checked
        When I click on Carriers
        And I will see all carriers checked
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate if all Origin Destination are checked
        When I click on Origin Destination
        And I will see all Origin Destination checked
        When I click on the logout button
        Then I should be logged out of the application

    Scenario: Validate if all Vehicle Type are checked
        When I click on Vehicle Type
        And I will see all Vehicle Type checked
        When I click on the logout button
        Then I should be logged out of the application

package Stepdefinition;

import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Hook.Hook;
import org.openqa.selenium.WebElement;
import pages.TravelerSearchLoginPage;

public class TravelerSearchLoginStep {

    WindowsDriver<WebElement> driver = Hook.getDriver();
    TravelerSearchLoginPage loginPage = new TravelerSearchLoginPage(driver);
    BasePage basePage = new BasePage(driver);


    @Given("I am open the application")
    public void i_am_open_the_application() {
        loginPage.enterUsername(basePage.getProperties("username"));
    }
    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
      loginPage.enterPassword(basePage.getProperties("password"));
    }
    @Then("I should be logged in the application")
    public void i_should_be_logged_in_the_application() {
       loginPage.clickLoginButton();
    }

    @When("I click on the logout button")
    public void i_click_on_the_logout_button() {
        loginPage.clickOffButton();
    }
    @Then("I should be logged out of the application")
    public void i_should_be_logged_out_of_the_application()  {
        loginPage.clickLogoutButton();
        loginPage.enterAdminExitUsername(basePage.getProperties("adminExitUsername"));
        loginPage.enterAdminExitPassword(basePage.getProperties("adminExitPassword"));
        loginPage.clickAdminExitButton();
    }

    @When("I search for a travel by last name")
    public void i_search_for_a_travel_by_last_name()  {
        loginPage.enterLastName("GOLF");

    }
    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        loginPage.clickSearchButton();



    }
    @Then("I should see the travel details displayed")
    public void i_should_see_the_travel_details_displayed() throws InterruptedException {
       // loginPage.getTravelDetails("Last Name", "0");
        loginPage.viewTravelDetails("view", "0");
    }

    @When("I search for a travel by year")
    public void i_search_for_a_travel_by_year()  {
        loginPage.enterStartDateOfBirth("1990", "01", "01");
//        loginPage.enterEndDateOfBirth("2000", "02", "02");
//        loginPage.clickDateOfBirthRange("31-40");
//        loginPage.enterStartEnrollmentDate("2020", "01", "01");
//        loginPage.enterEndEnrollmentDate("2025", "02", "02");

    }

    @Then("I should see an error message pop up")
    public void i_should_see_an_error_message_pop_up()  {
        loginPage.invalidDateRange();
    }

    @When("I click on exact last name check box")
    public void i_click_on_exact_last_name_check_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by document")
    public void i_search_for_a_travel_by_document() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on exact document check box")
    public void i_click_on_exact_document_check_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by first name")
    public void i_search_for_a_travel_by_first_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on exact first name check box")
    public void i_click_on_exact_first_name_check_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by Visa ID")
    public void i_search_for_a_travel_by_visa_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on exact Visa ID check box")
    public void i_click_on_exact_visa_id_check_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by Date of Birth")
    public void i_search_for_a_travel_by_date_of_birth() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by Date of Birth range")
    public void i_search_for_a_travel_by_date_of_birth_range() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by Enrollment Date")
    public void i_search_for_a_travel_by_enrollment_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by Enrollment Date range")
    public void i_search_for_a_travel_by_enrollment_date_range() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by gender")
    public void i_search_for_a_travel_by_gender() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a travel by mode of travel")
    public void i_search_for_a_travel_by_mode_of_travel() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I search for a travel by All fields")
    public void i_search_for_a_travel_by_all_fields() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I search for a traveler by free text Box")
    public void i_search_for_a_traveler_by_free_text_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on exact free text check box")
    public void i_click_on_exact_free_text_check_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Nationalities")
    public void i_click_on_nationalities() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I will see all nationalities checked")
    public void i_will_see_all_nationalities_checked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Stations")
    public void i_click_on_stations() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I will see all stations checked")
    public void i_will_see_all_stations_checked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Users")
    public void i_click_on_users() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I will see all users checked")
    public void i_will_see_all_users_checked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Carriers")
    public void i_click_on_carriers() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I will see all carriers checked")
    public void i_will_see_all_carriers_checked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Origin Destination")
    public void i_click_on_origin_destination() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I will see all Origin Destination checked")
    public void i_will_see_all_origin_destination_checked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Vehicle Type")
    public void i_click_on_vehicle_type() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I will see all Vehicle Type checked")
    public void i_will_see_all_vehicle_type_checked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Clear Button")
    public void i_click_on_clear_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}

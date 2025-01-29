package Stepdefinition;

import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Hook.Hook;
import org.openqa.selenium.WebElement;
import pages.ApplicationLoginPage;

public class ApplicationLoginStep  {

    WindowsDriver<WebElement> driver = Hook.getDriver();
    ApplicationLoginPage loginPage = new ApplicationLoginPage(driver);
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



}

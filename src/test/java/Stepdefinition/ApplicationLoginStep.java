package Stepdefinition;

import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Hook.Hook;
import pages.ApplicationLoginPage;

import java.util.Properties;

public class ApplicationLoginStep  {

    WindowsDriver driver = Hook.getDriver();
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
    public void i_should_be_logged_out_of_the_application() throws InterruptedException {
        loginPage.clickLogoutButton();
        loginPage.enterAdminExitUsername(basePage.getProperties("adminExitUsername"));
        loginPage.enterAdminExitPassword(basePage.getProperties("adminExitPassword"));
        loginPage.clickAdminExitButton();
    }

    @When("I search for a travel by last name")
    public void i_search_for_a_travel_by_last_name() throws InterruptedException {
        loginPage.enterLastName("GOLF");
    }
    @When("I click on the search button")
    public void i_click_on_the_search_button() throws InterruptedException {
        loginPage.clickSearchButton();
    }
    @Then("I should see the travel details displayed")
    public void i_should_see_the_travel_details_displayed() throws InterruptedException {
       // loginPage.getTravelDetails("Last Name", "0");
        loginPage.viewTravelDetails("view", "0");
    }


}

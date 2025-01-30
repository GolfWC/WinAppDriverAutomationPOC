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

    }

    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        loginPage.enterUsername(basePage.getProperties("username"));
        loginPage.enterPassword(basePage.getProperties("password"));
    }

    @Then("I should be logged in the application")
    public void i_should_be_logged_in_the_application() {
       loginPage.clickLoginButton();
       loginPage.verifyTravelersSearchHeader();
    }

    @Then("I close the application")
    public void i_close_the_application() {
        loginPage.clickOffButton();
        loginPage.clickLogoutButton();
        loginPage.enterAdminExitUsername(basePage.getProperties("adminExitUsername"));
        loginPage.enterAdminExitPassword(basePage.getProperties("adminExitPassword"));
        loginPage.clickAdminExitButton();
    }

    @When("I enter my invalid {string} and {string}")
    public void i_enter_my_invalid_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I enter my {string} and invalid {string}")
    public void i_enter_my_and_invalid(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I enter my invalid {string} and invalid {string}")
    public void i_enter_my_invalid_and_invalid(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }


    @Then("I exit the application")
    public void i_exit_the_application() {
        loginPage.clickLogoutButton();
        loginPage.enterAdminExitUsername(basePage.getProperties("adminExitUsername"));
        loginPage.enterAdminExitPassword(basePage.getProperties("adminExitPassword"));
        loginPage.clickAdminExitButton();
    }


    @Then("I should see an error message pop up")
    public void i_should_see_an_error_message_pop_up() throws InterruptedException {
        loginPage.verifyLoginErrorMessage();
    }























}

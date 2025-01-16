package Stepdefinition;

import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Hook.Hook;
import pages.ApplicationLoginPage;

public class ApplicationLoginStep {

    WindowsDriver driver = Hook.getDriver();
    ApplicationLoginPage loginPage = new ApplicationLoginPage(driver);

    @Given("I am open the application")
    public void i_am_open_the_application() {
        loginPage.enterUsername("Admin");
    }
    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
      loginPage.enterPassword("securiport");
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
    }


}

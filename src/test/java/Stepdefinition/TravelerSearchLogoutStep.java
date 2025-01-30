package Stepdefinition;

import Hook.Hook;
import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.TravelerSearchLoginPage;

public class TravelerSearchLogoutStep {

    WindowsDriver<WebElement> driver = Hook.getDriver();
    TravelerSearchLoginPage loginPage = new TravelerSearchLoginPage(driver);
    BasePage basePage = new BasePage(driver);

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


    @When("I click on exit application button")
    public void i_click_on_exit_application_button() {
        loginPage.clickLogoutButton();
    }

    @Then("I enter invalid administrator {string} and valid {string}")
    public void i_enter_invalid_administrator_and_valid(String username, String password) {
        loginPage.enterAdminExitUsername(username);
        loginPage.enterAdminExitPassword(password);

    }

    @When("I enter valid administrator {string} and invalid {string}")
    public void i_enter_valid_administrator_and_invalid(String username, String password) {
        loginPage.enterAdminExitUsername(username);
        loginPage.enterAdminExitPassword(password);
    }
    @When("I enter invalid administrator {string} and invalid {string}")
    public void i_enter_invalid_administrator_and_invalid(String username, String password) {
        loginPage.enterAdminExitUsername(username);
        loginPage.enterAdminExitPassword(password);
    }


    @When("I click on admin exit application button")
    public void i_click_on_admin_exit_application_button() {
        loginPage.clickAdminExitButton();
    }

    @Then("I re enter exit the application with valid credentials")
    public void i_re_enter_exit_the_application_with_valid_credentials() {
        loginPage.enterAdminExitUsername(basePage.getProperties("adminExitUsername"));
        loginPage.enterAdminExitPassword(basePage.getProperties("adminExitPassword"));
        loginPage.clickAdminExitButton();
    }




}

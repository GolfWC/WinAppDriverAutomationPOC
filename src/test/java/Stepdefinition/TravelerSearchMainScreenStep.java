package Stepdefinition;

import Hook.Hook;
import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.TravelerSearchLoginPage;

public class TravelerSearchMainScreenStep {

    WindowsDriver<WebElement> driver = Hook.getDriver();
    TravelerSearchLoginPage loginPage = new TravelerSearchLoginPage(driver);
    BasePage basePage = new BasePage(driver);

    @When("I search for a travel by valid last name {string}")
    public void i_search_for_a_travel_by_valid_last_name(String lastName) {
        String upperCaseLastName = lastName.toUpperCase();
        loginPage.enterLastName(upperCaseLastName);
    }

}

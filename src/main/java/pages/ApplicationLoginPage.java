package pages;

import io.appium.java_client.FindsByAccessibilityId;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.support.PageFactory;

public class ApplicationLoginPage {

    WindowsDriver driver;
    public ApplicationLoginPage(WindowsDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterUsername(String name) {
        driver.findElementByAccessibilityId("tbUsername").click();
        driver.findElementByAccessibilityId("tbUsername").sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElementByAccessibilityId("tbPassword").click();
        driver.findElementByAccessibilityId("tbPassword").sendKeys(password);

    }

    public void clickLoginButton() {
        driver.findElementByName("Login").click();
    }

}

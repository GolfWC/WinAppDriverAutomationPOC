package pages;


import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ApplicationLoginPage extends BasePage {


    public ApplicationLoginPage(WindowsDriver driver) {
        super(driver);

    }

//    Set<String> allWindowHandles = driver.getWindowHandles();
//    List<String> list = new ArrayList<String>(allWindowHandles);
//    String currentWindowHandle = driver.getWindowHandle();
//    public void switchToNewWindow() {
//        for (String windowHandle : allWindowHandles) {
//            if (!windowHandle.equals(currentWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//    }
//    public ApplicationLoginPage(WindowsDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }


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

   ;

    public void clickOffButton() {
        switchToWindow();
        driver.findElementByName("Log off").click();

    }



    public void clickLogoutButton() throws InterruptedException {
        // Switch to the new window
        switchToWindow();


        driver.findElementByAccessibilityId("iconExit").click();
       // switchToNewWindow();
        driver.findElementByAccessibilityId("tbUsernameExit").sendKeys("Admin");
        driver.findElementByAccessibilityId("tbPasswordExit").sendKeys("securiport");
        driver.findElementByName("Exit").click();
        Thread.sleep(5000);
    }



}



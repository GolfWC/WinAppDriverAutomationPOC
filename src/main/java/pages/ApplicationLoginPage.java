package pages;


import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;


public class ApplicationLoginPage extends BasePage {


    public ApplicationLoginPage(WindowsDriver driver) {
        super(driver);
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

   ;

    public void clickOffButton() {

        switchToWindow();
        driver.findElementByName("Log off").click();

    }

    public void clickLogoutButton() throws InterruptedException {
        Thread.sleep(2000);
        switchToWindow();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("iconExit").click();
        driver.findElementByAccessibilityId("tbUsernameExit").sendKeys("Admin");
        driver.findElementByAccessibilityId("tbPasswordExit").sendKeys("securiport");
        driver.findElementByName("Exit").click();

    }

    public void enterLastName(String lastName) {
        switchToWindow();
        driver.findElementByAccessibilityId("txtLastName").click();
        driver.findElementByAccessibilityId("txtLastName").sendKeys(lastName);
    }

    public void clickSearchButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElementByName("Search").click();
        Thread.sleep(3000);
       String text = driver.findElementByXPath("//*[@LocalizedControlType='edit' and contains(@Name,'Row 0')]").getText();

        System.out.println(text);
    }

    public void getTravelDetails() {
        switchToWindow();
        driver.findElementByName("Traveler Details").click();
    }



}



package pages;


import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ApplicationLoginPage extends BasePage {


    public ApplicationLoginPage(WindowsDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='tbUsername']")
    public WebElement usernameText;

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='tbPassword']")
    public WebElement passwordText;

    @FindBy(xpath = "//*[@LocalizedControlType='button' and @Name='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@LocalizedControlType='button' and @Name='Log off']")
    public WebElement offButton;

    @FindBy(xpath = "//*[@LocalizedControlType='pane' and @AutomationId='iconExit']")
    public WebElement exitButton;

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='tbUsernameExit']")
    public WebElement exitUsernameText;

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='tbPasswordExit']")
    public WebElement exitPasswordText;

    @FindBy(xpath = "//*[@LocalizedControlType='button' and @Name='Exit']")
    public WebElement adminExitButton;









    public void enterUsername(String name) {
        usernameText.click();
        usernameText.sendKeys(name);
    }

    public void enterPassword(String password) {
        passwordText.click();
        passwordText.sendKeys(password);

    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickOffButton() {
        switchToWindow();
        offButton.click();
    }

    public void clickLogoutButton() throws InterruptedException {
        Thread.sleep(2000);
        switchToWindow();
        Thread.sleep(2000);
        exitButton.click();
    }

    public void enterAdminExitUsername(String username) throws InterruptedException {
        Thread.sleep(1000);
        exitUsernameText.click();
        exitUsernameText.sendKeys(username);
    }

    public void enterAdminExitPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        exitPasswordText.click();
        exitPasswordText.sendKeys(password);
    }

    public void clickAdminExitButton() throws InterruptedException {
        Thread.sleep(1000);
        adminExitButton.click();
    }

    public void enterLastName(String lastName) throws InterruptedException {
        Thread.sleep(2000);
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



package pages;


import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;


public class ApplicationLoginPage extends BasePage {


    private static final Logger log = LoggerFactory.getLogger(ApplicationLoginPage.class);

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

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='txtLastName']")
    public WebElement lastNameText;

    @FindBy(xpath = "//*[@LocalizedControlType='check box' and @AutomationId='checkBoxLastNameExact']")
    public WebElement lastNameExactCheckBox;

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='txtDocument']")
    public WebElement documentText;

    @FindBy(xpath = "//*[@LocalizedControlType='check box' and @AutomationId='checkBoxDocumentIDExact']")
    public WebElement documentExactCheckBox;

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='txtFirstName']")
    public WebElement firstNameText;

    @FindBy(xpath = "//*[@LocalizedControlType='check box' and @AutomationId='checkBoxFirstNameExact']")
    public WebElement firstNameExactCheckBox;

    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='txtVISA']")
    public WebElement visaText;

    @FindBy(xpath = "//*[@LocalizedControlType='check box' and @AutomationId='checkBoxVisaIDExact']")
    public WebElement visaExactCheckBox;

//    @FindBy(xpath = "//*[@LocalizedControlType='edit' and @AutomationId='txtDateYear']")
//    public WebElement yearText;


    @FindBy(xpath = "//*[@LocalizedControlType='button' and @Name='Search']")
    public WebElement searchButton;











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
        Thread.sleep(1000);
        switchToWindow();
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        switchToWindow();
        lastNameText.click();
        lastNameText.sendKeys(lastName);
    }




    public void clickSearchButton() throws InterruptedException {
    //    Thread.sleep(1000);
        searchButton.click();
        Thread.sleep(1000);
    }

    public void getTravelDetails(String tableName, String rowNumber) {
        String text = readTableData(tableName, rowNumber);
        System.out.println("The traveler "+ tableName + " is " +text);

    }

    public void viewTravelDetails(String tableName, String rowNumber) throws InterruptedException {
        viewTableData(tableName, rowNumber);
        log.info("Viewed the travel details");

    }


    public void entertextYear() throws InterruptedException {

        Thread.sleep(1000);
        switchToWindow();

        List<WebElement> getYearTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateYear']"));
        System.out.println("The size of the year text fields is " + getYearTextFields.size());
        getYearTextFields.get(0).click();
        getYearTextFields.get(0).sendKeys("1995");
        getYearTextFields.get(1).click();
        getYearTextFields.get(1).sendKeys("1950");
    }


    @FindBy(name="Invalid Date" )
    public WebElement invalidDateRange;

    @FindBy(name="OK")
    public WebElement okButton;

    public void invalidDateRange() throws InterruptedException {

        // Switch to the pop-up window
//        String mainWindowHandle = driver.getWindowHandle();
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(mainWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
        switchToPopUpWindow();
        // Interact with elements in the pop-up window
        WebElement warningMessage = driver.findElement(By.name("Invalid Date"));
        Assert.assertTrue(warningMessage.isDisplayed());
        WebElement okButton = driver.findElement(By.name("OK"));
        okButton.click();
    }

}



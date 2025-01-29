package pages;


import Utils.BasePage;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ApplicationLoginPage extends BasePage {


    private static final Logger log = LoggerFactory.getLogger(ApplicationLoginPage.class);

    public ApplicationLoginPage(WindowsDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set implicit wait
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

    public void clickLogoutButton() {
        switchToWindow();
        exitButton.click();
    }

    public void enterAdminExitUsername(String username)  {
        exitUsernameText.click();
        exitUsernameText.sendKeys(username);
    }

    public void enterAdminExitPassword(String password)  {

        exitPasswordText.click();
        exitPasswordText.sendKeys(password);
    }

    public void clickAdminExitButton() {

        adminExitButton.click();
    }

    public void enterLastName(String lastName)  {

        switchToWindow();
        lastNameText.click();
        lastNameText.sendKeys(lastName);
    }

    public void clickOnLastNameExactCheckBox()  {
        lastNameExactCheckBox.click();
    }

    public void enterDocument(String document)  {
        switchToWindow();
        documentText.click();
        documentText.sendKeys(document);
    }

    public void clickOnDocumentExactCheckBox()  {
        documentExactCheckBox.click();
    }

    public void enterFirstName(String firstName)  {
        switchToWindow();
        firstNameText.click();
        firstNameText.sendKeys(firstName);
    }

    public void clickOnFirstNameExactCheckBox()  {
        firstNameExactCheckBox.click();
    }

    public void enterVisa(String visa)  {
        switchToWindow();
        visaText.click();
        visaText.sendKeys(visa);
    }

    public void clickOnVisaExactCheckBox()  {
        visaExactCheckBox.click();
    }




    public void clickSearchButton()  {

        searchButton.click();
    }

    public void getTravelDetails(String tableName, String rowNumber) {
        String text = readTableData(tableName, rowNumber);
        System.out.println("The traveler "+ tableName + " is " +text);

    }

    public void viewTravelDetails(String tableName, String rowNumber) throws InterruptedException {
        viewTableData(tableName, rowNumber);
        log.info("Viewed the travel details");

    }


    public void enterStartDateOfBirth(String year, String month, String day)  {

        switchToWindow();
        List<WebElement> getYearTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateYear']"));
        System.out.println("The size of the year text fields is " + getYearTextFields.size());
        getYearTextFields.get(0).click();
        getYearTextFields.get(0).sendKeys(year);

       List<WebElement> getMonthTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateMonth']"));
        System.out.println("The size of the month text fields is " + getMonthTextFields.size());
        getMonthTextFields.get(0).click();
        getMonthTextFields.get(0).sendKeys(month);

        List<WebElement> getDayTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateDay']"));
        System.out.println("The size of the day text fields is " + getDayTextFields.size());
        getDayTextFields.get(0).click();
        getDayTextFields.get(0).sendKeys(day);

    }


    public void enterEndDateOfBirth(String year, String month, String day)  {
        switchToWindow();
        List<WebElement> getYearTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateYear']"));
        System.out.println("The size of the year text fields is " + getYearTextFields.size());
        getYearTextFields.get(1).click();
        getYearTextFields.get(1).sendKeys(year);

       List<WebElement> getMonthTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateMonth']"));
        System.out.println("The size of the month text fields is " + getMonthTextFields.size());
        getMonthTextFields.get(1).click();
        getMonthTextFields.get(1).sendKeys(month);

        List<WebElement> getDayTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateDay']"));
        System.out.println("The size of the day text fields is " + getDayTextFields.size());
        getDayTextFields.get(1).click();
        getDayTextFields.get(1).sendKeys(day);

    }

    public void enterEndEnrollmentDate(String year, String month, String day)  {
        switchToWindow();
        List<WebElement> getYearTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateYear']"));
        System.out.println("The size of the year text fields is " + getYearTextFields.size());
        getYearTextFields.get(2).click();
        getYearTextFields.get(2).sendKeys(year);


        List<WebElement> getMonthTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateMonth']"));
        System.out.println("The size of the month text fields is " + getMonthTextFields.size());
        getMonthTextFields.get(2).click();
        getMonthTextFields.get(2).sendKeys(month);

        List<WebElement> getDayTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateDay']"));
        System.out.println("The size of the day text fields is " + getDayTextFields.size());
        getDayTextFields.get(2).click();
        getDayTextFields.get(2).sendKeys(day);


    }

    public void enterStartEnrollmentDate(String year, String month, String day)  {
        switchToWindow();
        List<WebElement> getYearTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateYear']"));
        System.out.println("The size of the year text fields is " + getYearTextFields.size());
        getYearTextFields.get(3).click();
        getYearTextFields.get(3).sendKeys(year);

        List<WebElement> getMonthTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateMonth']"));
        System.out.println("The size of the month text fields is " + getMonthTextFields.size());
        getMonthTextFields.get(3).click();
        getMonthTextFields.get(3).sendKeys(month);

        List<WebElement> getDayTextFields =driver.findElements(By.xpath("//*[@LocalizedControlType='edit' and @AutomationId='txtDateDay']"));
        System.out.println("The size of the day text fields is " + getDayTextFields.size());
        getDayTextFields.get(3).click();
        getDayTextFields.get(3).sendKeys(day);

    }


    @FindBy(xpath = "//*[@LocalizedControlType='combo box' and @AutomationId='ddlDOBRange']")
    public WebElement dateOfBirthRange;


    public void clickDateOfBirthRange(String range)  {
        switchToWindow();
        dateOfBirthRange.click();

        switchToPopUpWindow();
        driver.findElementByName(range).click();



    }



    @FindBy(name="Invalid Date" )
    public WebElement invalidDateRange;

    @FindBy(name="OK")
    public WebElement okButton;

    public void invalidDateRange()  {

        switchToPopUpWindow();
        // Interact with elements in the pop-up window
        WebElement warningMessage = driver.findElement(By.name("Invalid Date"));
        Assert.assertTrue(warningMessage.isDisplayed());
        WebElement okButton = driver.findElement(By.name("OK"));
        okButton.click();
    }

}



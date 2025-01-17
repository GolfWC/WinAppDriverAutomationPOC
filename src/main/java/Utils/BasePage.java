package Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class BasePage {

    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected WindowsDriver driver;

    public BasePage(WindowsDriver driver) {
        this.driver = driver;
    }
    Properties properties = new Properties();



    public String getProperties(String key) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/testData/travelSearchData.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    public void switchToWindow(String expectedWindowTitle) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(expectedWindowTitle)) {
                return;
            }
        }
        throw new RuntimeException("Window with title '" + expectedWindowTitle + "' not found.");
    }

    public void switchToWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            System.out.println("Window handle: " + handle);
            driver.switchTo().window(handle);
        }
    }


    public String readTableData(String tableName, String rowNumber) {
        WebElement table = driver.findElement(By.xpath("//*[@LocalizedControlType='edit' and contains(@Name,'"+tableName+ " Row "+rowNumber+"')]"));

        return table.getText();
    }

    public void viewTableData(String tableName, String rowNumber) throws InterruptedException {
        WebElement table = driver.findElement(By.xpath("//*[@LocalizedControlType='button' and contains(@Name,'"+tableName+ " Row "+rowNumber+"')]"));
        Thread.sleep(2000);
        moveToOffset(1650,537);
        doubleClick(table);
        log.info("Clicked on the table data");
        Thread.sleep(5000);

    }

    public void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    public void moveToOffset(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(xOffset,yOffset).build().perform();
    }


    public void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(sourceElement)
                .moveToElement(targetElement)
                .release(targetElement)
                .build();
        dragAndDrop.perform();
    }

    public void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void scrollIntoView(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollDown() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(java.awt.event.KeyEvent.VK_PAGE_DOWN);
    }

    public void scrollUp() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_PAGE_UP);
        robot.keyRelease(java.awt.event.KeyEvent.VK_PAGE_UP);
    }

    public void scrollRight() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_RIGHT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_RIGHT);
    }

    public void scrollLeft() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_LEFT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_LEFT);
    }

    public void keyBoardEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
    }

    public void zoomIn() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(java.awt.event.KeyEvent.VK_ADD);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ADD);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
    }

    public void zoomOut() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(java.awt.event.KeyEvent.VK_SUBTRACT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_SUBTRACT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
    }

    public void zoomReset() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(java.awt.event.KeyEvent.VK_0);
        robot.keyRelease(java.awt.event.KeyEvent.VK_0);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
    }

    public void closeWindow() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
        robot.keyPress(java.awt.event.KeyEvent.VK_F4);
        robot.keyRelease(java.awt.event.KeyEvent.VK_F4);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
    }

    public void refreshPage() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_F5);
        robot.keyRelease(java.awt.event.KeyEvent.VK_F5);
    }

    public void navigateBack() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
        robot.keyPress(java.awt.event.KeyEvent.VK_LEFT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_LEFT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
    }

    public void navigateForward() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
        robot.keyPress(java.awt.event.KeyEvent.VK_RIGHT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_RIGHT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }











}

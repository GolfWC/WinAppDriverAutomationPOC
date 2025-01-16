package Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class BasePage {

    protected WindowsDriver driver;

    public BasePage(WindowsDriver driver) {
        this.driver = driver;
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
//    public WebElement findElementByName(String name) {
//        return driver.findElementByName(name);
//    }




}

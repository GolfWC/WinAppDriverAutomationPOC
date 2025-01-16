package Utils;

import io.appium.java_client.windows.WindowsDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class BasePage {

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










}

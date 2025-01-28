package Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class WindowsDriverManager {
    private static ThreadLocal<WindowsDriver> driver = new ThreadLocal<>();

    public static WindowsDriver getDriver() {
        if (driver.get() == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Securiport\\IICS_iics-15.0-releaseiics-15.0-release-20250107.1\\Clients\\Traveler Search\\Securiport.BMSys.WinApp.TravelersSearch.exe");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
            try {
                driver.set(new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

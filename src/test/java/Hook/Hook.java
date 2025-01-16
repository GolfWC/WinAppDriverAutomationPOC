package Hook;

import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hook {
    private static WindowsDriver driver;

    @Before
        public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //    capabilities.setCapability("app", "c:\\windows\\system32\\notepad.exe");
        capabilities.setCapability("app", "C:\\Securiport\\IICS_iics-15.0-releaseiics-15.0-release-20250107.1\\Clients\\Traveler Search\\Securiport.BMSys.WinApp.TravelersSearch.exe");
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");


        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
        }
        Thread.sleep(5000);
    }

    public static WindowsDriver getDriver() {
        return driver;
    }

}

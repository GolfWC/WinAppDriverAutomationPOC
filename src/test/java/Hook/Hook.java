package Hook;

import Utils.BasePage;
import Utils.Screenshot;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.*;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Hook {
    private static WindowsDriver driver;
    BasePage basePage ;
    Logger log = Logger.getLogger(Hook.class.getName());

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

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario) {
        if (driver != null) {
            try {
                final byte[] screenshot = BasePage.driver.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                log.info("Screenshot taken for step: " + scenario.getName());
            } catch (NoSuchWindowException e) {
                log.warning("Window already closed, unable to take screenshot.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {

        if (driver != null) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            driver.quit();
        }
        Thread.sleep(5000);
    }

    public static WindowsDriver getDriver() {
        return driver;
    }

}

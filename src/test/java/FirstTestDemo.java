//import io.appium.java_client.windows.WindowsDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.*;
//
//import java.net.URL;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//public class FirstTestDemo {
////
////    private static WindowsDriver driver;
////    private String originalWindowHandle;
////
////    @BeforeMethod
////    public void setUp() {
////
////        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("app", "c:\\windows\\system32\\notepad.exe");
//// //       capabilities.setCapability("app", "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Accessories");
////        capabilities.setCapability("platformName", "Windows");
////        capabilities.setCapability("deviceName", "WindowsPC");
////
////
////        try {
////            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
////        }
////        catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////        originalWindowHandle = driver.getWindowHandle();
////    }
////
//////    @AfterMethod
//////    public void tearDown() throws IOException, InterruptedException, AWTException {
//////        driver.quit();
//////    }
//////
//////    @AfterSuite
//////    public void close() {
//////        driver.quit();
//////    }
////
////    @org.testng.annotations.Test
////    public void test() throws InterruptedException {
////        driver.findElementByAccessibilityId("tbUsername").click();
////        driver.findElementByAccessibilityId("tbUsername").sendKeys("Admin");
////        driver.findElementByAccessibilityId("tbPassword").click();
////        driver.findElementByAccessibilityId("tbPassword").sendKeys("securiport");
////        driver.findElementByName("Login").click();
////
////
////
////
////        // Switch to the new window
////        switchToNewWindow();
////
////        driver.findElementByName("Log off").click();
////
////
////        // Switch to the new window after logout
////        driver.switchTo().window(originalWindowHandle);
////
////        driver.findElementByAccessibilityId("iconExit").click();
////        switchToNewWindow();
////        driver.findElementByAccessibilityId("tbUsernameExit").sendKeys("Admin");
////        driver.findElementByAccessibilityId("tbPasswordExit").sendKeys("securiport");
////        driver.findElementByName("Exit").click();
////
////
////
////    }
////
////    public void switchToNewWindow() {
////        Set<String> allWindowHandles = driver.getWindowHandles();
////        String currentWindowHandle = driver.getWindowHandle();
////        for (String windowHandle : allWindowHandles) {
////            if (!windowHandle.equals(currentWindowHandle)) {
////                driver.switchTo().window(windowHandle);
////                break;
////            }
////        }
////    }
////
//
//
//
//}

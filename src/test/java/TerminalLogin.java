//import io.appium.java_client.windows.WindowsDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.BeforeMethod;
//
//import java.net.URL;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//public class TerminalLogin {
//    private static WindowsDriver driver;
//    private String originalWindowHandle;
//
//    @BeforeMethod
//    public void setUp() {
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("app", "C:\\Windows\\system32\\mstsc.exe");
//        //       capabilities.setCapability("app", "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Accessories");
//        capabilities.setCapability("platformName", "Windows");
//        capabilities.setCapability("deviceName", "WindowsPC");
//
//
//        try {
//            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        originalWindowHandle = driver.getWindowHandle();
//    }
//
////    @AfterMethod
////    public void tearDown() throws IOException, InterruptedException, AWTException {
////        driver.quit();
////    }
////
////    @AfterSuite
////    public void close() {
////        driver.quit();
////    }
//
//    @org.testng.annotations.Test
//    public void test() throws InterruptedException {
//        driver.findElementByName("Connect").click();
//        switchToNewWindow2();
//        Thread.sleep(5000);
//
//
//        driver.findElementByClassName("PasswordBox").sendKeys("1365kSyc");
////        driver.findElementByName("OK").click();
//
////        printWindowTitles();
//
//
//
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
//
//
//
//    }
//    public void switchToNewWindow2() {
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        String currentWindowHandle = driver.getWindowHandle();
//        System.out.println("Current Window Handle: " + currentWindowHandle);
//        System.out.println("Current Window Title: " + driver.getTitle());
//
//        for (String windowHandle : allWindowHandles) {
//            if (!windowHandle.equals(currentWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                System.out.println("Switched to Window Handle: " + windowHandle);
//                System.out.println("Switched to Window Title: " + driver.getTitle());
//                break;
//            }
//        }
//    }
//
//    public void printWindowTitles() {
//        driver.findElementByName("Connect").click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String handle : windowHandles) {
//            driver.switchTo().window(handle);
//            System.out.println("Window handle: " + handle + ", Title: " + driver.getTitle());
//        }
//    }
//
//    public void switchToWindow() {
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String handle : windowHandles) {
//            System.out.println("Window handle: " + handle);
//            driver.switchTo().window(handle);
//            System.out.println("Window Title is " + driver.getTitle());
//        }
//    }
//
//    public void switchToNewWindow() {
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        String currentWindowHandle = driver.getWindowHandle();
//        for (String windowHandle : allWindowHandles) {
//            if (!windowHandle.equals(currentWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                System.out.println("Window Title is " + driver.getTitle());
//                break;
//            }
//        }
//    }
//
//}

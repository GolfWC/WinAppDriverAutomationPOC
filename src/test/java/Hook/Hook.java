package Hook;

import Utils.*;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.*;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class Hook {
    private static WindowsDriver driver;
    BasePage basePage ;

    private SpecializedScreenRecorder screenRecorder;
    Logger log = Logger.getLogger(Hook.class.getName());

    @Before
        public void setUp(Scenario scenario) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //    capabilities.setCapability("app", "c:\\windows\\system32\\notepad.exe");
        capabilities.setCapability("app", "C:\\Securiport\\IICS_iics-15.0-releaseiics-15.0-release-20250107.1\\Clients\\Traveler Search\\Securiport.BMSys.WinApp.TravelersSearch.exe");
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");


        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            startRecording(scenario.getName());
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
    public void tearDown(Scenario scenario) throws Exception {

//        if (driver != null) {
//            if (scenario.isFailed()) {
//                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", scenario.getName());
//            }
//            driver.quit();
//        }
        if (driver != null) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            stopRecording();
            File aviFile = new File("C:\\Users\\WChainan\\Desktop\\Repository\\winAppDriver\\recordings\\" + scenario.getName() + ".avi");
            File mp4File = new File("C:\\Users\\WChainan\\Desktop\\Repository\\winAppDriver\\recordings\\" + scenario.getName() + ".mp4");
            if (aviFile.exists()) {
                VideoConverter.convertAviToMp4(aviFile, mp4File);
                scenario.attach(Files.readAllBytes(mp4File.toPath()), "video/mp4", scenario.getName() + ".mp4");
            }
            driver.quit();
        }
        Thread.sleep(5000);
//        // Send email notification
//        String to = "wchainan@securiport.com";
//        String subject = "Test Report: " + scenario.getName();
//        String body = "The test " + scenario.getName() + " has finished. Please find the attached report.";
//        String attachmentPath = "path/to/test/report"; // Update with the actual path to the test report
//
//        EmailSender.sendEmail(to, subject, body, attachmentPath);
    }
    private void startRecording(String testName) throws Exception {
        File file = new File("C:\\Users\\WChainan\\Desktop\\Repository\\winAppDriver\\recordings");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height);

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                file, testName);
        this.screenRecorder.start();

    }

    private void stopRecording() throws Exception {
        this.screenRecorder.stop();
    }
    public static WindowsDriver getDriver() {
        return driver;
    }

}

package Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

public class FileUpload {
    protected WindowsDriver driver;

    public FileUpload(WindowsDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String filePath) {
        // Locate the file input element and send the file path
        driver.findElement(By.name("File name:")).sendKeys(filePath);
        // Click the Open button to confirm the file selection
        driver.findElement(By.name("Open")).click();
    }

}

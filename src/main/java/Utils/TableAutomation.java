package Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableAutomation {

    private WindowsDriver driver;

    public TableAutomation(WindowsDriver driver) {
        this.driver = driver;
    }

    public void readTableData() {
        // Locate the table element
        WebElement table = driver.findElement(By.xpath("//DataGridView"));

        // Locate all rows in the table
        List<WebElement> rows = table.findElements(By.xpath(".//Top Row"));

        // Iterate through each row
        for (WebElement row : rows) {
            // Locate all columns in the current row
            List<WebElement> columns = row.findElements(By.xpath(".//TableCell"));

            // Iterate through each column and print the cell data
            for (WebElement column : columns) {
                System.out.println(column.getText());
            }
        }
    }

}

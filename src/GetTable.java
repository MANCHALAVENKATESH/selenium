import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GetTable {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");

        WebElement table = driver.findElement(By.className("rt-table"));
        WebElement tableHead = table.findElement(By.className("rt-thead"));

        // Retrieve the table headers
        List<WebElement> headerCells = tableHead.findElements(By.className("rt-resizable-header-content"));

        // Print the table headers
        for (WebElement headerCell : headerCells) {
            System.out.print(padString(headerCell.getText(), 15) + "\t");
        }
        System.out.println();

        WebElement tableBody = table.findElement(By.className("rt-tbody"));

        List<WebElement> rows = tableBody.findElements(By.className("rt-tr-group"));

        // Iterate over the rows
        for (WebElement row : rows) {
            // Find all the cells in the row
            List<WebElement> cells = row.findElements(By.className("rt-td"));

            // Iterate over the cells
            for (WebElement cell : cells) {
                System.out.print(padString(cell.getText(), 15) + "\t");
            }
            System.out.println();
        }

        driver.quit();
    }

    // Helper method to pad the string with spaces to a fixed width
    private static String padString(String input, int width) {
        return String.format("%-" + width + "s", input);
    }
}

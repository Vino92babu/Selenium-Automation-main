package DatePicker;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // Switch to the iframe containing the datepicker
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Open the calendar widget
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.click();

        // Target date
        String year = "2025";
        String month = "December";
        String day = "10";

        // Navigate to the correct month and year
        while (true) {
            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();
            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();

            if (currentYear.equals(year) && currentMonth.equals(month)) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
                Thread.sleep(500);  // slight delay for UI stability
            }
        }

        // Select the day after month and year are matched
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
        for (WebElement date : allDates) {
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
        }

        // Close browser (optional)
        // driver.quit();
    }
}

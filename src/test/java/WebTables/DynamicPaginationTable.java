package WebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPaginationTable {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.primefaces.org/showcase/ui/data/datatable/paginator.xhtml");
        driver.manage().window().maximize();

        // Get the text like "1-10 of 50 records"
        String totalText = driver.findElement(By.xpath("//span[@class='ui-paginator-current']")).getText();
        System.out.println("Total Records: " + totalText);

        // Calculate total pages manually (last number in text is total records, 10 per page)
        int totalRecords = Integer.parseInt(totalText.split("of")[1].trim().split(" ")[0]);
        int recordsPerPage = 10;
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
        System.out.println("Total Pages: " + totalPages);

        int currentPage = 1;

        while (currentPage <= totalPages) {
            try {
                // Try to click directly on the current page number if visible
                WebElement pageLink = driver.findElement(By.xpath("//a[@aria-label='Page " + currentPage + "']"));
                pageLink.click();
            } catch (Exception e) {
                // If page is not visible, click the "Next Page" arrow to reveal more pages
                WebElement nextArrow = driver.findElement(By.xpath("//a[@aria-label='Next Page']"));
                if (nextArrow.isDisplayed() && nextArrow.isEnabled()) {
                    nextArrow.click();
                    continue; // Retry finding the page number after clicking next
                } else {
                    System.out.println("No more pages visible or next button disabled.");
                    break;
                }
            }

            // Wait for table rows to load
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@role='grid']/tbody/tr")));

            // Fetch and print number of rows in the current page
            List<WebElement> rows = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
            System.out.println("Page " + currentPage + " has " + rows.size() + " rows.");

            currentPage++;
        }

             
        driver.quit();
    }
}

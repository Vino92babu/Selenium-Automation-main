package WebTables;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AssignmentDynamicWebtable {
	
	//Assignment: Select all checkboxes in the table and print the status of each checkbox

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        
        //Scroll to the table
        WebElement table = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Web Table']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
         
		// Locate the pagination container
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='pagination']/li"));
        int totalPages = pages.size();
        System.out.println("Total Pages: " + totalPages);
     // Loop through each page
        for (int i = 1; i <= totalPages; i++) {
            // Click the pagination link
            WebElement pageLink = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
            pageLink.click();

            // Wait for the table to update (simple static wait for demonstration)
            Thread.sleep(2000);

            // Select all checkboxes in the table
            List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@id='productTable']//input[@type='checkbox']"));
            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
                System.out.println("Checkbox selected: " + checkbox.isSelected());
            }
        }
		driver.close();
	}

}

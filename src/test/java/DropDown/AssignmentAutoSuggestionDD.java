package DropDown;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentAutoSuggestionDD {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bjs.com/");
        driver.manage().window().maximize();

        // Type in the search box
        driver.findElement(By.xpath("//input[@type ='search']")).sendKeys("Water");

        // Wait for suggestions to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container search-suggestion']//div[@class='list list-group']")));

        // Get all suggestion containers
        List<WebElement> suggestionDivs = driver.findElements(By.xpath("//div[@class='container search-suggestion']//div[@class='list list-group']"));

        System.out.println("Total suggestions found: " + suggestionDivs.size());

        for (WebElement div : suggestionDivs) {
            // Locate the inner anchor tag inside each suggestion
            WebElement anchor = div.findElement(By.tagName("a"));
            String text = anchor.getText().trim().toLowerCase();
            System.out.println("Suggestion: " + text);

            if (text.contains("spring water")) {
                anchor.click();
                System.out.println("Clicked on: " + text);
                break;
            }
        }

        Thread.sleep(3000); // Just to observe the result
        driver.quit();
    }
}

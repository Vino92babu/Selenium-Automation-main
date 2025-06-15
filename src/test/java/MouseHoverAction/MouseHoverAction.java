package MouseHoverAction;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoverAction {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        // Hover over the "Electronics" menu
        WebElement electronicsMenu = driver.findElement(By.xpath("//li[@class='vl-flyout-nav__js-tab']//a[contains(text(),'Electronics')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsMenu).perform();

        // Wait for the submenu item to appear
        WebElement smartphonesAndAccessories = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Smartphones and accessories']")));

        // Hover again (to ensure it's interactable), then click
        actions.moveToElement(smartphonesAndAccessories).click().perform();
        
        // Optional: Print the title of the page to confirm navigation
        String pageTitle = driver.getTitle();
        System.out.println("Page title after clicking: " + pageTitle);
        
    }
}

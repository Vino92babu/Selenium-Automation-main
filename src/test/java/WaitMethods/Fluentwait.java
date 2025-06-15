package WaitMethods;
import java.time.Duration;
import java.util.NoSuchElementException;
//import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fluentwait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Wait<WebDriver> myWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))           // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2))           // Polling interval
                .ignoring(NoSuchElementException.class);       // Ignore this exception during polling

			
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
        // Define the condition to wait for
        WebElement username = myWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
                
                //driver.findElement(By.xpath("//input[@placeholder='Username']"))
                
            }
        });
		username.sendKeys("Admin");
        // Perform actions on the element
       

		
}

	

}

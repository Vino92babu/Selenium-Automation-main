package MouseHoverAction;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightClickActions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

		WebElement button =driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		
			// Create an instance of Actions class
			Actions actions = new Actions(driver);
			// Perform right-click (context click) on the button
			actions.contextClick(button).perform();
		    			// Wait for the context menu to appear
			WebElement copyOption = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Copy']")));	
			// Click on the "Copy" option in the context menu
			copyOption.click();
			
			//get the alert message
			String alertMessage = driver.switchTo().alert().getText();
			// Print the alert message
			System.out.println("Alert message: " + alertMessage);
			//Close the alert box
			driver.switchTo().alert().accept();
	
			

	}

}

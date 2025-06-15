package WaitMethods;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		 
		 //Explicit wait
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));//decclaration
			 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
		 WebElement username = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		 username.sendKeys("Admin");
		 WebElement password = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
		 password.sendKeys("admin123");
		 WebElement loginButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		 loginButton.click();
		 
		 driver.getTitle().contains("OrangeHRM");
		 System.out.println(driver.getTitle().equals("OrangeHRM"));
		 
		 
		 //driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		 
		 //driver.close();
	}



	

}

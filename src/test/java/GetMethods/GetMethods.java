package GetMethods;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		 
		 //get(URL)
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 Thread.sleep(2000);
		 driver.manage().window().maximize();
		
		 //get Title
		 driver.getTitle();
		 System.out.println("Title: " + driver.getTitle());
		 
		 //get Current URL
		 driver.getCurrentUrl();
		 System.out.println("Current URL: " + driver.getCurrentUrl());
		 
		 //get Page Source
		 //String pageSource = driver.getPageSource();
		 //System.out.println("Page Source: " + pageSource);
		 
		 //get Window Handle
		 //String windowHandle = driver.getWindowHandle();
		 //System.out.println("Window Handle: " + windowHandle);
		 
		 //get Window Handles
		 driver.findElement(By.linkText("OrangeHRM, Inc")).click();// Opens a new tab
		 Set<String>WindowIds = driver.getWindowHandles();
		 System.out.println("Window Handles: " + WindowIds);
		 
		 
		 
		 driver.quit();
	}

}
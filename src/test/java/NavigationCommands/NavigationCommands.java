package NavigationCommands;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class NavigationCommands {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		 
		 //get(URL)
		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//Access the URL in the String Format
		
		 //navigate to URL
		 driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//Access the URL in the String Format and Object Format
		 driver.get("https://demoqa.com/automation-practice-form");
		 driver.manage().window().maximize();
		 //URL myurl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 //driver.navigate().to(myurl);
		 
		 //navigate back
		 driver.navigate().back();
		 System.out.println("Back to the previous page " + driver.getCurrentUrl());
		 
		 //navigate forward
		 driver.navigate().forward();
		 System.out.println("Forward to the next page " + driver.getCurrentUrl());
		 
		 //navigate refresh
		 driver.navigate().refresh();
		 
		
		

	}

}

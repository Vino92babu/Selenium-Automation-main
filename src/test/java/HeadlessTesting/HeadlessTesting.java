package HeadlessTesting;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class HeadlessTesting {

	public static void main(String[] args) {
	
     ChromeDriver driver = new ChromeDriver();
     
   //Headless Testing
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
     
     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     		driver.get("https://www.flipkart.com/");
     		driver.manage().window().maximize();
     		
     		String title = driver.getTitle();
     		System.out.println("Title of the page is: " + title);
     		
     		driver.close();
     		
     		
     		
     		
	}

}

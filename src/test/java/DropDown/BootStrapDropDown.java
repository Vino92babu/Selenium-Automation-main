package DropDown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//Click on the dropdown to open it
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		
		//Select Single Option
		//driver.findElement(By.xpath("//li[contains(text(),'Java')]")).click();
		//driver.findElement(By.xpath("//input[@value = 'jQuery']")).click();
		
		//Get Size of Options
		//ul[@class='multiselect-container dropdown-menu']//label - Xpath for all options
		////ul[contains(@class,'multiselect')]//label - Xpath for all options
		List<WebElement>Alloptions = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//label"));
		System.out.println("Total number of options in the dropdown: " + Alloptions.size());
		
		// Get all options
//		System.out.println("All options in the dropdown:");
//		for (WebElement option : Alloptions) {
//			System.out.println(option.getText());
//		}
		
		//Select Multiple Options
		for (WebElement option : Alloptions) {
			String value = option.getText();
			if (value.equals("Java") || value.equals("Python")) {
				option.click();
			}
			
		}
		

	}

}

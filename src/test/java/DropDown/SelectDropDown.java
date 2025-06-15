package DropDown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement CountryDropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select country = new Select(CountryDropdown);
		
		// Select by Visible Text
		
		//country.selectByVisibleText("India");
		
		// Select by Index
		//country.selectByIndex(9);
		
		// Select by Value
		//country.selectByValue("india");
		
        //List of Options
		List<WebElement>options = country.getOptions();
		System.out.println("Total number of options in the dropdown: " + options.size());
		
		
		
		// Get all options
		System.out.println("All options in the dropdown:");
		for (WebElement option : country.getOptions()) {
			System.out.println(option.getText());
		}
		
	
	}

}

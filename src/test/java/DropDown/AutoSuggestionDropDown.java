package DropDown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AutoSuggestionDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		// Enter the text in the search box
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(2000);
		
		// Get all the suggestions
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println("Total number of suggestions: " + suggestions.size());
		
		// Print all the suggestions
		System.out.println("All suggestions:");
		for (WebElement suggestion : suggestions) {
			System.out.println(suggestion.getText());
		}
		// Click on the desired suggestion
//		for (WebElement suggestion : suggestions) {
//			if (suggestion.getText().equals("selenium webdriver")) {
//				suggestion.click();
//				break;
//			}
		
		//Using loop
		for(int i=0;i<suggestions.size();i++) {
			System.out.println(suggestions.get(i).getText());
			if(suggestions.get(i).getText().equals("selenium webdriver")) {
				suggestions.get(i).click();
				break;
			}
		
		}
	}

}

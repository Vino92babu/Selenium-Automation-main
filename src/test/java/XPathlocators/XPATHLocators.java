package XPathlocators;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class XPATHLocators {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://demo.nopcommerce.com/");
		 driver.manage().window().maximize();
		 
		 //XPATH with Single Attribute
		 //driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("T-Shirts");
		 
		 //XPATH with Multiple Attributes with and or operators
		 //driver.findElement(By.xpath("//input[@id='small-searchterms' and @name='q']")).sendKeys("T-Shirts");
		 //driver.findElement(By.xpath("//input[@id='small-searchterms' ][@name='q']")).sendKeys("T-Shirts");
		//driver.findElement(By.xpath("//input[@id='small-searchterms' or @name='q']")).sendKeys("T-Shirts");
		
		//XPATH With innerText
		WebElement text =  driver.findElement(By.xpath("//*[text()='Welcome to our store']"));
		System.out.println("Text: " + text.getText());
		
		//XPATH with contains() --Handling  Dynamic WebElements
		//driver.findElement(By.xpath("//*[contains(@placeholder, 'Search')]")).sendKeys("T-Shirts");
		
		//XPATH with starts-with() -- Handling Dynamic WebElements
		driver.findElement(By.xpath("//*[starts-with(@placeholder, 'Search')]")).sendKeys("T-Shirts");
		
		//Chained XPATH
		
		boolean image = driver.findElement(By.xpath("//div[@class ='header-logo']/a/img")).isDisplayed();
		System.out.println("Image status: " + image);
		
		
//		//XPATH with parent and child
		driver.findElement(By.xpath("//div[@class ='header-logo']//child::*"));
		System.out.println("Child element: " + driver.findElement(By.xpath("//div[@class ='header-logo']//child::*")).getTagName());
	    
//		
//		//XPATH with following and preceding
//		driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[1]/following-sibling::li[2]")).click();
//		
//		//XPATH with ancestor
		List<WebElement> size = driver.findElements(By.xpath("//div[@class ='header-logo']//ancestor::*"));
		System.out.println("Number of ancestors: " + size.size());
//		
//		//XPATH with self
//		driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[1]/self::li")).click();
//		
//		//XPATH with last()
//		List<WebElement> items = driver.findElements(By.xpath("//div[@class='header-menu']/ul/li"));
//		System.out.println("Last item: " + items.get(items.size()-1).getText());
//		
		driver.quit();
	}

}

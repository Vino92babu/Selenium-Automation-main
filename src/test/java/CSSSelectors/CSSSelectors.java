package CSSSelectors;
//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CSSSelectors {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://demo.nopcommerce.com/");
		 driver.manage().window().maximize();
		 
		 //tag Id
		 driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-Shirts");
		// driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-Shirts");
		 
		 //tag class
		 //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-Shirts");
		// driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-Shirts");
		 
		 //tag attribute
		 //driver.findElement(By.cssSelector("input[name='q']")).sendKeys("T-Shirts");
		 //driver.findElement(By.cssSelector("[name='q']")).sendKeys("T-Shirts");
		 
		 //tag class attribute value
		 //driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-Shirts");
		 
		
	}

}

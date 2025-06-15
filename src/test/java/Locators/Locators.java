package Locators;
//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	public static void main(String[] args) {
	
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.demoblaze.com/index.html");
		 driver.manage().window().maximize();
		 
		 // Locating elements using different locators
		 //1.Name
		 //driver.findElement(By.name("search")).sendKeys("Ebay");
		 
		 //2.Id
		boolean  logoStatus =driver.findElement(By.id("login2")).isDisplayed();
		System.out.println("Logo status: " + logoStatus);
		 
		 //3.linkText
		 //driver.findElement(By.linkText("Phones")).click();
		 //4.partialLinkText
		 //driver.findElement(By.partialLinkText("phon")).click();
		 //5.className
		List<WebElement>Categories = driver.findElements(By.className("list-group-item"));
		System.out.println("Number of categories: " + Categories.size());
		
		 //6.tagName
		List<WebElement> items = driver.findElements(By.tagName("a"));
		System.out.println("Number of items: " + items.size());
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Number of images: " + images.size());
		System.out.println("Image source: " + images.get(0).getAttribute("src"));
		
		 //7.xpath
         
	}

}

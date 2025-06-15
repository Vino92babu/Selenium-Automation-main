package JSExecutor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class JSScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Scroll down the page by 1000 pixels
		//js.executeScript("window.scrollBy(0,4000);");
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// Scroll down the page by element visible
		//WebElement elementIndia = driver.findElement(By.xpath("//img[@alt='Flag of India']"));
		//js.executeScript("arguments[0].scrollIntoView();", elementIndia);
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//Scroll and Click
		//WebElement countiesByarea = driver.findElement(By.xpath("//a[normalize-space()='Top 100 largest countries by area']"));
		//js.executeScript("arguments[0].scrollIntoView();", countiesByarea);
		//js.executeScript("arguments[0].click();", countiesByarea);
		
		// Scroll to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(2000);
		
		//get the current URL
		String pageTitle =driver.getCurrentUrl();
		System.out.println("Current URL: " + pageTitle);

		
		// Scroll to the top of the page
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		

	}

}

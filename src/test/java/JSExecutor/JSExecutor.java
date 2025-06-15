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
public class JSExecutor {

	public static void main(String[] args) {
	 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
		
		// Using JavaScript Executor to set the value of the input box
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Saran kumar';", inputbox);
		//js.executeScript("argruments[0].setAttribute('value','Saran')", inputbox);
		
		//Radiobutton
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click();", radioButton);
	}

}

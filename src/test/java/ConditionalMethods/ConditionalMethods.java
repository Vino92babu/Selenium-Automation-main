package ConditionalMethods;

//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//isDisplayed
		
		WebElement Logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Logo is displayed: " + Logo.isDisplayed());
		
		//isEnabled()
		
		WebElement FirstName = driver.findElement(By.id("FirstName"));
		System.out.println("First Name field is enabled: " + FirstName.isEnabled());
		
		//isSelected()
		
		WebElement Femaleradiobutton  = driver.findElement(By.xpath("//input[@id='gender-female']"));
		WebElement Maleradiobutton = driver.findElement(By.xpath("//input[@id='gender-male']"));
		
		System.out.println("Before Selction...");
		System.out.println(Maleradiobutton.isSelected());
		System.out.println(Femaleradiobutton.isSelected());
		
		System.out.println("After Selcting Female...");
		Femaleradiobutton.click();
		System.out.println(Femaleradiobutton.isSelected());
		
		//Newsletter checkbox
		boolean newsletterCheckboxStatus = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("Newsletter checkbox status: " + newsletterCheckboxStatus);
		
		driver.close();
	}

}

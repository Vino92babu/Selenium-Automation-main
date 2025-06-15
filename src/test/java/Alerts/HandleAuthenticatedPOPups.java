package Alerts;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAuthenticatedPOPups {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//explicit wait
		
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();

		//validate the result
		String result = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper cred')]")).getText();
		System.out.println("Result: " + result);
		driver.close();
	}

}

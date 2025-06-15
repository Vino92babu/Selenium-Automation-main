package HeadlessTesting;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class HandleSSL {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//Accepting SSL certificate
		//options.addArguments("--ignore-certificate-errors");
		//options.addArguments("--allow-insecure-localhost");
		
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
		System.out.println("Title of the page is: " + driver.getTitle());
		//driver.close();

	}

}

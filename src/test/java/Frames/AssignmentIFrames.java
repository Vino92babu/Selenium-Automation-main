package Frames;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AssignmentIFrames {
	
	//Assignment: Handle IFrames
	// 1. Open the URL: https://ui.vision/demo/webtest/frames/
	// 2. Switch to the 5th Frame
	// 3. Click on the link - it will open a new Iframe
	// 4. Switch to the new Iframe
	// 5. Check Logo is displayed in the inner frame

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		// Switch to the 5th frame
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src ='frame_5.html']"));
		driver.switchTo().frame(frame5); // Frame as WebElement
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		// Switch to the new iframe
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is displayed in the inner frame.");
		} else {
			System.out.println("Logo is NOT displayed in the inner frame.");
		}
		System.out.println("Logo Name ."+logo.getAttribute("alt"));
		driver.quit(); // Close the browser

	}

}

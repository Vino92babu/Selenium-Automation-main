package Screenshots;
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
import org.openqa.selenium.devtools.v133.page.model.Screenshot;
public class CaptureScreenshots {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		//Capture the screenshot of the entire page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\Screenshots\\entirePage.png");
		sourceFile.renameTo(targetFile);// This will rename the file and move it to the target location
		
		//Capture the screenshot of a specific element
//		WebElement element = driver.findElement(By.xpath("//img[@alt='Mobiles']"));
//		File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
//		File elementTargetFile = new File(System.getProperty("user.dir")+"\\Screenshots\\elementScreenshot.png");
//		elementScreenshot.renameTo(elementTargetFile);// This will rename the file and move it to the target location
//		

	}

}

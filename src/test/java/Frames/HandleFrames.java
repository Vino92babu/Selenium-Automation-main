package Frames;
import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
public class HandleFrames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		// Switch to the first frame
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src ='frame_1.html']"));
		driver.switchTo().frame(frame1); // Frame as WebElement
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Selenium");
		driver.switchTo().defaultContent(); // Switch back to the main content
		
		// Switch to the second frame
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src ='frame_2.html']"));
		driver.switchTo().frame(frame2); // Frame as WebElement
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello WebDriver");
		driver.switchTo().defaultContent(); // Switch back to the main content
		
		// Switch to the third frame
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src ='frame_3.html']"));
		driver.switchTo().frame(frame3); // Frame as WebElement
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello Java");
		
		//inner frame
		driver.switchTo().frame(0); // Switch to the inner frame
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		driver.switchTo().defaultContent(); // Switch back to the main content
		
	}

}

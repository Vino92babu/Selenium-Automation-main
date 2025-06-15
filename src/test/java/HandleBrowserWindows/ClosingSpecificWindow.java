package HandleBrowserWindows;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String> windowIDs = driver.getWindowHandles();
		
		for (String windowId : windowIDs)
		{
			String title = driver.switchTo().window(windowId).getTitle();
			System.out.println("Window Title: " + title);
			if (title.equals("Human Resources Management Software | OrangeHRM HR Software")) {
				driver.close();
				System.out.println("Closed the window with title: " + title);
			} else {
				System.out.println("Not closing the window with title: " + title);
			}
		}

	}

}

package KeyboardActions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingSlider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		//Actions class
		Actions actions = new Actions(driver);
		
		//Minimum slider
		WebElement minslider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		System.out.println("Minimum slider Location Before Moving : " + minslider.getLocation());// get the location of the minimum slider with X and Y coordinates
		actions.dragAndDropBy(minslider,100,0).perform();
		System.out.println("Minimum slider Location After Moving : " + minslider.getLocation());
		
		//Maximum slider
		WebElement maxslider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		System.out.println("Maximum slider Location Before Moving : " + maxslider.getLocation());
		actions.dragAndDropBy(maxslider,-56,256).perform();
		System.out.println("Maximum slider Location After Moving : " + maxslider.getLocation());
		
	}

}

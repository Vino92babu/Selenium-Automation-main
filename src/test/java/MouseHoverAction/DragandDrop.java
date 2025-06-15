package MouseHoverAction;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragandDrop {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		//Actions class
		
		Actions actions = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		actions.dragAndDrop(source, target).perform();
		
		WebElement chalet = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
		actions.dragAndDrop(chalet, trash).perform();
		
		WebElement Taras3 = driver.findElement(By.xpath("//img[@alt='Planning the ascent']"));
		WebElement trash3 = driver.findElement(By.xpath("//div[@id='trash']"));
		actions.dragAndDrop(Taras3, trash3).perform();
		
		System.out.println("All images dragged and dropped successfully");
	}

}

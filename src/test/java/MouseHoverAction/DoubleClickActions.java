package MouseHoverAction;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleClickActions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//Xpath
	
		//input[@id='field1']
		//input[@id='field2']
		//button[normalize-space()='Copy Text']
		
		// Switch to the iframe containing the text element
		driver.switchTo().frame("iframeResult");
		
		
		WebElement textbox1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement textbox2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		textbox1.clear();
		textbox1.sendKeys("Hello World!Good Day");
		
		//double click on the button
		Actions actions = new Actions(driver);
		actions.doubleClick(button).perform();
		
		//String text = textbox2.getText();// this will not get the text from textbox2 because textbox2 is not in having "Value" attribute
		String text = textbox2.getAttribute("value"); // this will get the text from textbox2 
		
		System.out.println("Text in textbox2: " + text);
					
//		//validate the text in textbox2
			if(text.equals("Hello World!Good Day")) {
				System.out.println("Text copied successfully");
				}else {
					System.out.println("Text not copied successfully");
				}
			}
	}



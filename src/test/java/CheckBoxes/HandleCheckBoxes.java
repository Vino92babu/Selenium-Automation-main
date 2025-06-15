package CheckBoxes;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HandleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // 1. Open the website
	        driver.get("https://testautomationpractice.blogspot.com");
	        driver.manage().window().maximize();
	        //2.Select Specific CheckBox
	        //driver.findElement(By.xpath("//input[@id='sunday']")).click();
	        //3.Select All CheckBoxes
	        List<WebElement>checkboxes = driver.findElements(By.xpath("//input[@class = 'form-check-input' and @type ='checkbox']"));
	       
	        //Approach 1: Using for loop
	       // for(WebElement checkbox : checkboxes) {
	        	//checkbox.click();
	        //}
	       
	        //Approach 2: Using forEach
	        //checkboxes.forEach(checkbox -> checkbox.click());
	       
	        //Approach 3: Using count
//	        int count = 0;
//	        for(int i = 0; i < checkboxes.size(); i++) {
//	        	checkboxes.get(i).click();
//	        	count++;
//	        }
	        
	        //Select Last 3 CheckBoxes
	        //for(int i = checkboxes.size()-3; i < checkboxes.size(); i++) {
	        //	checkboxes.get(i).click();
	       // }
	        
	        //Select First 3 CheckBoxes
	        	        for(int i = 0; i < 3; i++) {
	        	        	checkboxes.get(i).click();
	        	        }
	        	        Thread.sleep(2000);
	        	      //Unselect checkboxes if selected
	        	        for(int i=0; i < checkboxes.size(); i++) {
	        	        	if(checkboxes.get(i).isSelected()) {
	        	        		checkboxes.get(i).click();
	        	        		System.out.println("Selected checkbox: " + checkboxes.get(i).getAttribute("id"));
	        	        	}
	        	        }
	        //Select 2nd and 4th CheckBoxes
	        //	        for(int i = 0; i < checkboxes.size(); i++) {
	        //	        	if(i == 1 || i == 3) {
	        //	        		checkboxes.get(i).click();
	        //	        	}
	        //	        }
	        
	        //4. Print the number of selected checkboxes
//	        int selectedCount = 0;
//	        for(WebElement checkbox : checkboxes) {
//	        	if(checkbox.isSelected()) {
//	        		selectedCount++;
//	        	}
//	        }
//	        System.out.println("Number of selected checkboxes: " + selectedCount);
//	        
//	        //Print the name of selected checkboxes
//	        for(WebElement checkbox : checkboxes) {
//	        	if(checkbox.isSelected()) {
//	        		System.out.println("Selected checkbox: " + checkbox.getAttribute("id"));
//	        	}
//	        	
//	        }
	        
	        //5. Close the browser
	        driver.quit();
	        
	}

}

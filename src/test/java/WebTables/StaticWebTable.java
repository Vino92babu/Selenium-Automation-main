package WebTables;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaticWebTable {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://testautomationpractice.blogspot.com/");
	        driver.manage().window().maximize();
	        
	        //Total number of rows
	        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
	        System.out.println("Total number of rows: " + rows);
	        
	        //Total number of columns
	        int columns = driver.findElements(By.xpath("//table[@name = 'BookTable']//th")).size();
	        System.out.println("Total number of columns: " + columns);
	        
	        //Read the data from 5th row and 1st column
	        String bookName = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr[5]//td[1]")).getText();
	        System.out.println("Book name in 5th row and 1st column: " + bookName);
	        
	        //Read the data from all rows and columns	
	        
	        for(int r=2; r<=rows; r++) {
	        	for(int c=1; c<=columns; c++) {
	        		String data = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+r+"]//td["+c+"]")).getText();
	        		System.out.print(data + " \t");
	        	}
	        	System.out.println();
	        }
	        
	        //Print the book name whose author name is Mukesh
//	        for(int r=2; r<=rows; r++) {
//	        	String authorName = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+r+"]//td[2]")).getText();
//	        	if(authorName.equals("Mukesh")) {
//	        		String bookName1 = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+r+"]//td[1]")).getText();
//	        		System.out.println("Book name whose author name is Mukesh: " + "\t"+ bookName1);
//	        	}
//	        }
	        
	        //Print the Total Price of all books
	        int totalPrice = 0;
	        for(int r=2; r<=rows; r++) {
	        	String price = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+r+"]//td[4]")).getText();
	        	totalPrice = totalPrice + Integer.parseInt(price);
	        }
	        	System.out.println("Total Price of all books: " + totalPrice);
	        driver.quit();
	}

}

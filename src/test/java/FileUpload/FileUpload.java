package FileUpload;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class FileUpload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
       
		//Single file upload
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
		fileUpload.sendKeys("C:\\Users\\mvsar\\OneDrive\\Desktop\\Cover Letter.docx");
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Cover Letter.docx")) {
			System.out.println("File uploaded successfully");
			}else {
				System.out.println("File not uploaded");
			}
	}

}

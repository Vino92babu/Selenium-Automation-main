package Alerts;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HandlingAlerts {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        
        // 1. Handling Simple Alert
//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();
//        driver.close();

        // 2. Handling Confirmation Alert
//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert confirmAlert = driver.switchTo().alert();
//        System.out.println(confirmAlert.getText());
//        //confirmAlert.dismiss(); // To cancel the alert
//         confirmAlert.accept(); // To accept the alert
         
         // 3. Handling Prompt Alert
         
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hello, this is a prompt alert!");
        System.out.println(promptAlert.getText());
        promptAlert.accept();
        //validate the result
        String result = driver.findElement(By.id("result")).getText();
        System.out.println("Result: " + result);
         
         
	}

}

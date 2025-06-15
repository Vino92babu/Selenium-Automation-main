package KeyboardActions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        WebElement input1 = driver.findElement(By.id("inputText1"));
        WebElement input2 = driver.findElement(By.id("inputText2"));

        input1.sendKeys("Hello World!");

        Actions actions = new Actions(driver);

        // CTRL + A (Select All) + CTRL + C (Copy)
        actions.click(input1)
               .keyDown(Keys.CONTROL)
               .sendKeys("a")
               .sendKeys("c")
               .keyUp(Keys.CONTROL)
               .perform();

        // Move to second box and CTRL + V (Paste)
        actions.click(input2)
               .keyDown(Keys.CONTROL)
               .sendKeys("v")
               .keyUp(Keys.CONTROL)
               .perform();

        // Optional: Validate if copied text is correct
        String copied = input2.getAttribute("value");
        System.out.println("Copied text: " + copied);

        driver.quit();
    }
}

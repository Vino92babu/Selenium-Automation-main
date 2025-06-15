package FirstTest;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTest {

	public static void main(String[] args) {
		
    //ChromeDriver driver = new ChromeDriver();
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new EdgeDriver();
    driver.get("https://www.opencart.com/index.php?route=cms/demo");
    //validate home page -OpenCart - Demo
    String ActualTitle = driver.getTitle();
    if(ActualTitle.equals("OpenCart - Demo"))
    {
    System.out.println("Test case Passed");
	}
    else
    {
    System.out.println("Test case Failed");
    }
    //close browser
    driver.close();
    }

}

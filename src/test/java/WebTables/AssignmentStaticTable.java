package WebTables;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentStaticTable {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Go to https://blazedemo.com/
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        // 2. Select Departure and Destination city from the dropdown
        WebElement departureCity = driver.findElement(By.name("fromPort"));
        Select departure = new Select(departureCity);
        departure.selectByVisibleText("Boston");

        WebElement destinationCity = driver.findElement(By.name("toPort"));
        Select destination = new Select(destinationCity);
        destination.selectByVisibleText("New York");

        // 3. Click on Find Flights button
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        // 4. Capture prices using ArrayList and sort them
        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//tr/td[6]"));
        System.out.println("Total number of prices: " + priceElements.size());

        ArrayList<Double> priceList = new ArrayList<>();
        ArrayList<Integer> rowIndexList = new ArrayList<>();

        for (int i = 0; i < priceElements.size(); i++) {
            String priceText = priceElements.get(i).getText().replace("$", "").trim();
            double price = Double.parseDouble(priceText);
            priceList.add(price);
            rowIndexList.add(i + 2); // row index in HTML table starts from 2 (1-based with header)
        }

        System.out.println("All prices before sorting: " + priceList);

        // Sort prices in ascending order
        ArrayList<Double> sortedPriceList = new ArrayList<>(priceList);
        Collections.sort(sortedPriceList);
        System.out.println("Prices sorted from lowest to highest: " + sortedPriceList);

        // Get lowest price and its corresponding row index
        double lowestPrice = sortedPriceList.get(0);
        int indexInOriginalList = priceList.indexOf(lowestPrice);
        int rowIndex = rowIndexList.get(indexInOriginalList);

        System.out.println("Lowest Price: $" + lowestPrice);

        // 5. Click on 'Choose This Flight' for the lowest priced flight
        WebElement chooseFlightButton = driver.findElement(By.xpath("//table[@class='table']//tr[" + rowIndex + "]/td[1]/input"));
        chooseFlightButton.click();
        System.out.println("Flight with lowest price selected.");

        // 6. Fill the form with your details
        driver.findElement(By.id("inputName")).sendKeys("John Doe");
        driver.findElement(By.id("address")).sendKeys("123 Main St");
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("state")).sendKeys("NY");
        driver.findElement(By.id("zipCode")).sendKeys("10001");

        Select cardType = new Select(driver.findElement(By.id("cardType")));
        cardType.selectByVisibleText("Visa");

        driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
        driver.findElement(By.id("creditCardMonth")).clear();
        driver.findElement(By.id("creditCardMonth")).sendKeys("12");
        driver.findElement(By.id("creditCardYear")).clear();
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        driver.findElement(By.id("nameOnCard")).sendKeys("John Doe");

        // 7. Click on Purchase Flight button
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        // 8. Print and Verify the confirmation message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]")));

        String message = confirmationMessage.getText();
        System.out.println("Confirmation message: " + message);

        if (message.contains("Thank you for your purchase today!")) {
            System.out.println("Test Passed: Confirmation message is displayed.");
        } else {
            System.out.println("Test Failed: Confirmation message is not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}

//Approach: 2 

//package WebTables;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class AssignmentStaticTable {
//
//    public static void main(String[] args) {
//
//        // Launch Chrome browser
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        // 1. Open the BlazeDemo website
//        driver.get("https://blazedemo.com/");
//        driver.manage().window().maximize();
//
//        // 2. Select departure city from dropdown
//        WebElement departureCity = driver.findElement(By.name("fromPort"));
//        Select departure = new Select(departureCity);
//        departure.selectByVisibleText("Boston");
//
//        // Select destination city from dropdown
//        WebElement destinationCity = driver.findElement(By.name("toPort"));
//        Select destination = new Select(destinationCity);
//        destination.selectByVisibleText("New York");
//
//        // 3. Click on "Find Flights" button
//        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
//
//        // 4. Capture all price elements in the results table
//        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//tr/td[6]"));
//
//        // Initialize variables to track the lowest price and its index
//        double minPrice = Double.MAX_VALUE;
//        int minIndex = -1;
//
//        // Loop through all prices to find the lowest one
//        for (int i = 0; i < priceElements.size(); i++) {
//            // Remove "$" symbol and convert price to double
//            String priceText = priceElements.get(i).getText().replace("$", "").trim();
//            double price = Double.parseDouble(priceText);
//
//            // Update minPrice and index if a lower price is found
//            if (price < minPrice) {
//                minPrice = price;
//                minIndex = i;
//            }
//        }
//
//        // Print the lowest price found
//        System.out.println("Lowest Price: $" + minPrice);
//
//        // 5. Click the "Choose This Flight" button corresponding to the lowest price
//        // Add 2 to index because table rows are 1-based and row 1 is the header
//        WebElement chooseFlightButton = driver.findElement(
//                By.xpath("//table[@class='table']//tr[" + (minIndex + 2) + "]/td[1]/input"));
//        chooseFlightButton.click();
//        System.out.println("Flight with lowest price selected.");
//
//        // 6. Fill the passenger and payment details on the booking form
//        driver.findElement(By.id("inputName")).sendKeys("John Doe");
//        driver.findElement(By.id("address")).sendKeys("123 Main St");
//        driver.findElement(By.id("city")).sendKeys("New York");
//        driver.findElement(By.id("state")).sendKeys("NY");
//        driver.findElement(By.id("zipCode")).sendKeys("10001");
//
//        Select cardType = new Select(driver.findElement(By.id("cardType")));
//        cardType.selectByVisibleText("Visa");
//
//        driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
//        driver.findElement(By.id("creditCardMonth")).clear();
//        driver.findElement(By.id("creditCardMonth")).sendKeys("12");
//        driver.findElement(By.id("creditCardYear")).clear();
//        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
//        driver.findElement(By.id("nameOnCard")).sendKeys("John Doe");
//
//        // 7. Submit the form by clicking "Purchase Flight"
//        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
//
//        // 8. Wait for and verify the confirmation message
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement confirmationMessage = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]")));
//
//        String message = confirmationMessage.getText();
//        System.out.println("Confirmation message: " + message);
//
//        // Validate the success message
//        if (message.contains("Thank you for your purchase today!")) {
//            System.out.println("Test Passed: Confirmation message is displayed.");
//        } else {
//            System.out.println("Test Failed: Confirmation message is not displayed.");
//        }
//
//        // Close the browser
//        driver.quit();
//    }
//}
// Approach: 3

//package WebTables;		
//import java.time.Duration;
//import java.util.ArrayList;
	
//import java.util.Collections;
//import java.util.List;
	
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
	
//import org.openqa.selenium.support.ui.WebDriverWait;
//public class AssignmentStaticTable {
//
//	public static void main(String[] args) {
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		// 1. Go to https://blazedemo.com/
//		driver.get("https://blazedemo.com/");
//		driver.manage().window().maximize();
//
//		// 2. Select Departure and Destination city from the dropdown
//		WebElement departureCity = driver.findElement(By.name("fromPort"));
//		Select departure = new Select(departureCity);
//		departure.selectByVisibleText("Boston");
//
	
//		WebElement destinationCity = driver.findElement(By.name("toPort"));
//		Select destination = new Select(destinationCity);
//		destination.selectByVisibleText("New York");
//
//		// 3. Click on Find Flights button
//		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
//
	
//		// 4. Capture prices using ArrayList and sort them
//		List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//tr/td[6]"));
//		System.out.println("Total number of prices: " + priceElements.size());
//
//		ArrayList<Double> priceList = new ArrayList<>();
//		ArrayList<Integer> rowIndexList = new ArrayList<>();
//
//		for (int i = 0; i < priceElements.size(); i++) {
//			String priceText = priceElements.get(i).getText().replace("$", "").trim();
//			double price = Double.parseDouble(priceText);
//			priceList.add(price);
//			rowIndexList.add(i + 2); // row index in HTML table starts from 2 (1-based with header)
//		}
//		System.out.println("All prices before sorting: " + priceList);
//
//		// Sort prices in ascending order
//		ArrayList<Double> sortedPriceList = new ArrayList<>(priceList);
//		Collections.sort(sortedPriceList);
//		System.out.println("Prices sorted from lowest to highest: " + sortedPriceList);
//
//		// Get lowest price and its corresponding row index

	//		double lowestPrice = sortedPriceList.get(0);
//		int indexInOriginalList = priceList.indexOf(lowestPrice);
//		int rowIndex = rowIndexList.get(indexInOriginalList);
//
//		System.out.println("Lowest Price: $" + lowestPrice);
//
//		// 5. Click on 'Choose This Flight' for the lowest priced flight
//		WebElement chooseFlightButton = driver.findElement(By.xpath("//table[@class='table']//tr[" + rowIndex + "]/td[1]/input"));
//		chooseFlightButton.click();
//		System.out.println("Flight with lowest price selected.");
//
//		// 6. Fill the form with your details
//		driver.findElement(By.id("inputName")).sendKeys("John Doe");
//		driver.findElement(By.id("address")).sendKeys("123 Main St");
//		driver.findElement(By.id("city")).sendKeys("New York");
//		driver.findElement(By.id("state")).sendKeys("NY");
//		driver.findElement(By.id("zipCode")).sendKeys("10001");
//
//		Select cardType = new Select(driver.findElement(By.id("cardType")));
//		cardType.selectByVisibleText("Visa");
//
	
	


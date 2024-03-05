import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebAutomation {
    WebDriver driver;

    @Test
    public void testAutomation() {
        // Set Chrome driver path
        System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("your_website_url");

        // Perform registration
        driver.findElement(By.id("registration_button")).click();
        // Add registration form automation steps here

        // Perform login
        driver.findElement(By.id("login_button")).click();
        // Add login automation steps here

        // Perform search
        driver.findElement(By.id("search_input")).sendKeys("product_name");
        driver.findElement(By.id("search_button")).click();
        // Add search automation steps here

        // Add to cart
        driver.findElement(By.id("add_to_cart_button")).click();
        // Add add-to-cart automation steps here

        // Close the browser
        driver.quit();
    }
}

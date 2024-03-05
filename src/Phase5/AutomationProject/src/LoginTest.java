import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chrome-win64\\chrome-win64\\chromedriver.exe");

        // Initialize ChromeDriver instance
        ChromeDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("http://locolhost:3000/login");

        // Fill out login form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("exampleuser");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        // Submit login form
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Close the browser
        driver.quit();
    }
}

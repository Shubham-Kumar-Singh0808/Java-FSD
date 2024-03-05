import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chrome-win64\\\\chrome-win64\\\\chromedriver.exe");

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the registration page
        driver.get("http://yourwebsite.com/register");

        // Fill out registration form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("exampleuser");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("example@example.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        // Submit registration form
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Close the browser
        driver.quit();
    }
}

package SeleniumTests;

import Screenshots.ScreenshotUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utility.ExtentTestNGListener.class)
public class SwagLabsLogin
{
    private static final Logger logger = LogManager.getLogger(SwagLabsLogin.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void swagLabsLoginTest() throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        sauceDemoLogin(username, password);
        Thread.sleep(3000);
        driver.close();
    }

    public void sauceDemoLogin(String username, String password)
    {
        try {
            WebElement usernameInput = driver.findElement(By.id("user-name"));
            WebElement passwordInput = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameInput.sendKeys(username);
            ScreenshotUtility.captureScreenshot(driver, "username");
            logger.info("Username entered in username field");

            passwordInput.sendKeys(password);
            ScreenshotUtility.captureScreenshot(driver, "password");
            logger.info("Password is entered in password field");

            loginButton.click();
            logger.info("Login Button is clicked");
        } catch (Exception e) {
            logger.info("Swag Labs Login Failed" + e.getMessage());
        }
    }
}

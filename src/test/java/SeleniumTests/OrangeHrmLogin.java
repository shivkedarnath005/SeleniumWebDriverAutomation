package SeleniumTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(Utility.ExtentTestNGListener.class)
public class OrangeHrmLogin {
    private static final Logger logger = LogManager.getLogger(OrangeHrmLogin.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void orangeHrmLoginTest() throws InterruptedException {
        String username = "Admin";
        String password = "admin123";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        orangeHrmLogin(username, password);
        driver.quit();

    }

    public void orangeHrmLogin(String username, String password)
    {
        try
        {
            WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
            WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

            usernameInput.sendKeys(username);
            logger.info("Username entered in the username field");
            passwordInput.sendKeys(password);
            logger.info("Password entered in the password field");
            loginButton.click();
            logger.info("User clicked on the login button");

        } catch (Exception e) {
            logger.info("Orange Hrm Login Test is Failed : " + e.getMessage() + e);
        }
    }
}

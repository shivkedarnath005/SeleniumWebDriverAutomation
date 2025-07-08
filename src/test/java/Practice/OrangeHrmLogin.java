package Practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHrmLogin {
    private static final Logger logger = LogManager.getLogger(OrangeHrmLogin.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void orangeHrmLoginTest()
    {
        try {
            String username = "Admin";
            String password = "admin123";
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
            orangeHrmLogin(username, password);
            driver.quit();
        } catch (Exception e) {
            logger.error("User failed to login on the Orange HRM " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public void orangeHrmLogin(String username, String password)
    {
        try {
            WebElement usernameLoc = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            WebElement passwordLoc = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

            usernameLoc.sendKeys(username);
            logger.info("User has entered the username");
            passwordLoc.sendKeys(password);
            logger.info("User has entered the Password");
            loginBtn.click();
            logger.info("User clicked on the Login Button");
        } catch (Exception e) {
            logger.error("User Failed to login the OrangeHrm");
            throw new RuntimeException(e);
        }
    }
}

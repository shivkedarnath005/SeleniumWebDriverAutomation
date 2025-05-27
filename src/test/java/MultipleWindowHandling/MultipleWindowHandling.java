package MultipleWindowHandling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleWindowHandling {
    public static final Logger logger = LogManager.getLogger(MultipleWindowHandling.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void multipleWindowsHandlingTest() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        handlingMultipleWindows();
        driver.quit();
    }

    public void handlingMultipleWindows()
    {
        try {
            WebElement followOnTwitter = driver.findElement(By.xpath("//a[normalize-space()='Follow On Twitter']"));
            WebElement likeOnFacebook = driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']"));

            logger.info("Parent Window Title : " + driver.getTitle());
            logger.info("Parent Window Handle : " + driver.getWindowHandle());

            followOnTwitter.click();
            likeOnFacebook.click();

            Set<String> multipleWindows = driver.getWindowHandles();
            List<String> windows = new ArrayList<>(multipleWindows);

            driver.switchTo().window(windows.get(1));
            logger.info("Child Window Title : " + driver.getTitle());
            logger.info("Child Window Handle : " + windows.get(1));

            for(String handle : driver.getWindowHandles())
            {
                driver.switchTo().window(handle);
                logger.info("Child Window Handle : " + handle);
            }
        } catch (Exception e) {
            logger.info("Failed to Handle Multiple Windows " + e.getMessage());
        }

    }
}

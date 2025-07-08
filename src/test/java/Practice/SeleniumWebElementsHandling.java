package Practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWebElementsHandling {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumWebElementsHandling.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void alertsHandlingTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);
        handleSimpleAlert();
        driver.quit();
    }

    public void handleSimpleAlert() throws InterruptedException
    {
        try {
            driver.findElement(By.xpath("//button[@id='alertButton']")).click();
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            LOGGER.info(alert.getText());
            alert.accept();
            LOGGER.info("Simple Alert Handled successfully");
        } catch (InterruptedException e) {
            LOGGER.error("Failed to handle Simple Alert " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}

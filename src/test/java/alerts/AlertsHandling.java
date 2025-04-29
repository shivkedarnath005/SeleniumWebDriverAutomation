package alerts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertsHandling {
    private static final Logger logger = LogManager.getLogger(AlertsHandling.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void alertsHandlingTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        handleSimpleAlert();
        handleConfirmationAlert();
        handlePromptAlert();
        driver.quit();
    }

    public void handleSimpleAlert() {
        try {
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            logger.info(alert.getText());
            alert.accept();
            logger.info("Simple Alert Handled successfully");

        } catch (Exception e) {
            logger.info("Simple Alert is not Handled" + e.getMessage());
        }
    }

    public void handleConfirmationAlert() {
        try {
            driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().dismiss();
            logger.info("Confirmation Alert Handled Successfully");

        } catch (Exception e) {
            logger.info("Confirmation Alert not handled" + e.getMessage());
        }
    }

    public void handlePromptAlert()
    {
        try{
            driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().sendKeys("Hello Prompt Alert");
            driver.switchTo().alert().accept();
            logger.info("Prompt Alert handled successfully");
        } catch (Exception e){
            logger.info("Prompt Alert is not handled" + e.getMessage());
        }
    }
}

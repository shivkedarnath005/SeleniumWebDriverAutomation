package FramesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.time.Duration;


public class FrameDragDrop {
    public static final Logger logger = LogManager.getLogger(Frame.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void frameDragAndDropTest() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        performFrameDragAndDrop();
        logger.info("Frame Drag And Drop Test is Successful ");
        driver.quit();
    }

    public void performFrameDragAndDrop()
    {
        try {
            driver.switchTo().frame(0);
            Actions action = new Actions(driver);
            WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
            action.clickAndHold(draggable).release(droppable).release().perform();
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            logger.error("Failed to Drag And Drop the Frame from source to Target " + e.getMessage());
        }

    }
}

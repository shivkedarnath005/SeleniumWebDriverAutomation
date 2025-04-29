package KeyboardActions;

import MouseActions.MouseActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyboardActions {
    private static final Logger logger = LogManager.getLogger(MouseActions.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void handleKeyboardActions() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        handleKeyActions();
        driver.quit();
    }

    public void handleKeyActions() {
        try {
            driver.get("https://the-internet.herokuapp.com/key_presses?");
            Actions actions = new Actions(driver);

            WebElement keyPressBox = driver.findElement(By.xpath("//input[@id='target']"));
            actions.moveToElement(keyPressBox)
                    .click()
                    .sendKeys("Selenium WebDriver Tutorial")
                    .build().perform();
            logger.info("Text entered successfully in the Key Press Box");

            actions.keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .perform();
            logger.info("The entered text in the box is selected all - CTRL + A");

            actions.keyDown(Keys.CONTROL)
                    .sendKeys("c")
                    .keyUp(Keys.CONTROL)
                    .perform();
            logger.info("The entered Text is copied by key action - CTRL + C");

        } catch (Exception e) {
            logger.info("The keyboard actions sequence is not handled " + e.getMessage());
        }
    }


}

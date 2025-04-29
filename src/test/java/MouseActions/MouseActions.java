package MouseActions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActions {
    private static final Logger logger = LogManager.getLogger(MouseActions.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void handleMouseActions() throws InterruptedException {
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       //handleMouseRightClick();
      // Thread.sleep(3000);
      // handleMouseClick();
       //handleDragAndDropAction();
       //handleMouseDoubleClick();
       //handleClickAndHold();
       handleMouseHoverAction();
       driver.quit();

    }

    public void handleMouseHoverAction() {
        try {
            driver.get("https://demo.automationtesting.in/Register.html");
            Actions action = new Actions(driver);
            WebElement widgetsMenu = driver.findElement(By.xpath("//a[normalize-space()='Widgets']"));
            WebElement datePickerElement = driver.findElement(By.xpath("//a[normalize-space()='Datepicker']"));

            action.moveToElement(widgetsMenu).click(datePickerElement).build().perform();
            logger.info("Mouse Hover Action is handled successfully");

        } catch (Exception e) {
            logger.info("Mouse Hover Action is not handled" + e.getMessage());
        }
    }

    public void handleClickAndHold() {
        try {
            driver.get("https://jqueryui.com/droppable/");
            WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
            driver.switchTo().frame(iframeElement);

            Actions action = new Actions(driver);
            WebElement sourceBox = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement targetBox = driver.findElement(By.xpath("//div[@id='droppable']"));
            //action.clickAndHold(sourceBox).release(targetBox).build().perform();

            action.clickAndHold(sourceBox).moveToElement(targetBox).release().build().perform();
            logger.info("Mouse Click And Hold is handled successfully");

        } catch (Exception e) {
            logger.info("Mouse Click And Hold is not handled" + e.getMessage());
        }
    }

    public void handleMouseDoubleClick() {
        try {
            driver.get("https://demoqa.com/buttons");
            WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
            Actions action = new Actions(driver);
            action.doubleClick(doubleClickBtn).build().perform();
            logger.info("Mouse Doubled Click is handled successfully");

        } catch (Exception e) {
            logger.info("Mouse Double click is not handled" + e.getMessage());
        }
    }

    public void handleDragAndDropAction()
    {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            driver.get("https://demo.guru99.com/test/drag_drop.html");

            Actions action = new Actions(driver);
            WebElement sourceCreditBank = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
            WebElement targetCreditAccount = driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
            action.dragAndDrop(sourceCreditBank, targetCreditAccount).build().perform();
            logger.info("Bank Added in the Credit side Account list");

            WebElement sourceAmount5000 = driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
            WebElement targetCreditAmount = driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
            action.dragAndDrop(sourceAmount5000, targetCreditAmount).build().perform();
            logger.info("Rupees 5000 added in the Credit side Bank Account");



        } catch(Exception e){
            logger.info("Drag and Drop is not handled " + e.getMessage());
        }
    }

    public void handleMouseClick() {
        try {
            driver.get("https://demoqa.com/buttons");
            WebElement leftClickBtn = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
            Actions action = new Actions(driver);
            action.click(leftClickBtn).build().perform();
            logger.info("Mouse Left Click is handled successfully");

        } catch (Exception e) {
            logger.info("Mouse Left click is not handled" + e.getMessage());
        }
    }

    public void handleMouseRightClick() {
        try {
            driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
            Thread.sleep(3000);
            WebElement rightClickMeBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
            Actions action = new Actions(driver);
            action.contextClick(rightClickMeBtn).build().perform();
            logger.info("Mouse Right click handled successfully");

            WebElement pasteClickBtn = driver.findElement(By.xpath("//span[normalize-space()='Paste']"));
            action.click(pasteClickBtn).build().perform();
            Thread.sleep(2000);

            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            alert.accept();
            logger.info("Alert handled successfully");

        } catch (Exception e) {
            logger.info("Mouse Right Click is not handled Successfully" + e.getMessage());

        }
    }

}

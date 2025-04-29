package DropdownHandling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StaticDropdown {
    private static final Logger logger = LogManager.getLogger(StaticDropdown.class);
    WebDriver driver = new ChromeDriver();

    @Test
    public void dropdownHandlingTest(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        handleStaticDropdown();

        driver.quit();
    }

    public void handleStaticDropdown(){
        try{
            driver.findElement(By.tagName("select")).click();
            Select select = new Select(driver.findElement(By.tagName("select")));
            select.selectByValue("AND");
            //select.selectByIndex(5);
            //select.selectByVisibleText("Albania");

            List<WebElement> dropdownValues = select.getOptions();
            for(WebElement ele : dropdownValues){
                logger.info("The dropdown value is : " + ele.getText());
            }
            driver.findElement(By.tagName("select")).click();

        } catch(Exception e){
            logger.info("Static Dropdown is not Handled and value is not selected");
        }

    }


}

package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenshotUtility {
    public static WebDriver driver;

    public static void captureScreenshot(WebDriver driver, String filename) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+ filename + " " );
        FileUtils.copyFile(srcFile, destFile);
    }


}

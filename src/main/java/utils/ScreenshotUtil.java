package utils;

import base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {
    public static String capture(String testName) {
        try {
            TakesScreenshot ts=(TakesScreenshot) DriverFactory.getDriver();
            File src=ts.getScreenshotAs(OutputType.FILE);

            String dirPath=System.getProperty("user.dir") + "/screenshots/";

            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String fileName=testName + "_" + System.currentTimeMillis() + ".png";
            String fullPath=dirPath + fileName;
            Files.copy(src.toPath(), Path.of(fullPath));
            return fullPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
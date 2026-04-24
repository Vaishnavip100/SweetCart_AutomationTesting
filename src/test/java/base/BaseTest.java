package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver(null);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
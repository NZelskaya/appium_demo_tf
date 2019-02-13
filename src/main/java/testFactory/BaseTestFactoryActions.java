package testFactory;

import driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pl.b2b.testfactory.TestFactoryUtils;
import pl.b2b.testfactory.annotations.TestFactoryMethod;

public class BaseTestFactoryActions {
    @Test
    @TestFactoryMethod(value = "Start", description = "Initialize driver and open application", group = "Configuration")
    public static void setUp() throws Exception {
        DriverSetup.createDriver();
        Assert.assertNotNull(DriverSetup.getDriver(), "Driver instance is null after setUp");
    }

    @Test
    @TestFactoryMethod(value = "End", description = "Close application", group = "Configuration")
    public static void tearDown() {
        DriverSetup.close(DriverSetup.getDriver());
        Assert.assertNull(DriverSetup.getDriver(), "Driver instance isn't null after tearDown");
    }

    @AfterMethod
    public void failure(ITestResult result) {
        WebDriver driver = DriverSetup.getDriver();
        if (result.getStatus() != ITestResult.SUCCESS) {
            TestFactoryUtils.addScreenShotFromSeleniumDriver(driver);
        }
    }
}

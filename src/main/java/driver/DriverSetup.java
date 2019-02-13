package driver;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSetup {
    private static final String PLATFORM_VERSION = "5.1";
    private static final String DEVICE_NAME = "Nexus_7_API_22";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String APP_PACKAGE_VALUE = "com.android.calculator2";
    private static final String APP_ACTIVITY_VALUE = "com.android.calculator2.Calculator";
    private static final Integer IMPLICIT_TIMEOUT = 10;

    private static WebDriver driver;

    public static void createDriver() throws IOException {
        if (driver == null) {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), getDesiredCapabilities());

            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public static void close(WebDriver driverInstance) {
        System.out.println("Closing browser ...");
        driverInstance.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);

        capabilities.setCapability(APP_PACKAGE, APP_PACKAGE_VALUE);
        capabilities.setCapability(APP_ACTIVITY, APP_ACTIVITY_VALUE);


        return capabilities;
    }
}

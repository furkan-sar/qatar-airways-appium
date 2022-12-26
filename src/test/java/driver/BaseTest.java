package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static AppiumDriver<MobileElement> appiumDriver=null;
    private final Logger logger= LogManager.getLogger(BaseTest.class);
    private final String DEVICE_NAME="emulator-5554";
    private final String APP_PACKAGE="com.m.qr";
    private final String APP_ACTIVITY="com.m.qr.home.onboarding.ui.OnBoardingActivity";
    private final String URL="http://127.0.0.1:4723/wd/hub";
    @BeforeEach
    public void setup(){
            try {
                logger.info("Test basliyor.");
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,APP_PACKAGE );
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
                URL url = new URL(URL);
                appiumDriver = new AndroidDriver(url, desiredCapabilities);
                ApplicationState applicationState=appiumDriver.queryAppState(APP_PACKAGE);
                Assertions.assertTrue(applicationState.toString().equals("RUNNING_IN_BACKGROUND")
                                ||applicationState.toString().equals("RUNNING_IN_FOREGROUND"),
                        "Uygulama calismiyor.");
                logger.info("Uygulama ayaga kalkti");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
    }
    @AfterEach
    public void tearDown(){
        appiumDriver.quit();
    }

}
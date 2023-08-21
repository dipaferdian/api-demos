package Config;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseConfig{

    protected static AndroidDriver<MobileElement> driver;
    protected static WebDriverWait wait;

    @Before
    public void setUp() {

        Properties properties = new Properties();
        DesiredCapabilities caps = new DesiredCapabilities();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);

            String PLATFORM_NAME    = properties.getProperty("PLATFORM_NAME");
            String PLATFORM_VERSION = properties.getProperty("PLATFORM_VERSION");
            String DEVICE_NAME      = properties.getProperty("DEVICE_NAME");
            String APP              = properties.getProperty("APP");
            String APP_PACKAGE      = properties.getProperty("APP_PACKAGE");
            String APP_ACTIVITY     = properties.getProperty("APP_ACTIVITY");
            String APPIUM_HOST      = properties.getProperty("APPIUM_HOST");
            String APPIUM_PORT      = properties.getProperty("APPIUM_PORT");

            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,PLATFORM_NAME);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,PLATFORM_VERSION);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,DEVICE_NAME);
            caps.setCapability("app", APP);
            caps.setCapability("appPackage",APP_PACKAGE);
            caps.setCapability("appActivity",APP_ACTIVITY);

            URL url = new URL(APPIUM_HOST + ":" + APPIUM_PORT);
            driver = this.getAndroidDriver(url, caps);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Before
    public void showHomePage() {

        MobileElement button_permission = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Continue\")"));
        button_permission.click();

        this.popupUpdate();
    }

    @After
    public void tearDown(){
        System.out.println("Close session");
        driver.quit();
    }


    public WebDriverWait wait(AndroidDriver<MobileElement> driver) {
        return wait = new WebDriverWait(driver, 10);
    }

    public static AndroidDriver<MobileElement> getDriver(){
        return driver;
    }

    private AndroidDriver<MobileElement> getAndroidDriver(URL url, DesiredCapabilities caps){
        return new AndroidDriver<>(url,caps);
    }

    private void popupUpdate() {

        WebDriverWait wait_until = wait(getDriver()); // 10 seconds timeout
        WebElement popup_element = wait_until.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));

        popup_element.click();
    }
}

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseConfig {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"0884454295102707");
        caps.setCapability("app", "/home/dferdian19/IntelliJIDEAProjects/example/src/test/resources/ApiDemos.apk");
        caps.setCapability("appPackage","io.appium.android.apis");
        caps.setCapability("appActivity","ApiDemos");

        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver<>(url,caps);
        wait = new WebDriverWait(driver, 10);
        System.out.println("Iniciando....");
    }

    @After
    public void tearDown(){
        System.out.println("Finalizando..");
//        driver.quit();
    }

}

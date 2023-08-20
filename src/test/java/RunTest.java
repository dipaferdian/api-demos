import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;

public class RunTest extends BaseConfig{

    @Test
    public void showHomePage() throws InterruptedException {

        MobileElement button_permission = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"CONTINUE\")"));

        button_permission.click();

        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
        WebElement popup_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        popup_element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/text1")));

        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"App\")")).click();
    }

    public void showAppPage() throws  InterruptedException {

    }
}

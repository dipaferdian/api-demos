import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyApp extends BaseConfig{

    @Test
    public void showAppPage() {
         driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"App\")")).click();
    }
}

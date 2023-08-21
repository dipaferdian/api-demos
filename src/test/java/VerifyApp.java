import Config.BaseConfig;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class VerifyApp extends BaseConfig {

    @Test
    public void step1_verifyAppPage() {
        // Assert that the element is not null (exists)
        assertNotNull(this.verifyAppElement(), "The element was not found on the screen");

        // You can also perform further assertions on the element's properties or behavior
        assertTrue(this.verifyAppElement().isDisplayed(), "The element is not displayed");

        // Assert that the element's text is not empty
        assertFalse(this.verifyAppElement().getText().isEmpty(), "The element's text is empty");

        // Assert that the actual text matches the expected text
        assertEquals("App",  this.verifyAppElement().getText(), "Element text did not match the expected value");

        this.verifyAppElement().click();
    }

    @Test
    public void step2_verifyActionBarPage() {

        this.verifyAppElement().click();

        // Assert that the element is not null (exists)
        assertNotNull(this.verifyActionBarElement(), "The element was not found on the screen");

        // You can also perform further assertions on the element's properties or behavior
        assertTrue(this.verifyActionBarElement().isDisplayed(), "The element is not displayed");

        // Assert that the element's text is not empty
        assertFalse(this.verifyActionBarElement().getText().isEmpty(), "The element's text is empty");

        // Assert that the actual text matches the expected text
        assertEquals("Action Bar",  this.verifyActionBarElement().getText(), "Element text did not match the expected value");

        this.verifyActionBarElement().click();
    }

    private MobileElement verifyAppElement (){
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"App\")"));
    }

    private MobileElement verifyActionBarElement (){
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Action Bar\")"));
    }
}

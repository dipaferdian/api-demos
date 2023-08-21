package Pages.App;

import Config.BaseConfig;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyActionBar extends BaseConfig {


    @Test
    public void verifyActionBar() {

        VerifyApp verifyApp = new VerifyApp();

        verifyApp.verifyApp();

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

    private MobileElement verifyActionBarElement (){
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Action Bar\")"));
    }

}

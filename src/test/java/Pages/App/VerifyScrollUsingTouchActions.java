package Pages.App;

import Config.BaseConfig;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.openqa.selenium.Dimension;

public class VerifyScrollUsingTouchActions extends BaseConfig {

    @Test
    public void verifyServiceWithScrollUsingTouchActionsStep3() {
        VerifyApp verifyApp = new VerifyApp();
        verifyApp.verifyApp();
        this.verifyServiceWithScrollUsingTouchActionsElement();
    }

    private void verifyServiceWithScrollUsingTouchActionsElement(){

        // Find the element you want to scroll to
        MobileElement elementToScrollTo = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Service\")"));

        // System.out.println("Scrolling to element: " + elementToScrollTo.getText());

        // Get the dimensions of the screen
        Dimension size = driver.manage().window().getSize();

        // Calculate swipe coordinates
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        int centerX = size.width / 2;

        // Create a TouchAction for scrolling
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(elementToScrollTo)))
                .moveTo(PointOption.point(centerX, endY))
                .release()
                .perform();

    }
}



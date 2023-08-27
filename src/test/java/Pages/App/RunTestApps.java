package Pages.App;

import Config.BaseConfig;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

public class RunTestApps extends BaseConfig implements Apps{

    protected VerifyApp verifyApp = new VerifyApp();
    protected VerifyActionBar verifyActionBar = new VerifyActionBar();

    @Override
    public void verifyApp() {
        this.verifyApp.verifyApp();
    }

    @Override
    public void verifyActionBar() {
        this.verifyActionBar.verifyActionBar();
    }

    @Test
    public void runTest() {
        verifyApp();
        verifyActionBar();
    }
}

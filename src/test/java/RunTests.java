import Config.BaseConfig;
import Pages.App.RunTestApps;
import org.junit.Test;

public class RunTests extends BaseConfig{

    protected RunTestApps runTestApps = new RunTestApps();

    @Test
    public void runTest() {
       runTestApps.runTest();
    }
}

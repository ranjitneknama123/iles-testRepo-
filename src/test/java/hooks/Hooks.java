package hooks;

import com.ranjit.harmony.utils.DriverFactory;
import com.ranjit.harmony.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Failed test cases is" + scenario.getName());
            ScreenshotUtil.takeScreenshot(DriverFactory.getDriver());
        }
        DriverFactory.quitDriver();
    }
}

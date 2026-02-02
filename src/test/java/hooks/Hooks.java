package hooks;

import com.ranjit.harmony.utils.DriverFactory;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

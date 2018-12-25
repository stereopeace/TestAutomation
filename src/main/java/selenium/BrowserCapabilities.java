package selenium;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by ochuvako on 08.10.2018.
 */
public class BrowserCapabilities {

    public DesiredCapabilities getCapabilities(Browser browser) {
        switch (browser.getName()) {
            case "firefox":
                default:{
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.acceptInsecureCerts();
                caps.setVersion(browser.getVersion());
                return caps;
            }
            case "chrome": {
                DesiredCapabilities caps = DesiredCapabilities.chrome();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");

                caps.setCapability(ChromeOptions.CAPABILITY, options);

                return caps;
            }

        }
    }
}

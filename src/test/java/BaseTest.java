import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;
import ru.stqa.selenium.factory.WebDriverPool;
import selenium.Browser;
import selenium.BrowserCapabilities;
import util.PropertyLoader;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);
    WebDriver driver;
    Browser browser = new Browser(PropertyLoader.loadProperty("name"),
            PropertyLoader.loadProperty("version"),
            PropertyLoader.loadProperty("platform"));
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void initData() {
        DesiredCapabilities capabilities = new BrowserCapabilities()
                .getCapabilities(browser);

        driver = WebDriverPool.DEFAULT.getDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 20);

        driver.get("https://google.ru/");


        actions = new Actions(driver);
    }


    @AfterMethod
    public void closeBrowsers() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}

package specs;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.Constants;
import utils.LoggerLoad;
import utils.WebDriverFactory;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    @Description("Browser start up")
    @Parameters("browser")
    public void setDriver(String browser) {
        LoggerLoad.info("Browser start up");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/utils/drivers/chromedriver.exe");
            driver = new WebDriverFactory().createInstance(browser);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/java/utils/drivers/msedgedriver.exe");
            driver = new WebDriverFactory().createInstance(browser);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/java/utils/drivers/geckodriver.exe");
            driver = new WebDriverFactory().createInstance(browser);
        }

        driver.manage().window().maximize();
        driver.navigate().to(Constants.SUT);
    }

    @AfterMethod
    @Description("Browser tear down")
    public void tearDown() {
        LoggerLoad.info("Browser tear down");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

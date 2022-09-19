package specs;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Contants;

public abstract class Hooks {
    private static final Logger logger = LogManager.getLogger("driver");
    protected WebDriver driver;

    @BeforeMethod
    @Description("Browser start up")
    public void setDriver() {
        logger.info("Browser start up");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(Contants.SUT);
    }

    @AfterMethod
    @Description("Browser tear down")
    public void tearDown() {
        logger.info("Browser tear down");
        driver.quit();
    }
}

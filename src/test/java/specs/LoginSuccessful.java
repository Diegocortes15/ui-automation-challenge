package specs;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.themoviedb.auth.AuthConstants;
import pages.HomePage;
import pages.LoginPage;

public class LoginSuccessful extends Hooks {
    private static final Logger logger = LogManager.getLogger("login-successful");

    @Test
    @Description("Verify when user uses valid credentials")
    public void loginValidUserTest() {
        logger.info("Verify when user uses valid credentials");

        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton().loginUser(AuthConstants.USER_USERNAME, AuthConstants.USER_PASSWORD);
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");
    }
}

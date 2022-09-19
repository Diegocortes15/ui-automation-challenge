package specs;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import data.LoginData;
import pages.HomePage;
import pages.LoginPage;

public class LoginSuccessful extends Hooks {
    private static final Logger logger = LogManager.getLogger("login-successful");

    @Test
    @Description("The user should be able to login")
    public void loginValidUserTest() {
        logger.info("Test: The user should be able to login");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(LoginData.USER_USERNAME, LoginData.USER_PASSWORD);
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");
    }
}

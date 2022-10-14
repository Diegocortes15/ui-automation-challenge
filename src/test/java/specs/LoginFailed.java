package specs;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import data.Users;
import utils.specs.LoginFailedUtils;

@Test(enabled = false)
@Epic("Regression Tests")
@Feature("Login")
public class LoginFailed extends Hooks {
    private static final Logger logger = LogManager.getLogger("login-failed");

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify when user wants login with invalid credentials")
    @Story("Login failed test")
    public void loginInvalidCredentialTest() {
        logger.info("Test: Verify when user wants login with invalid credentials");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.FAKE_USER.getUsername(), Users.FAKE_USER.getPassword());
        LoginFailedUtils.assertWeCouldntFindYourUsername(loginPage);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify when user wants login with empty fields")
    @Story("Login failed test")
    public void loginEmptyFieldsTest() {
        logger.info("Test: Verify when user wants login with empty fields");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser("", "");
        LoginFailedUtils.assertWeCouldntFindYourUsername(loginPage);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify when user left username field empty")
    @Story("Login failed test")
    public void loginEmptyUsernameTest() {
        logger.info("Test: Verify when user left username field empty");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser("", Users.USER.getPassword());
        LoginFailedUtils.assertWeCouldntFindYourUsername(loginPage);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify when user left password field empty")
    @Story("Login failed test")
    public void loginEmptyPasswordTest() {
        logger.info("Test: Verify when user left password field empty");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), "");
        LoginFailedUtils.assertWeCouldntValidateYourInformation(loginPage);
    }
}

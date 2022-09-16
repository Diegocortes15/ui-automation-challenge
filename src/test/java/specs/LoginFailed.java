package specs;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import data.LoginData;
import pages.HomePage;
import pages.LoginPage;
import data.FakeUsers;
import utils.LoginFailedUtils;

public class LoginFailed extends Hooks {
    private static final Logger logger = LogManager.getLogger("login-failed");

    @Test
    @Description("Verify when user wants login with invalid credentials")
    public void loginInvalidCredentialTest() {
        logger.info("Verify when user wants login with invalid credentials");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(FakeUsers.FAKE_USER.getUsername(), FakeUsers.FAKE_USER.getPassword());
        LoginFailedUtils.assertWeCouldntFindYourUsername(loginPage);
    }

    @Test
    @Description("Verify when user wants login with empty fields")
    public void loginEmptyFieldsTest() {
        logger.info("Verify when user wants login with empty fields");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser("", "");
        LoginFailedUtils.assertWeCouldntFindYourUsername(loginPage);
    }

    @Test
    @Description("Verify when user left username field empty")
    public void loginEmptyUsernameTest() {
        logger.info("Verify when user left username field empty");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser("", LoginData.USER_PASSWORD);
        LoginFailedUtils.assertWeCouldntFindYourUsername(loginPage);
    }

    @Test
    @Description("Verify when user left password field empty")
    public void loginEmptyPasswordTest() {
        logger.info("Verify when user left password field empty");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(LoginData.USER_USERNAME, "");
        LoginFailedUtils.assertWeCouldntValidateYourInformation(loginPage);
    }
}

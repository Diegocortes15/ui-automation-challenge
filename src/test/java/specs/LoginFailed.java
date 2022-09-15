package specs;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.themoviedb.auth.AuthConstants;
import pages.HomePage;
import pages.LoginPage;
import utils.FakeUsers;

public class LoginFailed extends Hooks {
    private static final Logger logger = LogManager.getLogger("login-failed");

    @Test
    @Description("Verify when user wants login with invalid credentials")
    public void loginInvalidCredentialTest() {
        logger.info("Verify when user wants login with invalid credentials");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLoginButton();
        loginPage.loginUser(FakeUsers.FAKE_USER.getUsername(), FakeUsers.FAKE_USER.getPassword());
        Assert.assertTrue(loginPage.getErrorTitle().contains("There was a problem"));
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't find your username."));
        Assert.assertTrue(loginPage.getErrorTextTwo().contains("remaining login attempts"));
    }

    @Test
    @Description("Verify when user wants login with empty fields")
    public void loginEmptyFieldsTest() {
        logger.info("Verify when user wants login with empty fields");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLoginButton();
        loginPage.loginUser("", "");
        Assert.assertTrue(loginPage.getErrorTitle().contains("There was a problem"));
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't find your username."));
        Assert.assertTrue(loginPage.getErrorTextTwo().contains("remaining login attempts"));
        // Assert.assertEquals(loginPage.getErrorTextTwo(), "You have 5 remaining login attempts.");
    }

    @Test
    @Description("Verify when user left username field empty")
    public void loginEmptyUsernameTest() {
        logger.info("Verify when user left username field empty");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLoginButton();
        loginPage.loginUser("", AuthConstants.USER_PASSWORD);
        Assert.assertTrue(loginPage.getErrorTitle().contains("There was a problem"));
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't find your username."));
        Assert.assertTrue(loginPage.getErrorTextTwo().contains("remaining login attempts"));
    }

    @Test
    @Description("Verify when user left password field empty")
    public void loginEmptyPasswordTest() {
        logger.info("Verify when user left password field empty");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLoginButton();
        loginPage.loginUser(AuthConstants.USER_USERNAME, "");
        Assert.assertTrue(loginPage.getErrorTitle().contains("There was a problem"));
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't validate your information. Want to try again?"));
        Assert.assertTrue(loginPage.getErrorTextTwo().contains("remaining login attempts"));
    }

}

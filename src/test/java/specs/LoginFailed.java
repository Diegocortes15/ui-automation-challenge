package specs;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import data.Users;
import utils.LoggerLoad;
import utils.listeners.TestListener;
import utils.specs.LoginFailedUtils;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Login")
public class LoginFailed extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify when user wants login with invalid credentials")
    @Story("Login failed test")
    public void loginInvalidCredentialTest() {
        LoggerLoad.info("Test: Verify when user wants login with invalid credentials");

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
        LoggerLoad.info("Test: Verify when user wants login with empty fields");

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
        LoggerLoad.info("Test: Verify when user left username field empty");

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
        LoggerLoad.info("Test: Verify when user left password field empty");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), "");
        LoginFailedUtils.assertWeCouldntValidateYourInformation(loginPage);
    }
}

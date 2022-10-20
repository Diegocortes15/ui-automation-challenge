package specs;

import data.Users;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.LoggerLoad;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Login")
public class LoginSuccessful extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: The user should be able to login")
    @Story("Login successful test")
    public void loginValidUserTest() {
        LoggerLoad.info("Test: The user should be able to login");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), Users.USER.getPassword());
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");
    }
}

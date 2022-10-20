package specs;

import data.Users;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import utils.LoggerLoad;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Searcher")
public class SearchSuccessful extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify successful search")
    @Story("Search movie by searcher field test")
    public void successfulSearchTest() {
        LoggerLoad.info("Test: Verify successful search");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), Users.USER.getPassword());
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        SearchResultsPage searchResultsPage = loginPage.getNavigationBar().searchMovie("Fight Club");
        Assert.assertEquals(searchResultsPage.getFirstTitleResult(), "Fight Club");
    }
}

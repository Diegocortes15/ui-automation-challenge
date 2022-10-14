package specs;

import data.Users;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;

@Epic("Regression Tests")
@Feature("Searcher")
public class SearchSuccessful extends Hooks {
    private static final Logger logger = LogManager.getLogger("search-successful");

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify successful search")
    @Story("Search movie by searcher field test")
    public void successfulSearchTest() {
        logger.info("Test: Verify successful search");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), Users.USER.getPassword());
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        SearchResultsPage searchResultsPage = loginPage.getNavigationBar().searchMovie("Fight Club");
        Assert.assertEquals(searchResultsPage.getFirstTitleResult(), "Fight Club");
    }
}

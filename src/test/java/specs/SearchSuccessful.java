package specs;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.themoviedb.auth.AuthConstants;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;

public class SearchSuccessful extends Hooks {
    private static final Logger logger = LogManager.getLogger("search-successful");

    @Test
    @Description("Verify successful search")
    public void successfulSearchTest() {
        logger.info("Verify successful search");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginButton()
                .loginUser(AuthConstants.USER_USERNAME, AuthConstants.USER_PASSWORD);
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        SearchResultsPage searchResultsPage = loginPage.searchMovie("Fight Club");
        Assert.assertEquals(searchResultsPage.getTitleFirstResult(), "Fight Club");
    }
}

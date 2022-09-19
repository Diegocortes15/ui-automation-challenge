package specs;

import data.LoginData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MovieListPage;

public class MovieDatesAscOrder extends Hooks {

    private static final Logger logger = LogManager.getLogger("login-successful");
    @Test
    public void movieDateAscOrderTest() {
        logger.info("Verify movie genre filter");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(LoginData.USER_USERNAME, LoginData.USER_PASSWORD);
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        MovieListPage movieListPage = loginPage.getNavigationBar().goTopRatedMovies();
        Assert.assertEquals(movieListPage.getTextTitlePage(), "Top Rated Movies");

        movieListPage.orderMoviesByDateAscending();
        Assert.assertTrue(movieListPage.isDatesOrdered());

    }

}

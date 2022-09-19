package specs;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import data.LoginData;
import pages.HomePage;
import pages.LoginPage;
import pages.MoviePage;
import pages.MovieListPage;
import utils.Contants;

public class MovieFilter extends Hooks {

    private static final Logger logger = LogManager.getLogger("movie-genre-filter");

    @Test
    @Description("Verify movie genre filter")
    public void movieGenreFilterTest() {
        logger.info("Test: Verify movie genre filter");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(LoginData.USER_USERNAME, LoginData.USER_PASSWORD);
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        MovieListPage movieListPage = loginPage.getNavigationBar().goTopRatedMovies();
        Assert.assertEquals(movieListPage.getTextTitlePage(), "Top Rated Movies");

        movieListPage.filterMovieByAction();

        MoviePage moviePage = movieListPage.clickRandomMovieCard(Contants.MAX_MOVIES_PER_PAGE);
        Assert.assertTrue(moviePage.getTextGenres().contains("Action"));
    }
}

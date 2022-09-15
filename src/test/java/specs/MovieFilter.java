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
import pages.MoviesPage;
import utils.Contants;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MovieFilter extends Hooks {

    private static final Logger logger = LogManager.getLogger("movie-genre-filter");

    @Test
    @Description("Verify movie genre filter")
    public void movieGenreFilter() {
        logger.info("Verify movie genre filter");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(LoginData.USER_USERNAME, LoginData.USER_PASSWORD);
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        MoviesPage moviesPage = loginPage.getNavigationBar().goTopRatedMovies();
        Assert.assertEquals(moviesPage.getTextTitlePage(), "Top Rated Movies");

        moviesPage.filterMovieByAction();

        MoviePage moviePage = moviesPage.clickRandomMovieCard(Contants.MAX_MOVIES_PER_PAGE);
        System.out.println(moviePage.getTextGenres());
        Assert.assertTrue(moviePage.getTextGenres().contains("Action"));
    }
}

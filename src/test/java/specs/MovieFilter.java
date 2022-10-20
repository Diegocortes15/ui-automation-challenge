package specs;

import data.Users;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MoviePage;
import pages.MovieListPage;
import utils.Constants;
import utils.LoggerLoad;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Movie Filter")
public class MovieFilter extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify movie genre filter")
    @Story("Filter movies by genre test")
    public void movieGenreFilterTest() {
        LoggerLoad.info("Test: Verify movie genre filter");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), Users.USER.getPassword());
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        MovieListPage movieListPage = loginPage.getNavigationBar().goTopRatedMovies();
        Assert.assertEquals(movieListPage.getTextTitlePage(), "Top Rated Movies");

        movieListPage.filterMovieByAction();

        MoviePage moviePage = movieListPage.clickRandomMovieCard(Constants.MAX_MOVIES_PER_PAGE);
        Assert.assertTrue(moviePage.getTextGenres().contains("Action"));
    }
}

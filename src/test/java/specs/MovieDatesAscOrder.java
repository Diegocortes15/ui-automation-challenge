package specs;

import data.LoginData;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MovieListPage;

public class MovieDatesAscOrder extends Hooks {

    private static final Logger logger = LogManager.getLogger("movie-dates-asc-order");
    @Test
    @Description("The user should see the dates of the first 4 movies in ascending order")
    public void movieDateAscOrderTest() {
        logger.info("Test: The user should see the dates of the first 4 movies in ascending order");

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

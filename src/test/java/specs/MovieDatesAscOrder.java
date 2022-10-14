package specs;

import data.Users;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MovieListPage;

@Epic("Regression Tests")
@Feature("Movie List")
public class MovieDatesAscOrder extends Hooks {

    private static final Logger logger = LogManager.getLogger("movie-dates-asc-order");
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: The user should see the dates of the first 4 movies in ascending order")
    @Story("Sort movies by ascendant date test")
    public void movieDateAscOrderTest() {
        logger.info("Test: The user should see the dates of the first 4 movies in ascending order");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), Users.USER.getPassword());
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        MovieListPage movieListPage = loginPage.getNavigationBar().goTopRatedMovies();
        Assert.assertEquals(movieListPage.getTextTitlePage(), "Top Rated Movies");

        movieListPage.orderMoviesByDateAscending();
        Assert.assertTrue(movieListPage.isDatesOrdered());
    }
}

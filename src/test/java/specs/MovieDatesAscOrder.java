package specs;

import data.Users;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MovieListPage;
import utils.LoggerLoad;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Movie List")
public class MovieDatesAscOrder extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: The user should see the dates of the first 4 movies in ascending order")
    @Story("Sort movies by ascendant date test")
    public void movieDateAscOrderTest() {
        LoggerLoad.info("Test: The user should see the dates of the first 4 movies in ascending order");

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

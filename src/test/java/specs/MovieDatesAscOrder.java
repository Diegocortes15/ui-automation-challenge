package specs;

import data.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MovieListPage;

public class MovieDatesAscOrder extends Hooks {

    @Test
    public void movieDateAscOrderTest() {
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

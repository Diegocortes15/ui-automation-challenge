package specs;

import data.Users;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.Constants;
import utils.LoggerLoad;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Acting Time Line")
public class ActingTimeline extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify acting timeline")
    @Story("Acting time line test")
    public void actingTimelineTest() {
        LoggerLoad.info("Test: Verify acting timeline");

        String movieTitle;

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(Users.USER.getUsername(), Users.USER.getPassword());
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        MovieListPage movieListPage = loginPage.getNavigationBar().goTopRatedMovies();
        Assert.assertEquals(movieListPage.getTextTitlePage(), "Top Rated Movies");

        MoviePage moviePage = movieListPage.clickRandomMovieCard(Constants.MAX_MOVIES_PER_PAGE);
        movieTitle = moviePage.getTextMovieTitle();

        ActorPage actorPage = moviePage.clickFirstActorTopBilledCast();
        Assert.assertTrue(actorPage.isMovieInActingTimeline(movieTitle));
    }
}

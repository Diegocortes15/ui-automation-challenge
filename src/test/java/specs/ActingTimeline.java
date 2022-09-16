package specs;

import data.LoginData;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Contants;

public class ActingTimeline extends Hooks{
    private static final Logger logger = LogManager.getLogger("acting-timeline");

    @Test
    @Description("Verify acting timeline")
    public void actingTimelineTest() {
        logger.info("Verify acting timeline");

        String movieTitle;

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.getNavigationBar().clickLoginButton();
        loginPage.loginUser(LoginData.USER_USERNAME, LoginData.USER_PASSWORD);
        Assert.assertEquals(driver.getTitle(), "My Profile — The Movie Database (TMDB)");

        MovieListPage movieListPage = loginPage.getNavigationBar().goTopRatedMovies();
        Assert.assertEquals(movieListPage.getTextTitlePage(), "Top Rated Movies");

        MoviePage moviePage = movieListPage.clickRandomMovieCard(Contants.MAX_MOVIES_PER_PAGE);
        movieTitle = moviePage.getTextMovieTitle();

        ActorPage actorPage = moviePage.clickFirstActorTopBilledCast();
        Assert.assertTrue(actorPage.isMovieInActingTimeLine(movieTitle));
    }
}

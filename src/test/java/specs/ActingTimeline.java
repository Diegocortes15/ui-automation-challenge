package specs;

import data.Users;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Constants;

@Epic("Regression Tests")
@Feature("Acting Time Line")
public class ActingTimeline extends Hooks{
    private static final Logger logger = LogManager.getLogger("acting-timeline");

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify acting timeline")
    @Story("Acting time line test")
    public void actingTimelineTest() {
        logger.info("Test: Verify acting timeline");

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

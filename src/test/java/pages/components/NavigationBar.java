package pages.components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.LoginPage;
import pages.MovieListPage;
import pages.SearchResultsPage;

public class NavigationBar extends BasePage {

    @FindBy(css = ".primary li:nth-child(3) a")
    private WebElement loginButton;
    @FindBy(css = ".search[href='/search']")
    private WebElement searchButton;

    @FindBy(id = "search_v4")
    private WebElement searchBar;

    @FindBy(css = ".navigation > .k-menu-item:nth-child(1) > .k-menu-link")
    private WebElement moviesLink;

    @FindBy(css = "a[href='/movie/top-rated']")
    private WebElement topRatedMoviesLink;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public SearchResultsPage searchMovie(String movie) {
        searchButton.click();
        searchBar.sendKeys(movie);
        searchBar.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public MovieListPage goTopRatedMovies() {
        moviesLink.click();
        topRatedMoviesLink.click();
        return new MovieListPage(driver);
    }
}

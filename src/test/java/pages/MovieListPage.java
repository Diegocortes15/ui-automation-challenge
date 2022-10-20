package pages;

import com.google.common.collect.Ordering;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.pages.MovieListPageUtils;
import java.time.Duration;
import java.util.*;

public class MovieListPage extends BasePage {
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(css = ".title h2")
    private WebElement titlePage;

    @FindBy(css = ".filter_panel.card:nth-child(1)")
    private WebElement sortButton;

    @FindBy(css = ".filter_panel.card:nth-child(2)")
    private WebElement filtersButton;

    @FindBy(css = ".filter_panel.card:nth-child(1) h3 + .k-dropdown")
    private WebElement sortResultByButton;

    @FindBy(css = "#sort_by_listbox .k-item:nth-child(6)")
    private WebElement dateAscendingButton;

    @FindBy(css = "#with_genres > li:nth-child(1)")
    private WebElement actionGenre;

    @FindBy(css = ".apply.small")
    private WebElement searchSideBarButton;

    @FindBy(css = ".apply.full")
    private WebElement searchFooterButton;

    @FindBy(css = ".card.style_1")
    private List<WebElement> listMovieCards;

    @FindBy(css = ".card.style_1:nth-child(-n+4) .content p")
    private List<WebElement> listMovieDates;

    public MovieListPage(WebDriver driver) {
        super(driver);
    }

    @Step("⏩ Get title page. Step...")
    public String getTextTitlePage() {
        return titlePage.getText();
    }

    @Step("⏩ Filter movie by action. Step...")
    public void filterMovieByAction() {
        filtersButton.click();
        actions.moveToElement(actionGenre);
        actionGenre.click();
        searchFooterButton.click();
        wait.until(ExpectedConditions.invisibilityOf(searchFooterButton));
    }

    @Step("⏩ Click on random movie. Movie {0} selected. Step...")
    public MoviePage clickRandomMovieCard(int maxMoviesCard) {
        int movieId = (int) ((Math.random() * (maxMoviesCard - 1)) + 1);
        actions.moveToElement(listMovieCards.get(movieId));
        listMovieCards.get(movieId).click();
        return new MoviePage(driver);
    }

    @Step("⏩ Order movies by ascending date. Step...")
    public void orderMoviesByDateAscending() {
        sortButton.click();
        sortResultByButton.click();
        dateAscendingButton.click();
        searchSideBarButton.click();
        wait.until(ExpectedConditions.attributeContains(searchSideBarButton, "class", "disabled"));
    }

    @Step("⏩ Verify if movies dates are in order. Step...")
    public boolean isDatesOrdered() {
        List<Long> timestampMovies = MovieListPageUtils.getMoviesTimestamp(listMovieDates);
        return Ordering.natural().isOrdered(timestampMovies);
    }
}

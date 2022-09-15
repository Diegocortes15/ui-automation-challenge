package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MoviesPage extends BasePage {

    @FindBy(css = ".title h2")
    private WebElement titlePage;

    @FindBy(xpath = "//h2[contains(text(),'Filters')]/..")
    private WebElement filtersButton;

    @FindBy(css = "#with_genres > li:nth-child(1)")
    private WebElement actionGenre;

    @FindBy(css = ".apply.small p")
    private WebElement searchSideBarButton;

    @FindBy(css = ".apply.full")
    private WebElement searchFooterButton;

    @FindBy(css = ".card.style_1")
    private List<WebElement> listMovieCards;

    public MoviesPage(WebDriver driver) {
        super(driver);
    }

    public String getTextTitlePage() {
        return titlePage.getText();
    }

    public void filterMovieByAction() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        filtersButton.click();
        actions.moveToElement(actionGenre);
        actionGenre.click();
        searchFooterButton.click();
        wait.until(ExpectedConditions.invisibilityOf(searchFooterButton));
    }

    public MoviePage clickRandomMovieCard(int maxMoviesCard) {
        int movieId = (int) ((Math.random() * (maxMoviesCard - 1)) + 1);
        actions.moveToElement(listMovieCards.get(movieId));
        listMovieCards.get(movieId).click();
        return new MoviePage(driver);
    }
}

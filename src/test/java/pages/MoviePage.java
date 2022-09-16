package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends BasePage {

    @FindBy(className = "genres")
    private WebElement genres;

    @FindBy(css = ".header .title h2 a")
    private WebElement movieTitle;

    @FindBy(css = ".people.scroller li")
    private WebElement firstActorTopBilledCast;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String getTextGenres() {
        return genres.getText();
    }

    public String getTextMovieTitle() {
        return movieTitle.getText();
    }

    public ActorPage clickFirstActorTopBilledCast(){
        firstActorTopBilledCast.click();
        return new ActorPage(driver);
    }
}

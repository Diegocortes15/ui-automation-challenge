package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActorPage extends BasePage{

    @FindBy(css = ".zero + .credits bdi")
    private List<WebElement> moviesList;

    public ActorPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMovieInActingTimeline(String movie){
        List<String> movies = moviesList.stream().map(WebElement::getText).toList();

        return movies.contains(movie);
    }
}

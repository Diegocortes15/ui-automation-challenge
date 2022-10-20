package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ActorPage extends BasePage{

    @FindBy(css = ".zero + .credits bdi")
    private List<WebElement> moviesList;

    public ActorPage(WebDriver driver) {
        super(driver);
    }

    @Step("⏩ Verify if movie is in acting timeline. Step...")
    public boolean isMovieInActingTimeline(String movie){
        List<String> movies = moviesList.stream().map(WebElement::getText).collect(Collectors.toList());
        return movies.contains(movie);
    }
}

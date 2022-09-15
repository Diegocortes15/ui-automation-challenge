package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends BasePage{

    @FindBy(className = "genres")
    private WebElement genres;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String getTextGenres() {
        return genres.getText();
    }
}

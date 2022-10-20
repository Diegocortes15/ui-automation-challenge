package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".movie .card:nth-child(1) .title h2")
    private WebElement firstResult;

    @Step("⏩ Get first movie title. Step...")
    public String getFirstTitleResult() {
        return firstResult.getText();
    }

}

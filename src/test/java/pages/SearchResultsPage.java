package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".movie .card:nth-child(1) .title h2")
    private WebElement firstResult;

    public String getTitleFirstResult() {
        return firstResult.getText();
    }

}

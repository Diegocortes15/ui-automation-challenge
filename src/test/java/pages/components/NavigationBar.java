package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NavigationBar extends BasePage {
    @FindBy(css = ".search[href='/search']")
    private WebElement searchButton;

    @FindBy(id = "search_v4")
    private WebElement searchBar;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }
}

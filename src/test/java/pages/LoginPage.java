package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.NavigationBar;

public class LoginPage extends BasePage {

    NavigationBar navigationBar;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login_button")
    private WebElement loginButton;

    @FindBy(css = ".error_status h2")
    private WebElement errorTitle;

    @FindBy(css = ".error_status  .content ul li:nth-child(1)")
    private WebElement errorTextOne;

    @FindBy(css = ".error_status  .content ul li:nth-child(2)")
    private WebElement errorTextTwo;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public String getErrorTitle() {
        return errorTitle.getText();
    }

    public String getErrorTextOne() {
        return errorTextOne.getText();
    }

    public String getErrorTextTwo() {
        return errorTextTwo.getText();
    }

    public LoginPage loginUser(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    public SearchResultsPage searchMovie(String movie) {
        navigationBar.getSearchButton().click();
        navigationBar.getSearchBar().sendKeys(movie);
        navigationBar.getSearchBar().sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}

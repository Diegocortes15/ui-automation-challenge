package pages;

import io.qameta.allure.Step;
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

    @Step("⏩ User login. Step...")
    public void loginUser(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Step("⏩ Get the navigation bar. Step...")
    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    @Step("⏩ Get error title. Step...")
    public String getErrorTitle() {
        return errorTitle.getText();
    }

    @Step("⏩ Get first error message. Step...")
    public String getErrorTextOne() {
        return errorTextOne.getText();
    }

    @Step("⏩ Get second error message. Step...")
    public String getErrorTextTwo() {
        return errorTextTwo.getText();
    }
}

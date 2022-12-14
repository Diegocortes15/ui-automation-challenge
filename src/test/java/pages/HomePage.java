package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.NavigationBar;

public class HomePage extends BasePage {

    NavigationBar navigationBar;

    @FindBy(css = ".primary li:nth-child(3) a")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    @Step("⏩ Get the navigation bar. Step...")
    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}

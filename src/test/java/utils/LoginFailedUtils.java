package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginFailedUtils {

    public static void assertWeCouldntFindYourUsername(LoginPage loginPage) {
        Assert.assertTrue(loginPage.getErrorTitle().contains("There was a problem"));
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't find your username."));
        Assert.assertTrue(loginPage.getErrorTextTwo().contains("remaining login attempts"));
    }

    public static void assertWeCouldntValidateYourUsername(LoginPage loginPage) {
        Assert.assertTrue(loginPage.getErrorTitle().contains("There was a problem"));
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't validate your information. Want to try again?"));
        Assert.assertTrue(loginPage.getErrorTextTwo().contains("remaining login attempts"));
    }

}

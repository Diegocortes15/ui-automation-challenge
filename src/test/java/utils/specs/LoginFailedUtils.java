package utils.specs;

import org.testng.Assert;
import pages.LoginPage;

public class LoginFailedUtils {

    private static void assertThereWasAProblem(LoginPage loginPage){
        Assert.assertTrue(loginPage.getErrorTitle().contains("There was a problem"));
        Assert.assertTrue(loginPage.getErrorTextTwo().contains("remaining login attempts"));
    }

    public static void assertWeCouldntFindYourUsername(LoginPage loginPage) {
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't find your username."));
        assertThereWasAProblem(loginPage);
    }

    public static void assertWeCouldntValidateYourInformation(LoginPage loginPage) {
        Assert.assertTrue(loginPage.getErrorTextOne().contains("We couldn't validate your information. Want to try again?"));
        assertThereWasAProblem(loginPage);
    }
}

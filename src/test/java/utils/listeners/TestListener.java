package utils.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import specs.BaseTest;

public class TestListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        System.out.printf("I am in onTestFailure method %s failed%n", getTestMethodName(iTestResult));

        // Get driver from BaseTest asn assign to local WebDriver local variable
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        // Allure ScreenShotRobot ans SaveTestLog
        if (driver != null) {
            System.out.printf("Screenshot captured for test case: %s%n", getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }

        // Save a log on allure
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }
}

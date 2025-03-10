package ShareDataBrowser;

import Logger.LoggerUtility;
import ChainTestUtility.ChainUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;
@Listeners(ChainTestListener.class)
public class Hooks extends ShareData{
    String testName;
    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        initializeBrowser();
        LoggerUtility.startTestCase(testName);
    }
    @AfterMethod
    public void clearEnvironment(ITestResult result) throws IOException {
        clearBrowser();
        if (result.getStatus() == ITestResult.FAILURE){
            LoggerUtility.errorLog(result.getThrowable().getMessage());
            byte[] screenShot = ChainUtility.getScreenShot(getDriver(),"ChainTestSrc");
            ChainTestListener.embed(screenShot,"image/png");
        }
        LoggerUtility.endTestCase(testName);
    }
    @AfterSuite
    public void finishLogs(){
        LoggerUtility.mergeFilesIntoOne();
    }
}

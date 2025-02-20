package ShareDataBrowser;


import ChainTestUtility.ChainUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(ChainTestListener.class)
public class ShareData {
    private WebDriver driver;

@BeforeMethod
    public void initializeBrowser(){
        this.driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        WebElement consent = getDriver().findElement(By.xpath("//p[text()='Consent']"));
        consent.click();



    }
@AfterMethod
    public void clearBrowser() throws IOException {
        byte[] screenShot = ChainUtility.getScreenShot(getDriver(),"ChainTestSrc");
        ChainTestListener.embed(screenShot,"image/png");
    /*driver.quit();*/
    }

    public WebDriver getDriver() {
        return driver;
    }
}



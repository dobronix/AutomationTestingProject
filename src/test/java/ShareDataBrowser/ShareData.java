package ShareDataBrowser;


import ChainTestUtility.ChainUtility;
import ShareDataBrowser.Browser.BrowserFactory;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;


public class  ShareData {
    private WebDriver driver;


    public void initializeBrowser(){
        driver = new BrowserFactory().geBrowserFactory();
        driver.get("https://www.automationexercise.com/");


    }

    public void clearBrowser()  {

    driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}



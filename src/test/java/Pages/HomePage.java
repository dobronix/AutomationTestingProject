package Pages;

import HelperMethods.ElementsHelpers;
import Logger.LoggerUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    ElementsHelpers elementsHelpers;


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsHelpers = new ElementsHelpers(driver);

        PageFactory.initElements(driver,this); //se pot indentifica elementele prin @findBy
    }

    @FindBy(xpath = "//p[text()='Consent']")
    WebElement consent;

    @FindBy(xpath = "//[text()= ' Products']")
    WebElement products;

    @FindBy(xpath = "//[text()= ' Cart']")
    WebElement cart;

    @FindBy(xpath = "//a [text() = ' Signup / Login']")
    WebElement login;

    @FindBy(xpath = "//*[text()= ' Contact us']")
    WebElement contactUs;


    public void clickOnConsent()
    {
        elementsHelpers.clickOnElement(consent);
        ChainTestListener.log("Click on consent ");
    }

    public void clickOnProducts()
    {
        elementsHelpers.clickOnElement(products);
    }

    public void clickOnCart()
    {
        elementsHelpers.clickOnElement(cart);
    }

    public void clickOnLogin()
    {
        elementsHelpers.clickOnElement(login);
        ChainTestListener.log("Click Signup/Login");
        LoggerUtility.infoTest(" The user clicks on Signup/Login button");
    }

    public void clickOnContactUs()
    {
        elementsHelpers.clickOnElement(contactUs);
        ChainTestListener.log("Click contact us");
        LoggerUtility.infoTest(" The user clicks on Contact page");
    }





}

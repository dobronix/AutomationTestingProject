package Pages;

import HelperMethods.ElementsHelpers;
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
    @FindBy(xpath ="//*[text()=' Logged in as ']")
    WebElement logInDisplayed;

    public void clickOnConsent()
    {
        elementsHelpers.clickOnElement(consent);
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
    }

    public void clickOnContactUs()
    {
        elementsHelpers.clickOnElement(contactUs);
    }
    public void assertLoggedIng(){
        elementsHelpers.assertDisplay(logInDisplayed);
    }




}

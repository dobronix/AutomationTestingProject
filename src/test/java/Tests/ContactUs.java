package Tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;

public class ContactUs extends Hooks {

    HomePage homePage;
    ContactUsPage contactUsPage;

    @Test

    public void ContactPage(){
        contactUsPage = new ContactUsPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnConsent();
        homePage.clickOnContactUs();
        contactUsPage.completeContactUsPage("Dobro", "dobro@2dbr.com", "Thank you, the product is what I expected", "Product Arrived");

    }
}

package Tests.Contact;

import Pages.ContactUsPage;
import Pages.HomePage;
import ShareDataBrowser.ShareData;
import org.testng.annotations.Test;

public class ContactUs extends ShareData {

    HomePage homePage;
    ContactUsPage contactUsPage;

    @Test

    public void ContactPage(){
        contactUsPage = new ContactUsPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnContactUs();
        contactUsPage.completeContactUsPage("Dobro", "dobro@2dbr.com", "Thank you, the product is what I expected", "Product Arrived");

    }
}

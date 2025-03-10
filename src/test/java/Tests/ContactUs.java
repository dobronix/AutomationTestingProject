package Tests;


import ObjectData.ContactFormObjectData;
import Pages.ContactUsPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import XmlReaderUtility.XmlReader;
import org.testng.annotations.Test;

import java.util.Map;

public class ContactUs extends Hooks {

    HomePage homePage;
    ContactUsPage contactUsPage;
    private Map<String, ContactFormObjectData> contactFormObjectDataMap;

    @Test

    public void ContactPage(){
        contactFormObjectDataMap = XmlReader.loadData("src/test/resources/contactFormData.xml", ContactFormObjectData.class );
        ContactFormObjectData data3 = contactFormObjectDataMap.get("dataSet_1");
        contactUsPage = new ContactUsPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnConsent();
        homePage.clickOnContactUs();
        contactUsPage.completeContactUsPage(data3);

    }
}

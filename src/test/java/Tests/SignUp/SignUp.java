package Tests.SignUp;

import ObjectData.SignUpFormObjectData;
import Pages.HomePage;
import Pages.SingUpLoginPage;
import Pages.SingUpPage;
import ShareDataBrowser.ShareData;
import XmlReaderUtility.XmlReader;
import org.testng.annotations.Test;

import java.util.Map;

public class SignUp extends ShareData {


    SingUpPage singUpPage;
    SingUpLoginPage singUpLoginPage;
    HomePage homePage;
    private Map<String, SignUpFormObjectData> signUpFormObjectDataMap;

    @Test

    public void SignUpTest() throws InterruptedException {
        signUpFormObjectDataMap = XmlReader.loadData("src/test/resources/signUpFormData.xml", SignUpFormObjectData.class);
        SignUpFormObjectData data = signUpFormObjectDataMap.get("dataSet_1");
        singUpPage = new SingUpPage(getDriver());
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnLogin();
        singUpLoginPage.completeName("dobro");
        singUpLoginPage.comleteEmail("dobro@ddasd.com");
        singUpLoginPage.cliclSLButton();
        Thread.sleep(2000);
        singUpPage.CompleteSingUp(data);

    }
}

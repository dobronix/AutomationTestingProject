package Tests.SignUp;

import ObjectData.SignUpFormObjectData;
import ObjectData.SignUpLogInFormObjectData;
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
    private Map<String, SignUpLogInFormObjectData> signUpLogInFormObjectDataMap;

    @Test

    public void SignUpTest() throws InterruptedException {
        signUpFormObjectDataMap = XmlReader.loadData("src/test/resources/signUpFormData.xml", SignUpFormObjectData.class);
        signUpLogInFormObjectDataMap =XmlReader.loadData("src/test/resources/signUpLogInFormData.xml", SignUpLogInFormObjectData.class);
        SignUpFormObjectData data = signUpFormObjectDataMap.get("dataSet_1");
        SignUpLogInFormObjectData data1 = signUpLogInFormObjectDataMap.get("dataSet_1");
        singUpPage = new SingUpPage(getDriver());
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnLogin();
        singUpLoginPage.completeName(data1);
        singUpLoginPage.comleteEmail(data1);
        singUpLoginPage.cliclSLButton();
        Thread.sleep(2000);
        singUpPage.CompleteSingUp(data);

    }
}

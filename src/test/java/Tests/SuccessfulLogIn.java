package Tests;

import ObjectData.SignUpLogInFormObjectData;
import Pages.HomePage;
import Pages.SingUpLoginPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import XmlReaderUtility.XmlReader;
import org.testng.annotations.Test;

import java.util.Map;

public class SuccessfulLogIn extends Hooks {

    SingUpLoginPage singUpLoginPage;
    HomePage homePage;
    private Map<String, SignUpLogInFormObjectData> singUpLogInFormObjectDataMap;


    @Test

    public void LogINTest(){
        singUpLogInFormObjectDataMap = XmlReader.loadData("src/test/resources/signUpLogInFormData.xml", SignUpLogInFormObjectData.class);
        SignUpLogInFormObjectData data1 = singUpLogInFormObjectDataMap.get("dataSet_4");
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnLogin();
        singUpLoginPage.successfullLogIn(data1);

    }
}

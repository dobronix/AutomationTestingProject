package Tests;

import ObjectData.SignUpLogInFormObjectData;
import Pages.HomePage;
import Pages.SingUpLoginPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import XmlReaderUtility.XmlReader;
import org.testng.annotations.Test;

import java.util.Map;

public class DeleteAcc extends Hooks {

    SingUpLoginPage singUpLoginPage;
    HomePage homePage;
    private Map<String, SignUpLogInFormObjectData> singUpLogInFormObjectDataMap;

    @Test

    public void deleteAccTest(){
        singUpLogInFormObjectDataMap = XmlReader.loadData("src/test/resources/signUpLogInFormData.xml", SignUpLogInFormObjectData.class);
        SignUpLogInFormObjectData data1 = singUpLogInFormObjectDataMap.get("dataSet_3");
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnLogin();
        singUpLoginPage.deleteAcc(data1);

    }
}

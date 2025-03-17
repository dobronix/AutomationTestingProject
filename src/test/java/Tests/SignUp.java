package Tests;

import ObjectData.SignUpFormObjectData;
import ObjectData.SignUpLogInFormObjectData;
import Pages.HomePage;
import Pages.SingUpLoginPage;
import Pages.SingUpPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import XmlReaderUtility.XmlReader;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Map;

public class SignUp extends Hooks {


    SingUpPage singUpPage;
    SingUpLoginPage singUpLoginPage;
    HomePage homePage;
    private Map<String, SignUpFormObjectData> signUpFormObjectDataMap;
    private Map<String, SignUpLogInFormObjectData> signUpLogInFormObjectDataMap;

    @Test

    public void SignUpTest() throws InterruptedException, SQLException {
        signUpFormObjectDataMap = XmlReader.loadData("src/test/resources/signUpFormData.xml", SignUpFormObjectData.class);
        signUpLogInFormObjectDataMap =XmlReader.loadData("src/test/resources/signUpLogInFormData.xml", SignUpLogInFormObjectData.class);
        SignUpLogInFormObjectData data1 = signUpLogInFormObjectDataMap.get("dataSet_19");
        SignUpFormObjectData data = signUpFormObjectDataMap.get("dataSet_19");
        singUpPage = new SingUpPage(getDriver());
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnConsent();
        ChainTestListener.log(" Click on consent ");
        ChainTestListener.log("Open Home page ");
        homePage.clickOnLogin();
        singUpLoginPage.succesfullSignUp(data1);
        Thread.sleep(2000);
        singUpPage.CompleteSingUp(data);
        singUpPage.updateEntryInTable(data,2);


    }
}

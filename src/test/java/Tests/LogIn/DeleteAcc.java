package Tests.LogIn;

import Pages.HomePage;
import Pages.SingUpLoginPage;
import ShareDataBrowser.ShareData;
import org.testng.annotations.Test;

public class DeleteAcc extends ShareData {

    SingUpLoginPage singUpLoginPage;
    HomePage homePage;

    @Test

    public void deleteAccTest(){
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnLogin();
        singUpLoginPage.deleteAcc("dobro@ddasd.com","12345678");

    }
}

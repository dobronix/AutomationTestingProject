package Tests.LogIn;

import Pages.HomePage;
import Pages.SingUpLoginPage;
import ShareDataBrowser.ShareData;
import org.testng.annotations.Test;

public class LogOut extends ShareData {

    SingUpLoginPage singUpLoginPage;
    HomePage homePage;

    @Test

    public void LogOutmetod(){
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnLogin();
        singUpLoginPage.logOut("dobro@ddasd.com","12345678");

    }
}

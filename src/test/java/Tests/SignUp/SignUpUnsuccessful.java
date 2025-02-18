package Tests.SignUp;

import Pages.HomePage;
import Pages.SingUpLoginPage;
import ShareDataBrowser.ShareData;
import org.testng.annotations.Test;

public class SignUpUnsuccessful extends ShareData {

    SingUpLoginPage singUpLoginPage;
    HomePage homePage;

    @Test

    public void SignUpTestUnsuccessful() {
        singUpLoginPage = new SingUpLoginPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnLogin();
        singUpLoginPage.unsuccesfullSignUp("Nix","dobro@ddasd.com");

    }

}


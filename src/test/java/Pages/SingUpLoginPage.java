package Pages;

import HelperMethods.ElementsHelpers;
import ObjectData.SignUpLogInFormObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingUpLoginPage {
    WebDriver driver;
    ElementsHelpers elementsHelpers;

    public SingUpLoginPage(WebDriver driver){
        this.driver = driver;
        this.elementsHelpers = new ElementsHelpers(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@name='name']")
    WebElement fullName;
    @FindBy(xpath = "//*[@data-qa='signup-email']")
    WebElement email;
    @FindBy(xpath = "//*[@data-qa='signup-button']")
    WebElement submit;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    WebElement logInEmail;
    @FindBy(xpath = "//*[@data-qa='login-password']")
    WebElement loginPassword;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    WebElement loginButton;

    public void completeName(SignUpLogInFormObjectData data1) {
        elementsHelpers.fillElement(fullName, data1.getFullName());
    }
    public void comleteEmail(SignUpLogInFormObjectData data1){
        elementsHelpers.fillElement(email, data1.getEmail());
    }
    public void cliclSLButton(){
        elementsHelpers.clickOnElement(submit);
    }
    public void addEmail(SignUpLogInFormObjectData data1){
        elementsHelpers.fillElement(logInEmail, data1.getLogInEmail());
    }
    public void addPass(SignUpLogInFormObjectData data1){
        elementsHelpers.fillElement(loginPassword, data1.getLogInPassword());
    }
    public void clickLogIn(){
        elementsHelpers.clickOnElement(loginButton);
    }
    @FindBy(xpath = "//*[text()='Email Address already exist!']")
    WebElement emailExist;
    public void assertEmailExist(String text) {
        elementsHelpers.assertText(emailExist, text);
    }
    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    WebElement unsLogin;
    public void assertUnsLogin(){
        elementsHelpers.assertDisplay(unsLogin);
    }
    public void assertUrl(String text){
        elementsHelpers.assertCurrentUrl(text);
    }
    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logOutButton;
    public void clickLogOut(){
        elementsHelpers.clickOnElement(logOutButton);
    }
    @FindBy(xpath ="//*[text()=' Logged in as ']")
    WebElement logInDisplayed;
    public void assertLoggedIng(){
        elementsHelpers.assertDisplay(logInDisplayed);
    }
    @FindBy(xpath = "//*[@class='fa fa-trash-o']")
    WebElement deleteButton;
    public void clickDelete(){
        elementsHelpers.clickOnElement(deleteButton);
    }

    public void unsuccesfullSignUp(SignUpLogInFormObjectData data1){
        completeName(data1);
        comleteEmail(data1);
        cliclSLButton();
        assertEmailExist("Email Address already exist!");

    }
    public void successfullLogIn(SignUpLogInFormObjectData data1){
        addEmail(data1);
        addPass(data1);
        clickLogIn();
        assertLoggedIng();
    }
    public void unsuccesfullLogIn(SignUpLogInFormObjectData data1){
        addEmail(data1);
        addPass(data1);
        clickLogIn();
        assertUnsLogin();
    }
    public void logOut(SignUpLogInFormObjectData data1){
        addEmail(data1);
        addPass(data1);
        clickLogIn();
        clickLogOut();
        assertUrl("https://www.automationexercise.com/login");
    }
    public void deleteAcc(SignUpLogInFormObjectData data1){
        addEmail(data1);
        addPass(data1);
        clickLogIn();
        clickDelete();
        assertUrl("https://www.automationexercise.com/delete_account");
    }


}

package Pages;

import HelperMethods.ElementsHelpers;
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

    public void completeName(String text) {
        elementsHelpers.fillElement(fullName, text);
    }
    public void comleteEmail(String text){
        elementsHelpers.fillElement(email,text);
    }
    public void cliclSLButton(){
        elementsHelpers.clickOnElement(submit);
    }
    public void addEmail(String text){
        elementsHelpers.fillElement(logInEmail,text);
    }
    public void addPass(String text){
        elementsHelpers.fillElement(loginPassword,text);
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

    public void unsuccesfullSignUp(String name, String email){
        completeName(name);
        comleteEmail(email);
        cliclSLButton();
        assertEmailExist("Email Address already exist!");

    }
    public void successfullLogIn(String email,String password){
        addEmail(email);
        addPass(password);
        clickLogIn();
        assertLoggedIng();
    }
    public void unsuccesfullLogIn(String email, String password){
        addEmail(email);
        addPass(password);
        clickLogIn();
        assertUnsLogin();
    }
    public void logOut(String email, String password){
        addEmail(email);
        addPass(password);
        clickLogIn();
        clickLogOut();
        assertUrl("https://www.automationexercise.com/login");
    }
    public void deleteAcc(String email,String password){
        addEmail(email);
        addPass(password);
        clickLogIn();
        clickDelete();
        assertUrl("https://www.automationexercise.com/delete_account");
    }


}

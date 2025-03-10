package Pages;

import HelperMethods.ElementsHelpers;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;
    ElementsHelpers elementsHelpers;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        this.elementsHelpers = new ElementsHelpers(driver);

        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath ="//*[@name='name']" )
    WebElement contactName;
    @FindBy(xpath ="//*[@name='email']" )
    WebElement contactEmail;
    @FindBy(xpath = "//*[@name='subject']")
    WebElement contactSubject;
    @FindBy(id = "message")
    WebElement contactMessage;
    @FindBy(xpath ="//input[@type='file']" )
    WebElement contactAddFIle;
    @FindBy(xpath = "//*[@value='Submit']")
    WebElement contactSubmit;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement contactSucces;

    public void fillCname(String text){
        elementsHelpers.fillElement(contactName,text);
    }
    public void fillCemail(String text){
        elementsHelpers.fillElement(contactEmail,text);
    }
    public void fillSUbject(String text){
        elementsHelpers.fillElement(contactSubject,text);
    }
    public void fillMessage(String text){
        elementsHelpers.fillElement(contactMessage,text);
    }
    public void addCfile(){
        elementsHelpers.addFIle(contactAddFIle,"src/test/resources/menTshirt.jpg");
    }
    public void submitContact(){
        elementsHelpers.clickOnElement(contactSubmit);
    }
    public void assertContact(String text){
        elementsHelpers.assertText(contactSucces,text);
    }
    public void acceptAllert(){
        elementsHelpers.allert();
    }
    public void completeContactUsPage(String name, String email, String subject, String yourmessage){
        fillCname(name);
        fillCemail(email);
        fillSUbject(subject);
        fillMessage(yourmessage);
        addCfile();
        submitContact();
        acceptAllert();
        assertContact("Success! Your details have been submitted successfully.");
        ChainTestListener.log("Contact us completed");
    }



}

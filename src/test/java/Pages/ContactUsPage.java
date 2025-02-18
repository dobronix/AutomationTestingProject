package Pages;

import HelperMethods.ContactHelpers;
import HelperMethods.ElementsHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;
    ElementsHelpers elementsHelpers;
    ContactHelpers contactHelpers;
    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        this.elementsHelpers = new ElementsHelpers(driver);
        this.contactHelpers = new ContactHelpers(driver);
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
        contactHelpers.addFIle(contactAddFIle,"src/test/resources/menTshirt.jpg");
    }
    public void submitContact(){
        elementsHelpers.clickOnElement(contactSubmit);
    }
    public void assertContact(String text){
        elementsHelpers.assertText(contactSucces,text);
    }
    public void acceptAllert(){
        contactHelpers.allert();
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
    }



}

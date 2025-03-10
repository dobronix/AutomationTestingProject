package Pages;

import HelperMethods.ElementsHelpers;
import ObjectData.ContactFormObjectData;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

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

    public void addFIle(WebElement element,String text) {
        File shirt = new File(text);
        String absolutePath = shirt.getAbsolutePath();
        element.sendKeys(absolutePath);
    }

    public void fillCname(ContactFormObjectData data3){
        elementsHelpers.fillElement(contactName, data3.getName());
    }
    public void fillCemail(ContactFormObjectData data3){
        elementsHelpers.fillElement(contactEmail, data3.getEmail());
    }
    public void fillSubject(ContactFormObjectData data3){
        elementsHelpers.fillElement(contactSubject, data3.getSubject());
    }
    public void fillMessage(ContactFormObjectData data3){
        elementsHelpers.fillElement(contactMessage, data3.getYourmessage());
    }
    public void addCfile(){
        addFIle(contactAddFIle,"src/test/resources/menTshirt.jpg");
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
    public void completeContactUsPage(ContactFormObjectData data3){
        fillCname(data3);
        fillCemail(data3);
        fillSubject(data3);
        fillMessage(data3);
        addCfile();
        submitContact();
        acceptAllert();
        assertContact("Success! Your details have been submitted successfully.");
        ChainTestListener.log("Contact us completed");
    }



}

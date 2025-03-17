package Pages;

import HelperMethods.ElementsHelpers;
import Logger.LoggerUtility;
import ObjectData.SignUpFormObjectData;
import com.aventstack.chaintest.plugins.ChainTestListener;
import dataBase.queries.SignUpTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLException;
import java.util.List;

public class SingUpPage {
    WebDriver driver;
    ElementsHelpers elementsHelpers;
    SignUpTable signUpTable;



    public SingUpPage(WebDriver driver) throws SQLException {
        this.driver = driver;
        this.elementsHelpers = new ElementsHelpers(driver);
        signUpTable = new SignUpTable();
        PageFactory.initElements(driver, this);
    }
    public void selectElementVsText(WebElement element,String text){
        Select selectMonth = new Select(element);
        selectMonth.selectByVisibleText(text);
    }
    public void selectElementValue(WebElement element,String text){
        Select selectYear = new Select(element);
        selectYear.selectByValue(text);
    }
    public void selectGender(WebElement element,WebElement element2,String gender) {
        switch (gender) {
            case "Mr":
                element.click();
                break;
            case "Mrs":
                element2.click();
                break;
        }
    }
    public void selectCountry(WebElement element,String text){
        while (true){
            String currentText = element.getAttribute("value");
            if (currentText.equals(text)){
                element.sendKeys(Keys.ENTER);
                break;
            }
            element.sendKeys(Keys.ARROW_DOWN);
        }
    }

    @FindBy(xpath = "//*[@class='login-form']")
    List<WebElement> elements;
    public void clickByText(String SUelements){
        elementsHelpers.clickOnElementByText(elements, SUelements);
    }
    @FindBy(xpath = "//label[@for='id_gender1']")
    WebElement Mr;
    @FindBy(xpath = "//label[@for='id_gender2']")
    WebElement Mrs;
    public void useGender(SignUpFormObjectData data){
        selectGender(Mr,Mrs, data.getGender());
    }
    @FindBy(id = "password")
    WebElement password;
    public void fillPasswrod(SignUpFormObjectData data){
        elementsHelpers.fillElement(password, data.getPassword());
    }
    @FindBy(id = "days")
    WebElement day;
    public void selectDay(SignUpFormObjectData data){
        selectElementVsText(day,data.getDay());
    }
    @FindBy(id = "months")
    WebElement month;
    public void selectMonth(SignUpFormObjectData data){
        selectElementVsText(month, data.getMonth());
    }
    @FindBy(id = "years")
    WebElement year;
    public void selectYear(SignUpFormObjectData data){
        selectElementValue(year, data.getYear());
    }
    @FindBy(id = "newsletter")
    WebElement news;
    public void clickNEws(){
        elementsHelpers.clickOnElement(news);
    }
    @FindBy(id = "optin")
    WebElement offers;
    public void clickOffers(){
        elementsHelpers.clickOnElement(offers);
    }
    @FindBy(id = "first_name")
    WebElement firstname;
    public void fillName(SignUpFormObjectData data){
        elementsHelpers.fillElement(firstname,data.getFirstName());
    }
    @FindBy(id = "last_name")
    WebElement lastName;
    public void fillLname(SignUpFormObjectData data){
        elementsHelpers.fillElement(lastName,data.getLastName());
    }
    @FindBy(id = "company")
    WebElement companyField;
    public void fillcompany(SignUpFormObjectData data){
        elementsHelpers.fillElement(companyField,data.getCompany());
    }
    @FindBy(id = "address1")
    WebElement address1Field;
    public void filladress(SignUpFormObjectData data){
        elementsHelpers.fillElement(address1Field,data.getAdress());
    }
    @FindBy(id = "country")
    WebElement country;
    public void selectCountry(String text){
        selectCountry(country,text);
    }
    @FindBy(id = "state")
    WebElement state;
    public void fillState(SignUpFormObjectData data){
        elementsHelpers.fillElement(state,data.getState());
    }
    @FindBy(id = "city")
    WebElement city;
    public void fillCity(SignUpFormObjectData data){
        elementsHelpers.fillElement(city,data.getCity());
    }
    @FindBy(id = "zipcode")
    WebElement zipcode;
    public void fillZip(SignUpFormObjectData data){
        elementsHelpers.fillElement(zipcode,data.getZipcode());
    }
    @FindBy(id = "mobile_number")
    WebElement mobile;
    public void fillMobile(SignUpFormObjectData data){
        elementsHelpers.fillElement(mobile,data.getMobile());
    }
    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement create;
    public void createBUtton(){
        elementsHelpers.clickOnElement(create);
    }
    @FindBy(xpath ="//h2[@data-qa='account-created']" )
    WebElement accCreated;
    public void assertACC(String text){
        elementsHelpers.assertText(accCreated,text);
    }
    @FindBy(xpath ="//*[@data-qa='continue-button']" )
    WebElement continueButton;
    public void clickCont(){
        elementsHelpers.clickOnElement(continueButton);
    }
    public void addEntryInTable(SignUpFormObjectData data) throws SQLException {
        signUpTable.insertTableObject(data);
    }
    public void updateEntryInTable(SignUpFormObjectData data, Integer id) throws SQLException{
        signUpTable.updateEntryById(data,id);
    }

    public void CompleteSingUp(SignUpFormObjectData data) throws SQLException {
        useGender(data);
        fillPasswrod(data);
        selectDay(data);
        selectMonth(data);
        selectYear(data);
        clickNEws();
        clickOffers();
        fillName(data);
        fillLname(data);
        fillcompany(data);
        filladress(data);
        selectCountry("Canada");
        fillState(data);
        fillCity(data);
        fillZip(data);
        fillMobile(data);
        addEntryInTable(data);
        LoggerUtility.infoTest(" The user complete all the SignUp fields");
        createBUtton();
        LoggerUtility.infoTest(" The user click on CreateAcc button");
        assertACC("ACCOUNT CREATED!");
        clickCont();
        LoggerUtility.infoTest(" The user click on Continue button");
        ChainTestListener.log("Sign up completed");
    }

}

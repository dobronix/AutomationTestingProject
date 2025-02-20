package HelperMethods;

import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.testng.Assert;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.io.File;
import java.util.List;

public class ElementsHelpers {
    WebDriver driver;

    public ElementsHelpers(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element)
    {
        element.click();
    }

    public void fillElement(WebElement element,String text){
        element.sendKeys(text);
    }



    public void getCurrentUrl(String text)
    {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, text);
    }
    public void assertText(WebElement element ,String text){
        Assert.assertEquals(element.getText(),text);
    }
    public void assertDisplay(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }
    public void assertCurrentUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    public void clickOnElementByText(List<WebElement> webElementList, String text){

        for (int i= 0;i < webElementList.size(); i++){

            if (webElementList.get(i).getText().equals(text)){

                clickOnElement(webElementList.get(i));

                break;
            }
        }
    }
    public void addFIle(WebElement element,String text){
        File shirt = new File(text);
        String absolutePath = shirt.getAbsolutePath();
        element.sendKeys(absolutePath);
    }
    public void allert(){
        Alert allert = driver.switchTo().alert();
        allert.accept();
    }

}

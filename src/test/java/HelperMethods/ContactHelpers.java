package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class ContactHelpers {
    WebDriver driver;
    public ContactHelpers(WebDriver driver){
        this.driver = driver;

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

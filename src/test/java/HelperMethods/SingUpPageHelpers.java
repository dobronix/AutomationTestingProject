package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SingUpPageHelpers {
    WebDriver driver;

    public SingUpPageHelpers(WebDriver driver) {
        this.driver = driver;
    }

        public void selectElementindex(WebElement element,Integer number ){
            Select selectDay = new Select(element);
            selectDay.selectByIndex(number);
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

}

//select, switch
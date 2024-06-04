package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    //Click on element method
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    //Get text from element method
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    //Send text to element
    public void sendTextToElement(By by,String text){
        /**WebElement emailField = driver.findElement(by);
         emailField.sendKeys(text);   */
        driver.findElement(by).sendKeys(text);
    }

    //Select Class Methods
    ///1.selectByValueFromDropDown(By by,String value)
    public void selectByValueFromDropDown(By by,String value){
        WebElement dropDown=driver.findElement(by);
        // Create the object of Select class
        Select select=new Select(dropDown);
        // Select by value
        select.selectByValue(value);
    }

    //2.selectByIndexFromDropDown(By by,int index)
    public void selectByIndexFromDropDown(By by,int index){
        WebElement dropDown=driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        //Select by index
        select.selectByIndex(index);
    }

    //3.selectByVisibleTextFromDropDown(By by,String text)
    public void selectByVisibleTextFromDropDown(By by,String text){
        WebElement dropDown=driver.findElement(by);
        //Create the object of select class
        Select select=new Select(dropDown);
        //Select by text
        select.selectByVisibleText(text);
    }

    //4.get multiple
    public List<WebElement> getMultipleElements(By by) {
        return driver.findElements(by);

    }
}

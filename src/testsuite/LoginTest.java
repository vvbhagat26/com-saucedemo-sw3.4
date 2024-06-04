package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseurl = "https://www.saucedemo.com/"; //I want to open this url

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter password
        sendTextToElement(By.id("password"), "secret_sauce");

        //Click on login
        clickOnElement(By.id("login-button"));

        //Verify the text products
        String expectedText = "Products";
        WebElement welcomeText = driver.findElement(By.xpath(" //span[@class='title']"));
        String actualText = welcomeText.getText();
        Assert.assertEquals("Not expected text", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("visual_user");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on a page
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        int expectedProducts = 6;
        Assert.assertEquals("User can not see six products ", expectedProducts, products.size());
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}

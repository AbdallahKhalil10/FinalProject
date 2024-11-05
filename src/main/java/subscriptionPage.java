import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class subscriptionPage {
    WebDriver driver;

    //CONSTRUCTOR
    public subscriptionPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By cartTabButton = By.xpath("//a[@href=\"/view_cart\"]");
    private By subscriptionHeader = By.xpath("//div[@class=\"single-widget\"]//h2");
    private By subscriptionEmailTextField = By.xpath("//input[@id=\"susbscribe_email\"]");
    private By arrowButton = By.xpath("//button[@id=\"subscribe\"]");
    private By subscriptionSuccessMessage = By.xpath("//div[@class=\"alert-success alert\"]");


    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickCartTabButton(){
        driver.findElement(cartTabButton).click();
    }

    public void fillSubscriptionEmailTextField(String email){
        driver.findElement(subscriptionEmailTextField).sendKeys(email);
    }

    public void clickArrowButton(){
        driver.findElement(arrowButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnSubscriptionHeader(String expectedSubscriptionHeader){
        String actualSubscriptionHeader = driver.findElement(subscriptionHeader).getText();
        Assert.assertEquals(actualSubscriptionHeader, expectedSubscriptionHeader);
    }

    public void assertOnSubscriptionSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSuccessMessage));
        Assert.assertTrue(message.isDisplayed());
    }




}

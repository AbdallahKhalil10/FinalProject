import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class addingRecommendedItemsFeature {
    WebDriver driver;


    //CONSTRUCTOR
    public addingRecommendedItemsFeature(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By recommendedItemsHeader = By.xpath("//div[@class=\"recommended_items\"]//h2[@class=\"title text-center\"]");
    private By addToCartButton = By.xpath("//div[@class=\"item active\"]//div//div//a[@data-product-id=\"4\"]");
    private By viewCartButton = By.xpath("//a[@href=\"/view_cart\"]//u");
    private By popupWindow = By.xpath("//div[@class=\"modal-content\"]");
    private By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");



    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void moveScrollDownBar(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,7000)");
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public void clickViewCartButton(){
        driver.findElement(viewCartButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnRecommendedItemsHeader(String expectedRecommendedItemsHeader){
        String actualRecommendedItemsHeader = driver.findElement(recommendedItemsHeader).getText();
        Assert.assertEquals(actualRecommendedItemsHeader, expectedRecommendedItemsHeader);
    }

    public void assertOnPopupWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupWindow));
        Assert.assertTrue(popup.isDisplayed());
    }

    public void assertOnCartPageHeader(String expectedCartPageHeader){
        String actualHomePageHeader = driver.findElement(proceedToCheckoutButton).getText();
        Assert.assertEquals(actualHomePageHeader, expectedCartPageHeader);
    }
}

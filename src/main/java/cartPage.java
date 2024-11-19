import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;

public class cartPage {
    WebDriver driver;


    //CONSTRUCTOR
    public cartPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By productsTabButton = By.xpath("//a[@href=\"/products\"]");
    private By viewProductButton = By.xpath("//a[@href=\"/product_details/1\"]");
    private By increaseQuantityButton = By.xpath("//input[@id=\"quantity\"]");
    private By addToCartButton = By.xpath("//button[@class=\"btn btn-default cart\"]");
    private By productQuantity = By.xpath("//tr[@id=\"product-1\"]//button[@class=\"disabled\"]");


    private By ProductToHoverFirstProduct = By.xpath("//img[@src=\"/get_product_picture/1\"]");
    private By ProductToHoverSecondProduct = By.xpath("//img[@src=\"/get_product_picture/2\"]");
    private By addToCartButtonFirstProduct = By.xpath("//div[@class=\"overlay-content\"]//a[@data-product-id=\"1\"]");
    private By addToCartButtonSecondProduct = By.xpath("//div[@class=\"overlay-content\"]//a[@data-product-id=\"2\"]");
    private By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By viewCartButton = By.xpath("//a[@href=\"/view_cart\"]//u");
    private By popupWindow = By.xpath("//div[@class=\"modal-content\"]");
    private By firstProductPrice = By.xpath("//tr[@id=\"product-1\"]//td[@class=\"cart_price\"]//p");
    private By secondProductPrice = By.xpath("//tr[@id=\"product-2\"]//td[@class=\"cart_price\"]//p");
    private By firstProductQuantity = By.xpath("//tr[@id=\"product-1\"]//td//button");
    private By secondProductQuantity = By.xpath("//tr[@id=\"product-2\"]//td//button");


    private By cartTabButton = By.xpath("//ul//a[@href=\"/view_cart\"]");
    private By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By removeButton = By.xpath("//a[@class=\"cart_quantity_delete\"]");
    private By removingHeader = By.xpath("//p[@style=\"font-size: 18px;\"]");




    //ACTIONS
   public void navigateToURL(String URL){
       driver.get(URL);
   }

   public void clickProductsTabButton(){
       driver.findElement(productsTabButton).click();
   }

    public void clickCartTabButton(){
       driver.findElement(cartTabButton).click();
    }


    public void clickViewProductButton(){
       driver.findElement(viewProductButton).click();
    }

    public void clickIncreaseQuantityButton(String newQuantity){
       driver.findElement(increaseQuantityButton).clear();
       driver.findElement(increaseQuantityButton).sendKeys(newQuantity);
    }

    public void clickAddToCartButton(){
       driver.findElement(addToCartButton).click();
    }

    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
    }

    public void hoverOverFirstProduct(){
       WebElement firstProductToHover = driver.findElement(ProductToHoverFirstProduct);
       Actions action = new Actions(driver);
       action.moveToElement(firstProductToHover).perform();
    }

    public void hoverOverSecondProduct(){
        WebElement secondProductToHover = driver.findElement(ProductToHoverSecondProduct);
        Actions action = new Actions(driver);
        action.moveToElement(secondProductToHover).perform();
    }

    public void clickAddToCartButtonForFirstProduct(){
       driver.findElement(addToCartButtonFirstProduct).click();
    }

    public void clickAddToCartButtonForSecondProduct(){
       driver.findElement(addToCartButtonSecondProduct).click();
    }

    public void clickContinueShoppingButton(){
       driver.findElement(continueShoppingButton).click();
    }

    public void clickViewCartButton(){
       driver.findElement(viewCartButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
       String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnCartPageHeader(String expectedCartPageHeader){
        String actualHomePageHeader = driver.findElement(proceedToCheckoutButton).getText();
        Assert.assertEquals(actualHomePageHeader, expectedCartPageHeader);
    }

    public void assertOnRemoveProductSuccessfully(String expectedRemoveProductHeader){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(removingHeader));
        Assert.assertTrue(emptyCartMessage.isDisplayed());
    }

    public void assertOnPopupWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupWindow));
        Assert.assertTrue(popup.isDisplayed());
    }

    public void assertOnHoveringFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductToHoverFirstProduct));
        Assert.assertTrue(hover.isDisplayed());
    }

    public void assertOnHoveringSecondProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductToHoverSecondProduct));
        Assert.assertTrue(hover.isDisplayed());
    }

    public void assertOnProductQuantityAfterTheIncrease(String expectedProductQuantity){
        String actualProductQuantity = driver.findElement(productQuantity).getText();
        Assert.assertEquals(actualProductQuantity, expectedProductQuantity);
    }

    public void assertOnFirstProductPrice(String expectedFirstProductPrice){
        String actualFirstProductPrice = driver.findElement(firstProductPrice).getText();
        Assert.assertEquals(actualFirstProductPrice, expectedFirstProductPrice);
    }

    public void assertOnSecondProductPrice(String expectedSecondProductPrice){
        String actualSecondProductPrice = driver.findElement(secondProductPrice).getText();
        Assert.assertEquals(actualSecondProductPrice, expectedSecondProductPrice);
    }

    public void assertOnFirstProductQuantity(String expectedFirstProductQuantity){
        String actualFirstProductQuantity = driver.findElement(firstProductQuantity).getText();
        Assert.assertEquals(actualFirstProductQuantity, expectedFirstProductQuantity);
    }

    public void assertOnSecondProductQuantity(String expectedSecondProductQuantity){
        String actualSecondProductQuantity = driver.findElement(secondProductQuantity).getText();
        Assert.assertEquals(actualSecondProductQuantity, expectedSecondProductQuantity);
    }

}
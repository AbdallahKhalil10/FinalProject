import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class searchProductFeature {
    WebDriver driver;

    //CONSTRUCTOR
    public searchProductFeature(WebDriver driver){
        this.driver =  driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By productsTabButton = By.xpath("//a[@href=\"/products\"]");
    private By productsPageHeader = By.xpath("//h2[@class=\"title text-center\"]");
    private By searchProductTextField = By.xpath("//input[@id=\"search_product\"]");
    private By searchProductButton = By.xpath("//button[@id=\"submit_search\"]");
    //private By searchedProductPageHeader = By.xpath("//h2[@class=\"title text-center\"]");
    private By addToCartButton = By.xpath("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"1\"]");
    private By popupWindow = By.xpath("//div[@class=\"modal-content\"]");
    private By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By cartTabButton = By.xpath("//ul//a[@href=\"/view_cart\"]");
    private By loginTabButton = By.xpath("//a[@href=\"/login\"]");
    private By emailTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By passwordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By cartPageHeader = By.xpath("//a[@href=\"/product_details/1\"]");


    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }
    public void clickProductsTabButton(){
        driver.findElement(productsTabButton).click();
    }
    public void fillProductNameInSearchBar(String productName){driver.findElement(searchProductTextField).sendKeys(productName);}
    public void clickSearchButton(){
        driver.findElement(searchProductButton).click();
    }
    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }
    public void clickContinueShoppingButton(){driver.findElement(continueShoppingButton).click();}
    public void clickCartTabButton(){
        driver.findElement(cartTabButton).click();
    }
    public void clickLoginTabButton(){
        driver.findElement(loginTabButton).click();
    }
    public void fillEmailTextField(String email){driver.findElement(emailTextField).sendKeys(email);}
    public void fillPasswordTextField(String password){
        driver.findElement(passwordTextField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }




    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnProductPageHeader(String expectedProductPageHeader){
        String actualProductPageHeader = driver.findElement(productsPageHeader).getText();
        Assert.assertEquals(actualProductPageHeader, expectedProductPageHeader);
    }

    public void assertOnSearchedProductPageHeader(){
        List<WebElement> searchedProductObj = driver.findElements(By.tagName("img"));
        for(WebElement currentObj : searchedProductObj){
            Assert.assertTrue(currentObj.isDisplayed());
           }
    }


    public void assertOnCartPageHeader(String expectedCartPageHeader){
        String actualCartPageHeader = driver.findElement(cartPageHeader).getText();
        Assert.assertEquals(actualCartPageHeader, expectedCartPageHeader);
    }

    public void assertOnPopupWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupWindow));
        Assert.assertTrue(popup.isDisplayed());
    }
}

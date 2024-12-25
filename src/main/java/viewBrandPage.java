import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class viewBrandPage {
    WebDriver driver;

    //CONSTRUCTOR
    public viewBrandPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By productsTabButton = By.xpath("//a[@href=\"/products\"]");
    private By brandsBar = By.xpath("//div[@class=\"brands-name\"]");
    private By brandPOLO = By.xpath("//a[@href=\"/brand_products/Polo\"]");
    private By POLOHeader = By.xpath("//h2[@class=\"title text-center\"]");
    private By brandHM = By.xpath("//a[@href=\"/brand_products/H&M\"]");
    private By HMHeader = By.xpath("//h2[@class=\"title text-center\"]");


    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickProductsTabButton(){
        driver.findElement(productsTabButton).click();
    }

    public void clickPOLOBrandButton(){
        driver.findElement(brandPOLO).click();
    }

    public void clickHMBrandButton(){
        driver.findElement(brandHM).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnBrandsHeader(){
//        List<WebElement> brandsObj = driver.findElements(By.tagName("img"));
//        for(WebElement currentObj : brandsObj){
//            String actualBrandHeader = currentObj.getText();
//            Assert.assertEquals(actualBrandHeader, expectedBrandHeader);
//        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brandsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(brandsBar));
        Assert.assertTrue(brandsBox.isDisplayed());
    }

    public void assertOnPOLOHeader(String expectedPOLOHeader){
        String actualPOLOHeader = driver.findElement(POLOHeader).getText();
        Assert.assertEquals(actualPOLOHeader, expectedPOLOHeader);
    }

    public void assertOnHMHeader(String expectedHMHeader){
        String actualHMHeader = driver.findElement(HMHeader).getText();
        Assert.assertEquals(actualHMHeader, expectedHMHeader);
    }
}

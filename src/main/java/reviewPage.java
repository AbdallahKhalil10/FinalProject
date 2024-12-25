import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class reviewPage {
    WebDriver driver;

    //CONSTRUCTOR
    public reviewPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By productsTabButton = By.xpath("//a[@href=\"/products\"]");
    private By viewProductButton = By.xpath("//a[@href=\"/product_details/1\"]");
    private By reviewerNameTextField = By.xpath("//input[@id=\"name\"]");
    private By reviewerEmailTextField = By.xpath("//input[@id=\"email\"]");
    private By reviewTextField = By.xpath("//textarea[@id=\"review\"]");
    private By submitReviewButton = By.xpath("//button[@id=\"button-review\"]");
    private By reviewSuccessMessage = By.xpath("//span[@style=\"font-size: 20px;\"]");




    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickProductsTabButton(){
        driver.findElement(productsTabButton).click();
    }

    public void clickViewProductButton(){
        driver.findElement(viewProductButton).click();
    }

    public void fillReviewerName(String reviewerName){
        driver.findElement(reviewerNameTextField).sendKeys(reviewerName);
    }

    public void fillReviewerEmail(String reviewerEmail){
        driver.findElement(reviewerEmailTextField).sendKeys(reviewerEmail);
    }

    public void fillTheReview(String review){
        driver.findElement(reviewTextField).sendKeys(review);
    }

    public void clickSubmitReviewButton(){
        driver.findElement(submitReviewButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnReviewSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewSuccessMessage));
        Assert.assertTrue(message.isDisplayed());
    }

}

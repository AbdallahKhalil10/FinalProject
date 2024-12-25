import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class scrollHomePage {
    WebDriver driver;

    //CONSTRUCTOR
    public scrollHomePage(WebDriver driver){
        this.driver = driver;
    }

    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By subscriptionHeader = By.xpath("//div[@class=\"single-widget\"]//h2");
    private By scrollUpArrowButton = By.xpath("//a[@id=\"scrollUp\"]");
    private By scrollUpHeader = By.xpath("//div[@class=\"col-sm-6\"]//h2");

    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void moveScrollDownBar(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,8500)");
    }

    public void moveScrollUpBar(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,0)");
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void clickScrollUpArrowButton(){
        driver.findElement(scrollUpArrowButton).click();
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

    public void assertOnScrollUpHeader(String expectedScrollUpHeader){
        String actualScrollUpHeader = driver.findElement(scrollUpHeader).getText();
        Assert.assertEquals(actualScrollUpHeader, expectedScrollUpHeader);
    }
}

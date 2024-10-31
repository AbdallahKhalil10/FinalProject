import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class testCasesPage {
    WebDriver driver;


    //CONSTRUCTOR
    public testCasesPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By testCasesTabButton = By.xpath("//a[@href=\"/test_cases\"]");
    private By testCasesPageHeader = By.xpath("//div[@class=\"col-sm-9 col-sm-offset-1\"]//h2//b");



    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickTestCasesTabButton(){
        driver.findElement(testCasesTabButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader,expectedHomePageHeader);
    }

    public void assertOnTestCasesPageHeader(String expectedTestCasesPageHeader){
        String actualTestCasesPageHeader = driver.findElement(testCasesPageHeader).getText();
        Assert.assertEquals(actualTestCasesPageHeader,expectedTestCasesPageHeader);
    }
}

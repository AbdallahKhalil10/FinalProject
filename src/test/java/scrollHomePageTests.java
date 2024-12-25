import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scrollHomePageTests {
    WebDriver driver;
    scrollHomePage scrollHomePageObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedSubscriptionHeader = "SUBSCRIPTION";
    String expectedScrollUpHeader = "Full-Fledged practice website for Automation Engineers";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        scrollHomePageObject = new scrollHomePage(driver);
        scrollHomePageObject.navigateToURL(URL);
        scrollHomePageObject.assertOnHomePageHeader(expectedHomePageHeader);
    }

    @Test
    public void scrollHomePageTC01() throws InterruptedException {
        scrollHomePageObject.moveScrollDownBar();
        scrollHomePageObject.assertOnSubscriptionHeader(expectedSubscriptionHeader);
        scrollHomePageObject.sleep();
        scrollHomePageObject.clickScrollUpArrowButton();
        scrollHomePageObject.sleep();
        scrollHomePageObject.assertOnScrollUpHeader(expectedScrollUpHeader);
    }

    @Test
    public void scrollHomePageTC02() throws InterruptedException {
        scrollHomePageObject.moveScrollDownBar();
        scrollHomePageObject.assertOnSubscriptionHeader(expectedSubscriptionHeader);
        scrollHomePageObject.sleep();
        scrollHomePageObject.moveScrollUpBar();
        scrollHomePageObject.sleep();
        scrollHomePageObject.assertOnScrollUpHeader(expectedScrollUpHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

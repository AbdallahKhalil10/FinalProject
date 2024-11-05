import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class subscriptionTests {
    WebDriver driver;
    subscriptionPage subscriptionObject;

    String URL = "https://automationexercise.com/";
    String email = "khalilabdalla829@gmail.com";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedSubscriptionHeader = "SUBSCRIPTION";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        subscriptionObject = new subscriptionPage(driver);
        subscriptionObject.navigateToURL(URL);
    }

    @Test
    public void SubscriptionTC01(){
        subscriptionObject.assertOnHomePageHeader(expectedHomePageHeader);
        subscriptionObject.assertOnSubscriptionHeader(expectedSubscriptionHeader);
        subscriptionObject.fillSubscriptionEmailTextField(email);
        subscriptionObject.clickArrowButton();
        subscriptionObject.assertOnSubscriptionSuccessMessage();
    }

    @Test
    public void SubscriptionTC02(){
        subscriptionObject.clickCartTabButton();
        subscriptionObject.assertOnSubscriptionHeader(expectedSubscriptionHeader);
        subscriptionObject.fillSubscriptionEmailTextField(email);
        subscriptionObject.clickArrowButton();
        subscriptionObject.assertOnSubscriptionSuccessMessage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

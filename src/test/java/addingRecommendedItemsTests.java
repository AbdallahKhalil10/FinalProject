import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addingRecommendedItemsTests {
    WebDriver driver;
    addingRecommendedItemsFeature recommendedItemsObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedRecommendedItemsHeader = "RECOMMENDED ITEMS";
    String expectedCartPageHeader = "Proceed To Checkout";


    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        recommendedItemsObject = new addingRecommendedItemsFeature(driver);
        recommendedItemsObject.navigateToURL(URL);
    }

    @Test
    public void addingRecommendedItemsTC01(){
        recommendedItemsObject.assertOnHomePageHeader(expectedHomePageHeader);
        recommendedItemsObject.moveScrollDownBar();
        recommendedItemsObject.assertOnRecommendedItemsHeader(expectedRecommendedItemsHeader);
        recommendedItemsObject.clickAddToCartButton();
        recommendedItemsObject.assertOnPopupWindow();
        recommendedItemsObject.clickViewCartButton();
        recommendedItemsObject.assertOnCartPageHeader(expectedCartPageHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


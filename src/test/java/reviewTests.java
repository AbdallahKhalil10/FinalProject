import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class reviewTests {
    WebDriver driver;
    reviewPage reviewObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String review = "I’m impressed with its overall quality and comfort. The fabric feels soft against the skin, making it ideal for all-day wear. It's lightweight and breathable, perfect for casual outings or lounging at home.";
    String reviewerName = "Abdallah";
    String reviewerEmail = "khalil@gmail.com";


    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        reviewObject = new reviewPage(driver);
        reviewObject.navigateToURL(URL);
        reviewObject.assertOnHomePageHeader(expectedHomePageHeader);
    }

    @Test
    public void reviewTC01(){
        reviewObject.clickProductsTabButton();
        reviewObject.clickViewProductButton();
        reviewObject.fillReviewerName(reviewerName);
        reviewObject.fillReviewerEmail(reviewerEmail);
        reviewObject.fillTheReview(review);
        reviewObject.clickSubmitReviewButton();
        reviewObject.assertOnReviewSuccessMessage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}



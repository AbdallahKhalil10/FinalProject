import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTests {
    WebDriver driver;
    contactUsPage contactUsObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedContactUsPageHeader = "GET IN TOUCH";
    String name = "abdallah";
    String email = "Khalilabdalla880@gmail.com";
    String subject = "Feedback about the last shipped product";
    String message = "I am really satisfied about the quality of the product, Very satisfying";
    String expectedContactUsSubmissionMessage = "Success! Your details have been submitted successfully.";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        contactUsObject = new contactUsPage(driver);
        contactUsObject.navigateToURL(URL);
        contactUsObject.assertOnHomePageHeader(expectedHomePageHeader);
        contactUsObject.clickContactUsTabButton();
    }

    @Test
    public void contactUsTC01(){
        contactUsObject.assertOnContactUsPageHeader(expectedContactUsPageHeader);
        contactUsObject.fillNameTextField(name);
        contactUsObject.fillEmailTextField(email);
        contactUsObject.fillSubjectTextField(subject);
        contactUsObject.fillMessageTextField(message);
        contactUsObject.clickUploadFileButton();
        contactUsObject.clickSubmitButton();
        contactUsObject.assertOnAlertPopup();
        contactUsObject.clickOkButtonInAlertBox();
        contactUsObject.assertOnContactUsSubmissionMessage(expectedContactUsSubmissionMessage);
        contactUsObject.clickHomeButton();
        contactUsObject.assertOnHomePageHeader(expectedHomePageHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

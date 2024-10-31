import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class logoutTests {
    WebDriver driver;
    logoutPage logoutObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedLoginPageHeader = "Login to your account";
    String email = "khalilabdalla86@gmail.com";
    String password = "abdallah";
    String expectedLoggedInHeader = "Logged in as abdallah";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        logoutObject = new logoutPage(driver);
        logoutObject.navigateToURL(URL);
        logoutObject.assertOnHomePageHeader(expectedHomePageHeader);
        logoutObject.clickLoginTabButton();
    }

    @Test
    public void logoutTC01(){
        logoutObject.assertOnLoginPageHeader(expectedLoginPageHeader);
        logoutObject.fillEmailTextField(email);
        logoutObject.fillPasswordTextField(password);
        logoutObject.clickLoginButton();
        logoutObject.assertOnLoggedInHeader(expectedLoggedInHeader);
        logoutObject.clickLogoutTabButton();
        logoutObject.assertOnLoginPageHeader(expectedLoginPageHeader);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

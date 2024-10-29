import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class signInTests {
    WebDriver driver;
    signInPage signinPageObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "CATEGORY";
    String expectedLoginPageHeader = "Login to your account";
    String validEmail = "khalilabdalla829@gmail.com";
    String validPassword = "abc1013";
    String invalidEmail = "seifahmed@gmail.com";
    String invalidPassword = "abcd123456";
    String expectedAccountDeleteHeader = "ACCOUNT DELETED!";
    String expectedLoginSuccessMessage = "Logged in as";
    String expectedLoginErrorMessage = "Your email or password is incorrect!";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        signinPageObject = new signInPage(driver);
        signinPageObject.navigateToURL(URL);
        signinPageObject.assertOnHomePageHeader(expectedHomePageHeader);
        signinPageObject.clickLoginTabButton();
    }

    @Test
    public void loginTC01(){
        signinPageObject.assertOnLoginPageHeader(expectedLoginPageHeader);
        signinPageObject.fillAllData(validEmail, validPassword);
        signinPageObject.clickLoginButton();
        signinPageObject.assertOnLoginSuccessMessage(expectedLoginSuccessMessage);
        signinPageObject.clickDeleteAccountTabButton();
        signinPageObject.assertOnAccountDeletePageHeader(expectedAccountDeleteHeader);
    }

    @Test
    public void loginTC02(){
        signinPageObject.assertOnLoginPageHeader(expectedLoginPageHeader);
        signinPageObject.fillAllData(invalidEmail, invalidPassword);
        signinPageObject.clickLoginButton();
        signinPageObject.assertOnLoginErrorMessage(expectedLoginErrorMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

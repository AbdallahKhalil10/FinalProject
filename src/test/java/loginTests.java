import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTests {
    WebDriver driver;
    loginPage LoginObject;


    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedLoginPageHeader = "Login to your account";
    String validEmail = "khalilabdalla86@gmail.com";
    String validPassword = "abdallah";
    String invalidEmail = "seifahmed@gmail.com";
    String invalidPassword = "abcd123456";
    String expectedAccountDeleteHeader = "ACCOUNT DELETED!";
//    String expectedLoginSuccessMessage = "Logged in as";
    String expectedLoginErrorMessage = "Your email or password is incorrect!";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        LoginObject = new loginPage(driver);
        LoginObject.navigateToURL(URL);
        LoginObject.assertOnHomePageHeader(expectedHomePageHeader);
        LoginObject.clickLoginTabButton();
    }

    @Test
    public void loginTC01(){
        LoginObject.assertOnLoginPageHeader(expectedLoginPageHeader);
        LoginObject.fillAllData(validEmail, validPassword);
        LoginObject.clickLoginButton();
        //LoginObject.assertOnLoginSuccessMessage(expectedLoginSuccessMessage);
        LoginObject.clickDeleteAccountTabButton();
        LoginObject.assertOnAccountDeletePageHeader(expectedAccountDeleteHeader);
    }

    @Test
    public void loginTC02(){
        LoginObject.assertOnLoginPageHeader(expectedLoginPageHeader);
        LoginObject.fillAllData(invalidEmail, invalidPassword);
        LoginObject.clickLoginButton();
        LoginObject.assertOnLoginErrorMessage(expectedLoginErrorMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

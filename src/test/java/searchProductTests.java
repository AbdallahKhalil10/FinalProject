import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class searchProductTests {
    WebDriver driver;
    searchProductFeature searchProductObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedProductPageHeader = "ALL PRODUCTS";
    String expectedCartPageHeader = "Blue Top";
    String productName = "Blue";
    String loggedinEmail = "khalil@gmail.com";
    String loggedinPassword = "abdallah";



    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        searchProductObject = new searchProductFeature(driver);
        searchProductObject.navigateToURL(URL);
        searchProductObject.assertOnHomePageHeader(expectedHomePageHeader);
    }

    @Test
    public void searchProductTC01(){
        searchProductObject.clickProductsTabButton();
        searchProductObject.assertOnProductPageHeader(expectedProductPageHeader);
        searchProductObject.fillProductNameInSearchBar(productName);
        searchProductObject.clickSearchButton();
        searchProductObject.assertOnSearchedProductPageHeader();
        searchProductObject.clickAddToCartButton();
        searchProductObject.assertOnPopupWindow();
        searchProductObject.clickContinueShoppingButton();
        searchProductObject.clickCartTabButton();
        searchProductObject.assertOnCartPageHeader(expectedCartPageHeader);
        searchProductObject.clickLoginTabButton();
        searchProductObject.fillEmailTextField(loggedinEmail);
        searchProductObject.fillPasswordTextField(loggedinPassword);
        searchProductObject.clickLoginButton();
        searchProductObject.clickCartTabButton();
        searchProductObject.assertOnCartPageHeader(expectedCartPageHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

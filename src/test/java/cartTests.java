import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cartTests {
    WebDriver driver;
    cartPage cartObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedCartPageHeader = "Proceed To Checkout";
    String expectedRemoveProductHeader = "Cart is empty! Click here to buy products.";
    String expectedFirstProductPrice = "Rs. 500";
    String expectedSecondProductPrice = "Rs. 400";
    String expectedFirstProductQuantity = "1";
    String expectedSecondProductQuantity = "1";
    String expectedProductQuantity = "4";



    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        cartObject = new cartPage(driver);
        cartObject.navigateToURL(URL);
    }

    @Test
    public void cartTC01(){
        cartObject.assertOnHomePageHeader(expectedHomePageHeader);
        cartObject.clickProductsTabButton();
        cartObject.hoverOverFirstProduct();
        cartObject.assertOnHoveringFirstProduct();
        cartObject.clickAddToCartButtonForFirstProduct();
        cartObject.assertOnPopupWindow();
        cartObject.clickContinueShoppingButton();
        cartObject.hoverOverSecondProduct();
        cartObject.assertOnHoveringSecondProduct();
        cartObject.clickAddToCartButtonForSecondProduct();
        cartObject.assertOnPopupWindow();
        cartObject.clickViewCartButton();
        cartObject.assertOnFirstProductPrice(expectedFirstProductPrice);
        cartObject.assertOnFirstProductQuantity(expectedFirstProductQuantity);
        cartObject.assertOnSecondProductPrice(expectedSecondProductPrice);
        cartObject.assertOnSecondProductQuantity(expectedSecondProductQuantity);
    }

    @Test
    public void cartTC02(){
        cartObject.assertOnHomePageHeader(expectedHomePageHeader);
        cartObject.clickProductsTabButton();
        cartObject.clickViewProductButton();
        cartObject.clickIncreaseQuantityButton(expectedProductQuantity);
        cartObject.clickAddToCartButton();
        cartObject.assertOnPopupWindow();
        cartObject.clickViewCartButton();
        cartObject.assertOnProductQuantityAfterTheIncrease(expectedProductQuantity);
    }

    @Test
    public void cartTC03(){
        cartObject.assertOnHomePageHeader(expectedHomePageHeader);
        cartObject.clickProductsTabButton();
        cartObject.hoverOverFirstProduct();
        cartObject.assertOnHoveringFirstProduct();
        cartObject.clickAddToCartButtonForFirstProduct();
        cartObject.assertOnPopupWindow();
        cartObject.clickContinueShoppingButton();
        cartObject.clickCartTabButton();
        cartObject.assertOnCartPageHeader(expectedCartPageHeader);
        cartObject.clickRemoveButton();
        cartObject.assertOnRemoveProductSuccessfully(expectedRemoveProductHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

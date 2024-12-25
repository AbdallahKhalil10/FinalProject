import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class viewBrandTests {
    WebDriver driver;
    viewBrandPage viewBrandObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedPOLOHeader = "BRAND - POLO PRODUCTS";
    String expectedHMHeader = "BRAND - H&M PRODUCTS";


    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        viewBrandObject = new viewBrandPage(driver);
        viewBrandObject.navigateToURL(URL);
        viewBrandObject.assertOnHomePageHeader(expectedHomePageHeader);
    }

    @Test
    public void viewBrandTC01(){
        viewBrandObject.clickProductsTabButton();
        viewBrandObject.assertOnBrandsHeader();
        viewBrandObject.clickPOLOBrandButton();
        viewBrandObject.assertOnPOLOHeader(expectedPOLOHeader);
        viewBrandObject.clickHMBrandButton();
        viewBrandObject.assertOnHMHeader(expectedHMHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

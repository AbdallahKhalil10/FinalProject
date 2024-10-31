import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCasesTests {
    WebDriver driver;
    testCasesPage testCasesObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedTestCasesPageHeader = " TEST CASES";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        testCasesObject = new testCasesPage(driver);
        testCasesObject.navigateToURL(URL);
    }

    @Test
    public void testCasesPageTC01(){
        testCasesObject.assertOnHomePageHeader(expectedHomePageHeader);
        testCasesObject.clickTestCasesTabButton();
        testCasesObject.assertOnTestCasesPageHeader(expectedTestCasesPageHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

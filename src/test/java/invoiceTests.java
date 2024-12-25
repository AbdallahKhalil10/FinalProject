import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class invoiceTests {
    WebDriver driver;
    invoicePage invoiceObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedCartPageHeader = "Proceed To Checkout";
    String registeredEmail = "Yasser@gmail.com";
    String password = "abc1010";
    String name = "abdallah";
    String expectedSignupPageHeader = "ENTER ACCOUNT INFORMATION";
    String dayOfBirth = "20";
    String monthOfBirth = "September";
    String yearOfBirth = "1990";
    String firstName = "Seif";
    String lastName = "Ahmed";
    String company = "Siemens";
    String address = "Maadi";
    String state = "Cairo";
    String city = "Cairo";
    String zipcode = "11154";
    String mobile = "0118765432";
    String expectedAccountCreationHeader = "ACCOUNT CREATED!";
    String comment = "I want the order today as soon as possible";
    String nameOnCard = "Abdallah";
    String cardNumber = "1234 5678 4321 0987";
    String CVC = "311";
    String expirationMonth = "July";
    String expirationYear = "2028";
    String expectedOrderPlacedSuccessMessage = "Your order has been placed successfully!";
    String expectedAccountDeleteHeader = "ACCOUNT DELETED!";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        invoiceObject = new invoicePage(driver);
        invoiceObject.navigateToURL(URL);
        invoiceObject.assertOnHomePageHeader(expectedHomePageHeader);
    }

    @Test
    public void invoiceTC01() throws InterruptedException {
        invoiceObject.clickProductsTabButton();
        invoiceObject.hoverOverProduct();
        invoiceObject.assertOnHoveringTheProduct();
        invoiceObject.clickAddToCartButton();
        invoiceObject.assertOnPopupWindow();
        invoiceObject.clickContinueShoppingButton();
        invoiceObject.clickCartTabButton();
        invoiceObject.assertOnCartPageHeader(expectedCartPageHeader);
        invoiceObject.clickProceedToCheckoutButton();
        invoiceObject.clickRegisterLoginButton();
        invoiceObject.fillNameTextField(name);
        invoiceObject.fillEmailTextField(registeredEmail);
        invoiceObject.clickSignupButton();
        invoiceObject.assertOnSignupPageHeader(expectedSignupPageHeader);
        invoiceObject.selectTheTitle();
        invoiceObject.fillPasswordTextField(password);
        invoiceObject.selectDayOfBirth(dayOfBirth);
        invoiceObject.selectMonthOfBirth(monthOfBirth);
        invoiceObject.selectYearOfBirth(yearOfBirth);
        invoiceObject.clickNewsletterCheckBox();
        invoiceObject.clickSpecialOfferCheckBox();
        invoiceObject.fillFirstNameTextField(firstName);
        invoiceObject.fillLastNameTextField(lastName);
        invoiceObject.fillCompanyTextField(company);
        invoiceObject.fillAddressTextField(address);
        invoiceObject.selectTheCountry(2);
        invoiceObject.fillStateTextField(state);
        invoiceObject.fillCityTextField(city);
        invoiceObject.fillZipcodeTextField(zipcode);
        invoiceObject.fillMobileNumberTextField(mobile);
        invoiceObject.clickCreateAccountButton();
        invoiceObject.assertOnAccountCreationHeader(expectedAccountCreationHeader);
        invoiceObject.clickContinueButton();
        invoiceObject.clickCartTabButton();
        invoiceObject.clickProceedToCheckoutButton();
        invoiceObject.fillCommentTextArea(comment);
        invoiceObject.clickPlaceOrderButton();
        invoiceObject.fillNameOnCardTextField(nameOnCard);
        invoiceObject.fillCardNumberTextField(cardNumber);
        invoiceObject.fillCVCTextField(CVC);
        invoiceObject.fillExpirationMonthTextField(expirationMonth);
        invoiceObject.fillExpirationYearTextField(expirationYear);
        invoiceObject.clickPayAndConfirmButton();
        //invoiceObject.assertOnOrderPlacedHeader(expectedOrderPlacedSuccessMessage);
        invoiceObject.clickDownloadInvoiceButton();
        //invoiceObject.assertOnAlertPopup();
        invoiceObject.clickDeleteAccountTabButton();
        invoiceObject.assertOnAccountDeleteHeader(expectedAccountDeleteHeader);
        invoiceObject.clickContinueButton();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


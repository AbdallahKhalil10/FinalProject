import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkoutTests {
    WebDriver driver;
    checkoutPage checkoutObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedCartPageHeader = "Proceed To Checkout";
    String registeredEmail = "Yasser@gmail.com";
    String password = "abc1010";
    String name = "abdallah";
    String loggedinEmail = "khalil@gmail.com";
    String loggedinPassword = "abdallah";
    String expectedSignupPageHeader = "ENTER ACCOUNT INFORMATION";
    String dayOfBirth = "20";
    String monthOfBirth = "September";
    String yearOfBirth = "1990";
    String firstName = "Seif";
    String lastName = "Ahmed";
    String company = "Siemens";
    String address = "Maadi";
    String secondAddress = "Zamalek";
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
        checkoutObject = new checkoutPage(driver);
        checkoutObject.navigateToURL(URL);
        checkoutObject.assertOnHomePageHeader(expectedHomePageHeader);
    }

    @Test
    public void checkoutTC01(){
        checkoutObject.clickProductsTabButton();
        checkoutObject.hoverOverProduct();
        checkoutObject.assertOnHoveringTheProduct();
        checkoutObject.clickAddToCartButton();
        checkoutObject.assertOnPopupWindow();
        checkoutObject.clickContinueShoppingButton();
        checkoutObject.clickCartTabButton();
        checkoutObject.assertOnCartPageHeader(expectedCartPageHeader);
        checkoutObject.clickProceedToCheckoutButton();
        checkoutObject.clickRegisterLoginButton();
        checkoutObject.fillNameTextField(name);
        checkoutObject.fillEmailTextField(registeredEmail);
        checkoutObject.clickSignupButton();
        checkoutObject.assertOnSignupPageHeader(expectedSignupPageHeader);
        checkoutObject.selectTheTitle();
        checkoutObject.fillPasswordTextField(password);
        checkoutObject.selectDayOfBirth(dayOfBirth);
        checkoutObject.selectMonthOfBirth(monthOfBirth);
        checkoutObject.selectYearOfBirth(yearOfBirth);
        checkoutObject.clickNewsletterCheckBox();
        checkoutObject.clickSpecialOfferCheckBox();
        checkoutObject.fillFirstNameTextField(firstName);
        checkoutObject.fillLastNameTextField(lastName);
        checkoutObject.fillCompanyTextField(company);
        checkoutObject.fillAddressTextField(address);
        checkoutObject.selectTheCountry(2);
        checkoutObject.fillStateTextField(state);
        checkoutObject.fillCityTextField(city);
        checkoutObject.fillZipcodeTextField(zipcode);
        checkoutObject.fillMobileNumberTextField(mobile);
        checkoutObject.clickCreateAccountButton();
        checkoutObject.assertOnAccountCreationHeader(expectedAccountCreationHeader);
        checkoutObject.clickContinueButton();
        checkoutObject.clickCartTabButton();
        checkoutObject.clickProceedToCheckoutButton();
        checkoutObject.fillCommentTextArea(comment);
        checkoutObject.clickPlaceOrderButton();
        checkoutObject.fillNameOnCardTextField(nameOnCard);
        checkoutObject.fillCardNumberTextField(cardNumber);
        checkoutObject.fillCVCTextField(CVC);
        checkoutObject.fillExpirationMonthTextField(expirationMonth);
        checkoutObject.fillExpirationYearTextField(expirationYear);
        checkoutObject.clickPayAndConfirmButton();
        //checkoutObject.assertOnOrderPlacedHeader(expectedOrderPlacedSuccessMessage);
        checkoutObject.clickDeleteAccountTabButton();
        checkoutObject.assertOnAccountDeleteHeader(expectedAccountDeleteHeader);
        checkoutObject.clickContinueButton();
    }

    @Test
    public void checkoutTC02(){
        checkoutObject.clickSignupTabButton();
        checkoutObject.fillNameTextField(name);
        checkoutObject.fillEmailTextField(registeredEmail);
        checkoutObject.clickSignupButton();
        checkoutObject.assertOnSignupPageHeader(expectedSignupPageHeader);
        checkoutObject.selectTheTitle();
        checkoutObject.fillPasswordTextField(password);
        checkoutObject.selectDayOfBirth(dayOfBirth);
        checkoutObject.selectMonthOfBirth(monthOfBirth);
        checkoutObject.selectYearOfBirth(yearOfBirth);
        checkoutObject.clickNewsletterCheckBox();
        checkoutObject.clickSpecialOfferCheckBox();
        checkoutObject.fillFirstNameTextField(firstName);
        checkoutObject.fillLastNameTextField(lastName);
        checkoutObject.fillCompanyTextField(company);
        checkoutObject.fillAddressTextField(address);
        checkoutObject.selectTheCountry(2);
        checkoutObject.fillStateTextField(state);
        checkoutObject.fillCityTextField(city);
        checkoutObject.fillZipcodeTextField(zipcode);
        checkoutObject.fillMobileNumberTextField(mobile);
        checkoutObject.clickCreateAccountButton();
        checkoutObject.assertOnAccountCreationHeader(expectedAccountCreationHeader);
        checkoutObject.clickContinueButton();
        checkoutObject.clickProductsTabButton();
        checkoutObject.hoverOverProduct();
        checkoutObject.assertOnHoveringTheProduct();
        checkoutObject.clickAddToCartButton();
        checkoutObject.assertOnPopupWindow();
        checkoutObject.clickContinueShoppingButton();
        checkoutObject.clickCartTabButton();
        checkoutObject.assertOnCartPageHeader(expectedCartPageHeader);
        checkoutObject.clickProceedToCheckoutButton();
        checkoutObject.fillCommentTextArea(comment);
        checkoutObject.clickPlaceOrderButton();
        checkoutObject.fillNameOnCardTextField(nameOnCard);
        checkoutObject.fillCardNumberTextField(cardNumber);
        checkoutObject.fillCVCTextField(CVC);
        checkoutObject.fillExpirationMonthTextField(expirationMonth);
        checkoutObject.fillExpirationYearTextField(expirationYear);
        checkoutObject.clickPayAndConfirmButton();
        //checkoutObject.assertOnOrderPlacedHeader(expectedOrderPlacedSuccessMessage);
        checkoutObject.clickDeleteAccountTabButton();
        checkoutObject.assertOnAccountDeleteHeader(expectedAccountDeleteHeader);
        checkoutObject.clickContinueButton();
    }

    @Test
    public void checkoutTC03(){
        checkoutObject.clickSignupTabButton();
        checkoutObject.fillLoginData(loggedinEmail,loggedinPassword);
        checkoutObject.clickLoginButton();
        checkoutObject.clickProductsTabButton();
        checkoutObject.hoverOverProduct();
        checkoutObject.assertOnHoveringTheProduct();
        checkoutObject.clickAddToCartButton();
        checkoutObject.assertOnPopupWindow();
        checkoutObject.clickContinueShoppingButton();
        checkoutObject.clickCartTabButton();
        checkoutObject.assertOnCartPageHeader(expectedCartPageHeader);
        checkoutObject.clickProceedToCheckoutButton();
        checkoutObject.fillCommentTextArea(comment);
        checkoutObject.clickPlaceOrderButton();
        checkoutObject.fillNameOnCardTextField(nameOnCard);
        checkoutObject.fillCardNumberTextField(cardNumber);
        checkoutObject.fillCVCTextField(CVC);
        checkoutObject.fillExpirationMonthTextField(expirationMonth);
        checkoutObject.fillExpirationYearTextField(expirationYear);
        checkoutObject.clickPayAndConfirmButton();
        //checkoutObject.assertOnOrderPlacedHeader(expectedOrderPlacedSuccessMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

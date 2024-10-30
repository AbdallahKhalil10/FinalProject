import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class registrationTests {
    WebDriver driver;
    registrationPage registrationObject;

    String URL = "https://automationexercise.com/";
    String expectedHomePageHeader = "FEATURES ITEMS";
    String expectedSignupPageHeader = "New User Signup!";
    String email = "khalilabdalla885@gmail.com";
    String name = "abdallah";
    String password = "abc1010";
    String expectedRegistrationPageHeader = "ENTER ACCOUNT INFORMATION";
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
    String expectedLoggedInHeader = "Logged in as abdallah";
    String expectedAccountDeleteHeader = "ACCOUNT DELETED!";


    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        registrationObject = new registrationPage(driver);
        registrationObject.navigateToURL(URL);
        registrationObject.assertOnHomePageHeader(expectedHomePageHeader);
        registrationObject.clickSignupTabButton();
    }

    @Test
    public void registrationTC01(){
        registrationObject.assertOnSignupPageHeader(expectedSignupPageHeader);
        registrationObject.fillAllData(email, name);
        registrationObject.clickSignupButton();
        registrationObject.assertOnRegistrationPageHeader(expectedRegistrationPageHeader);
        registrationObject.selectTheTitle();
        registrationObject.fillPasswordTextField(password);
        registrationObject.selectDayOfBirth(dayOfBirth);
        registrationObject.selectMonthOfBirth(monthOfBirth);
        registrationObject.selectYearOfBirth(yearOfBirth);
        registrationObject.clickNewsletterCheckBox();
        registrationObject.clickSpecialOfferCheckBox();
        registrationObject.fillFirstNameTextField(firstName);
        registrationObject.fillLastNameTextField(lastName);
        registrationObject.fillCompanyTextField(company);
        registrationObject.fillAddressTextField(address);
        registrationObject.fillSecondAddressTextField(secondAddress);
        registrationObject.selectTheCountry(2);
        registrationObject.fillStateTextField(state);
        registrationObject.fillCityTextField(city);
        registrationObject.fillZipcodeTextField(zipcode);
        registrationObject.fillMobileNumberTextField(mobile);
        registrationObject.clickCreateAccountButton();
        registrationObject.assertOnAccountCreationHeader(expectedAccountCreationHeader);
        registrationObject.clickContinueButton();
        registrationObject.assertOnLoggedInHeader(expectedLoggedInHeader);
        registrationObject.clickDeleteAccountTabButton();
        registrationObject.assertOnAccountDeleteHeader(expectedAccountDeleteHeader);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

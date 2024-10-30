import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class registrationPage {
    WebDriver driver;

    //CONSTRUCTOR
    public  registrationPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By signupTabButton = By.xpath("//a[@href=\"/login\"]");
    private By signupPageHeader = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By nameTextField = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By emailTextField = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signupButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By registerPageHeader = By.xpath("//b[text()='Enter Account Information']");
    private By maleGenderSelection = By.xpath("//input[@id=\"id_gender1\"]");
    private By femaleGenderSelection = By.xpath("//input[@id=\"id_gender2\"]");
    private By passwordTextField = By.xpath("//input[@id=\"password\"]");
    private By daysDropDownMenu = By.xpath("//select[@id=\"days\"]");
    private By monthsDropDownMenu = By.xpath("//select[@id=\"months\"]");
    private By yearsDropDownMenu = By.xpath("//select[@id=\"years\"]");
    private By newsletterCheckBox = By.xpath("//label[@for=\"newsletter\"]");
    private By specialOfferCheckBox = By.xpath("//label[@for=\"optin\"]");
    private By firstNameTextField = By.xpath("//input[@id=\"first_name\"]");
    private By lastNameTextField = By.xpath("//input[@id=\"last_name\"]");
    private By companyTextField = By.xpath("//input[@id=\"company\"]");
    private By addressTextField = By.xpath("//input[@id=\"address1\"]");
    private By secondAddressTextField = By.xpath("//input[@id=\"address2\"]");
    private By countryDropDownMenu = By.xpath("//select[@id=\"country\"]");
    private By stateTextField = By.xpath("//input[@id=\"state\"]");
    private By cityTextField = By.xpath("//input[@id=\"city\"]");
    private By zipcodeTextField = By.xpath("//input[@id=\"zipcode\"]");
    private By mobileNumberTextField = By.xpath("//input[@id=\"mobile_number\"]");
    private By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    private By createAccountHeader = By.xpath("//h2[@data-qa=\"account-created\"]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    private By deleteAccountTabButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By loggedInHeader = By.xpath("//a[text()=' Logged in as ']");
    private By accountDeletePageHeader = By.xpath("//h2[@data-qa=\"account-deleted\"]//b");


    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickSignupTabButton(){
        driver.findElement(signupTabButton).click();
    }

    public void fillNameTextField(String name){
        driver.findElement(nameTextField).sendKeys(name);
    }

    public void fillEmailTextField(String email){
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void fillAllData(String email, String name){
        fillNameTextField(name);
        fillEmailTextField(email);
    }

    public void clickSignupButton(){
        driver.findElement(signupButton).click();
    }

    public void selectTheTitle(){
        driver.findElement(maleGenderSelection).click();
    }

    public void fillPasswordTextField(String password){
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public void selectDayOfBirth(String dayOfBirth){
        WebElement dayOfBirthElement = driver.findElement(daysDropDownMenu);
        Select dropDown = new Select(dayOfBirthElement);
        dropDown.selectByVisibleText(dayOfBirth);
    }

    public void selectMonthOfBirth(String monthOfBirth){
        WebElement monthOfBirthElement = driver.findElement(monthsDropDownMenu);
        Select dropDown = new Select(monthOfBirthElement);
        dropDown.selectByVisibleText(monthOfBirth);
    }

    public void selectYearOfBirth(String yearOfBirth){
        WebElement yearOfBirthElement = driver.findElement(yearsDropDownMenu);
        Select dropDown = new Select(yearOfBirthElement);
        dropDown.selectByVisibleText(yearOfBirth);
    }

    public void clickNewsletterCheckBox(){
        driver.findElement(newsletterCheckBox).click();
    }

    public void clickSpecialOfferCheckBox(){
        driver.findElement(specialOfferCheckBox).click();
    }

    public void fillFirstNameTextField(String firstName){
        driver.findElement(firstNameTextField).sendKeys(firstName);
    }

    public void fillLastNameTextField(String lastName){
        driver.findElement(lastNameTextField).sendKeys(lastName);
    }

    public void fillCompanyTextField(String company){
        driver.findElement(companyTextField).sendKeys(company);
    }

    public void fillAddressTextField(String address){
        driver.findElement(addressTextField).sendKeys(address);
    }

    public void fillSecondAddressTextField(String address){
        driver.findElement(secondAddressTextField).sendKeys(address);
    }

    public void selectTheCountry(int countryIndexInTheDropDownMenu){
        WebElement countryElement = driver.findElement(countryDropDownMenu);
        Select dropDown = new Select(countryElement);
        dropDown.selectByIndex(countryIndexInTheDropDownMenu);
    }

    public void fillStateTextField(String state){
        driver.findElement(stateTextField).sendKeys(state);
    }

    public void fillCityTextField(String city){
        driver.findElement(cityTextField).sendKeys(city);
    }

    public void fillZipcodeTextField(String zipcode){
        driver.findElement(zipcodeTextField).sendKeys(zipcode);
    }

    public void fillMobileNumberTextField(String mobile){
        driver.findElement(mobileNumberTextField).sendKeys(mobile);
    }

    public void clickCreateAccountButton(){
        driver.findElement(createAccountButton).click();
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void clickDeleteAccountTabButton(){
        driver.findElement(deleteAccountTabButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnSignupPageHeader(String expectedSignupPageHeader){
        String actualSignupPageHeader = driver.findElement(signupPageHeader).getText();
        Assert.assertEquals(actualSignupPageHeader, expectedSignupPageHeader);
    }

    public void assertOnRegistrationPageHeader(String expectedRegisterPageHeader){
        String actualRegisterPageHeader = driver.findElement(registerPageHeader).getText();
        Assert.assertEquals(actualRegisterPageHeader, expectedRegisterPageHeader);
    }

    public void assertOnAccountCreationHeader(String expectedAccountCreationHeader){
        String actualAccountCreationHeader = driver.findElement(createAccountHeader).getText();
        Assert.assertEquals(actualAccountCreationHeader, expectedAccountCreationHeader);
    }

    public void assertOnLoggedInHeader(String expectedLoggedInHeader){
        String actualLoggedInHeader = driver.findElement(loggedInHeader).getText();
        Assert.assertEquals(actualLoggedInHeader, expectedLoggedInHeader);
    }

    public void assertOnAccountDeleteHeader(String expectedAccountDeleteHeader){
        String actualAccountDeleteHeader = driver.findElement(accountDeletePageHeader).getText();
        Assert.assertEquals(actualAccountDeleteHeader, expectedAccountDeleteHeader);
    }



}

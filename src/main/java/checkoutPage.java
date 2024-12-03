import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class checkoutPage {
    WebDriver driver;


    //CONSTRUCTOR
    public checkoutPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By signupTabButton = By.xpath("//a[@href=\"/login\"]");
    private By productsTabButton = By.xpath("//a[@href=\"/products\"]");
    private By HoverOverProduct = By.xpath("//img[@src=\"/get_product_picture/1\"]");
    private By addToCartButton = By.xpath("//div[@class=\"overlay-content\"]//a[@data-product-id=\"1\"]");
    private By ProductHovered = By.xpath("//img[@src=\"/get_product_picture/1\"]");
    private By popupWindow = By.xpath("//div[@class=\"modal-content\"]");
    private By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By cartTabButton = By.xpath("//ul//a[@href=\"/view_cart\"]");
    private By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By registerLoginButton = By.xpath("//p//a[@href=\"/login\"]");
    private By nameTextField = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By emailTextField = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signupButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By loggedinEmailTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By loginPasswordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By signupPageHeader = By.xpath("//b[text()='Enter Account Information']");
    private By maleGenderSelection = By.xpath("//input[@id=\"id_gender1\"]");
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
    private By createAccountHeader = By.xpath("//h2[@class=\"title text-center\"]//b");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    private By commentTextArea = By.xpath("//textarea[@class=\"form-control\"]");
    private By placeOrderButton = By.xpath("//a[@href=\"/payment\"]");
    private By nameOnCardTextField = By.xpath("//input[@data-qa=\"name-on-card\"]");
    private By cardNumberTextField = By.xpath("//input[@data-qa=\"card-number\"]");
    private By CVCTextField = By.xpath("//input[@data-qa=\"cvc\"]");
    private By expirationMonthTextField = By.xpath("//input[@data-qa=\"expiry-month\"]");
    private By expirationYearTextField = By.xpath("//input[@data-qa=\"expiry-year\"]");
    private By payAndConfirmButton = By.xpath("//button[@class=\"form-control btn btn-primary submit-button\"]");
    private By orderPlacedSuccessMessage = By.xpath("//div[@id=\"success_message\"]");
    private By deleteAccountTabButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By accountDeletePageHeader = By.xpath("//h2[@data-qa=\"account-deleted\"]//b");


    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickSignupTabButton(){
        driver.findElement(signupTabButton).click();
    }

    public void clickProductsTabButton(){
        driver.findElement(productsTabButton).click();
    }

    public void hoverOverProduct(){
        WebElement firstProductToHover = driver.findElement(HoverOverProduct);
        Actions action = new Actions(driver);
        action.moveToElement(firstProductToHover).perform();
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public void clickContinueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCartTabButton(){
        driver.findElement(cartTabButton).click();
    }

    public void clickProceedToCheckoutButton(){
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void clickRegisterLoginButton(){
        driver.findElement(registerLoginButton).click();
    }

    public void fillNameTextField(String name){
        driver.findElement(nameTextField).sendKeys(name);
    }

    public void fillEmailTextField(String email){
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void fillLoginData(String email, String password){
        driver.findElement(loggedinEmailTextField).sendKeys(email);
        driver.findElement(loginPasswordTextField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
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

    public void fillCommentTextArea(String comment){
        driver.findElement(commentTextArea).sendKeys(comment);
    }

    public void clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
    }

    public void fillNameOnCardTextField(String nameOnCard){
        driver.findElement(nameOnCardTextField).sendKeys(nameOnCard);
    }

    public void fillCardNumberTextField(String cardNumber){
        driver.findElement(cardNumberTextField).sendKeys(cardNumber);
    }

    public void fillCVCTextField(String CVC){
        driver.findElement(CVCTextField).sendKeys(CVC);
    }

    public void fillExpirationMonthTextField(String expirationMonth){
        driver.findElement(expirationMonthTextField).sendKeys(expirationMonth);
    }

    public void fillExpirationYearTextField(String expirationYear){
        driver.findElement(expirationYearTextField).sendKeys(expirationYear);
    }

    public void clickPayAndConfirmButton(){
        driver.findElement(payAndConfirmButton).click();
    }

    public void clickDeleteAccountTabButton(){
        driver.findElement(deleteAccountTabButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnHoveringTheProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductHovered));
        Assert.assertTrue(hover.isDisplayed());
    }

    public void assertOnPopupWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupWindow));
        Assert.assertTrue(popup.isDisplayed());
    }

    public void assertOnCartPageHeader(String expectedCartPageHeader){
        String actualHomePageHeader = driver.findElement(proceedToCheckoutButton).getText();
        Assert.assertEquals(actualHomePageHeader, expectedCartPageHeader);
    }

    public void assertOnSignupPageHeader(String expectedSignupPageHeader){
        String actualSignupPageHeader = driver.findElement(signupPageHeader).getText();
        Assert.assertEquals(actualSignupPageHeader, expectedSignupPageHeader);
    }

    public void assertOnAccountCreationHeader(String expectedAccountCreationHeader){
        String actualAccountCreationHeader = driver.findElement(createAccountHeader).getText();
        Assert.assertEquals(actualAccountCreationHeader, expectedAccountCreationHeader);
    }

    public void assertOnOrderPlacedHeader(String expectedOrderPlacedSuccessMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedSuccessMessage));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public void assertOnAccountDeleteHeader(String expectedAccountDeleteHeader){
        String actualAccountDeleteHeader = driver.findElement(accountDeletePageHeader).getText();
        Assert.assertEquals(actualAccountDeleteHeader, expectedAccountDeleteHeader);
    }

}

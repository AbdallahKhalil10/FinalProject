import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.sql.Driver;

public class signInPage {

    WebDriver driver;

    //CONSTRUCTOR
    public signInPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//div[@class=\"left-sidebar\"]//h2");
    private By loginTabButton = By.xpath("//a[@href=\"/login\"]");
    private By loginPageHeader = By.xpath("//div[@class=\"login-form\"]//h2");
    private By emailTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By passwordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By loginSuccessMessage = By.xpath("//*[text()='Logged in as']");
    private By loginErrorMessage = By.xpath("//p[@style=\"color: red;\"]");
    private By deleteAccountTabButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By accountDeletePageHeader = By.xpath("//h2[@data-qa=\"account-deleted\"]//b");


    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickLoginTabButton(){
        driver.findElement(loginTabButton).click();
    }

    public void fillEmailTextField(String email){
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void fillPasswordTextField(String password){
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public void fillAllData(String email, String password){
        fillEmailTextField(email);
        fillPasswordTextField(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickDeleteAccountTabButton(){
        driver.findElement(deleteAccountTabButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnLoginPageHeader(String expectedLoginPageHeader){
        String actualLoginPageHeader = driver.findElement(loginPageHeader).getText();
        Assert.assertEquals(actualLoginPageHeader, expectedLoginPageHeader);
    }

    public void assertOnLoginSuccessMessage(String expectedLoginSuccessMessage){
        String actualLoginSuccessMessage = driver.findElement(loginSuccessMessage).getText();
        Assert.assertEquals(actualLoginSuccessMessage, expectedLoginSuccessMessage);
    }

    public void assertOnLoginErrorMessage(String expectedLoginErrorMessage){
        String actualLoginErrorMessage = driver.findElement(loginErrorMessage).getText();
        Assert.assertEquals(actualLoginErrorMessage, expectedLoginErrorMessage);
    }

    public void assertOnAccountDeletePageHeader(String expectedAccountDeleteHeader){
        String actualAccountDeleteHeader = driver.findElement(accountDeletePageHeader).getText();
        Assert.assertEquals(actualAccountDeleteHeader, expectedAccountDeleteHeader);
    }




}

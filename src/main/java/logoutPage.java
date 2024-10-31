import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class logoutPage {
    WebDriver driver;


    //CONSTRUCTOR
    public logoutPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By loginTabButton = By.xpath("//a[@href=\"/login\"]");
    private By loginPageHeader = By.xpath("//div[@class=\"login-form\"]//h2");
    private By emailTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By passwordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By loggedInHeader = By.xpath("//a[text()=' Logged in as ']");
    private By logoutTabButton = By.xpath("//a[@href=\"/logout\"]");



    //ACTIONS
    public void navigateToURL (String URL){
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

    public void clickLogoutTabButton(){
        driver.findElement(logoutTabButton).click();
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

    public void assertOnLoggedInHeader(String expectedLoggedInHeader){
        String actualLoggedInHeader = driver.findElement(loggedInHeader).getText();
        Assert.assertEquals(actualLoggedInHeader, expectedLoggedInHeader);
    }
}

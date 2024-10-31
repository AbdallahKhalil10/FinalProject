import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class contactUsPage {
    WebDriver driver;


    //CONSTRUCTOR
    public contactUsPage(WebDriver driver){
        this.driver = driver;
    }


    //ELEMENT LOCATORS
    private By homePageHeader = By.xpath("//h2[text()='Features Items']");
    private By contactUsTabButton = By.xpath("//a[@href=\"/contact_us\"]");
    private By contactUsPageHeader = By.xpath("//h2[text()='Get In Touch']");
    private By nameTextField = By.xpath("//input[@data-qa=\"name\"]");
    private By emailTextField = By.xpath("//input[@data-qa=\"email\"]");
    private By subjectTextField = By.xpath("//input[@data-qa=\"subject\"]");
    private By messageTextField = By.xpath("//textarea[@data-qa=\"message\"]");
    private By uploadFileButton = By.xpath("//input[@name=\"upload_file\"]");
    private By submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");
    private By contactUsSubmissionMessage = By.xpath("//div[@class=\"status alert alert-success\"]");
    private By homeButton = By.xpath("//span[text()=' Home']");



    //ACTIONS
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickContactUsTabButton(){
        driver.findElement(contactUsTabButton).click();
    }

    public void fillNameTextField(String name){
        driver.findElement(nameTextField).sendKeys(name);
    }

    public void fillEmailTextField(String email){
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void fillSubjectTextField(String subject){
        driver.findElement(subjectTextField).sendKeys(subject);
    }

    public void fillMessageTextField(String message){
        driver.findElement(messageTextField).sendKeys(message);
    }

    public void clickUploadFileButton(){
        WebElement fileInput = driver.findElement(uploadFileButton);
        fileInput.sendKeys("C://Users//PC//Downloads//Abdallah_Hany_Khalil_Resume(1).docx");
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void clickOkButtonInAlertBox(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickHomeButton(){
        driver.findElement(homeButton).click();
    }


    //ASSERTIONS
    public void assertOnHomePageHeader(String expectedHomePageHeader){
        String actualHomePageHeader = driver.findElement(homePageHeader).getText();
        Assert.assertEquals(actualHomePageHeader, expectedHomePageHeader);
    }

    public void assertOnContactUsPageHeader(String expectedContactUsPageHeader){
        String actualContactUsPageHeader = driver.findElement(contactUsPageHeader).getText();
        Assert.assertEquals(actualContactUsPageHeader, expectedContactUsPageHeader);
    }

    public void assertOnAlertPopup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void assertOnContactUsSubmissionMessage(String expectedContactUsSubmissionMessage){
        String actualContactUsSubmissionMessage = driver.findElement(contactUsSubmissionMessage).getText();
        Assert.assertEquals(actualContactUsSubmissionMessage, expectedContactUsSubmissionMessage);
    }




}

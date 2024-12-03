package StepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class APIAccessRequestSteps {
    private WebDriver driver;

    @Given("I am on the api access request form page")
    public void i_am_on_the_api_access_request_form_page() {
        // Setup WebDriver
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//       driver.get("file:///<path_to>/contact-form/index.html");
        driver.get("file:///D:/Shared/MyTrainingRepos/cucumber-examples/API_Access_Request_Form/index.html");
    }

    @When("I fill in the api access request form with valid details")
    public void i_fill_in_the_api_access_request_form_with_valid_details() {
        WebElement textArea = driver.findElement(By.xpath("//span//textarea[contains(@name,'textarea')]"));
        textArea.sendKeys("Software Testing");

        WebElement fullNameInput = driver.findElement(By.xpath("//input[@placeholder='Full name']"));
        fullNameInput.sendKeys("Test User");

        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Company email address']"));
        emailInput.sendKeys("testuser01@yopmail.com");

        WebElement companyInput = driver.findElement(By.xpath("//input[@placeholder='Company name']"));
        companyInput.sendKeys("Testing");

        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Phone number']"));
        phoneInput.sendKeys("9568471235");
    }

    @When("I submit the api access request form")
    public void i_submit_the_api_access_request_form() {
        WebElement iAgreeCheckbox = driver.findElement(By.xpath("//p//span[contains(@class,'first last')]//input"));
        iAgreeCheckbox.click();
        WebElement submitButton = driver.findElement(By.xpath("//p//input[@type='submit']"));
        submitButton.click();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() throws InterruptedException {
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'response-output')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", successMessage);
        Thread.sleep(1000);
        assertTrue(successMessage.isDisplayed());

        // Close the browser
        driver.quit();
    }
    
}
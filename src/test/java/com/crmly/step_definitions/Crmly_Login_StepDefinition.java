package com.crmly.step_definitions;

import com.crmly.pages.CrmlyLoginPage;
import com.crmly.utilities.ConfigurationReader;
import com.crmly.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Crmly_Login_StepDefinition {

    CrmlyLoginPage crmlyLoginPage = new CrmlyLoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }
    @When("User enters username {string}")
    public void user_enters_username(String arg01) {
        crmlyLoginPage.usernameInput.sendKeys(arg01);
    }
    @When("User enters password {string}")
    public void user_enters_password(String arg02) {
        crmlyLoginPage.passwordInput.sendKeys(arg02);
    }
    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        crmlyLoginPage.loginButton.click();
    }
    @Then("The user should be logged in to the page and see the CRM24 title")
    public void the_user_should_be_logged_in_to_the_page_and_see_the_CRM24_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "<[CRM]>";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("The user should see the Wrong login password alert on the page")
    public void the_user_should_see_the_wrong_login_password_alert_on_the_page() {
        Assert.assertTrue(crmlyLoginPage.forgotPasswordLink.isDisplayed());
    }
    @Then("User should see Please fill out this field. message on username input")
    public void user_should_see_please_fill_out_this_field_message_on_username_input() {

        String actualMessage2 = crmlyLoginPage.passwordInput.getAttribute("validationMessage");
        String expectedMessage2 = "Please fill in this field.";
        Assert.assertEquals(expectedMessage2, actualMessage2);
    }

    @Then("User should see Please fill out this field. message on password input")
    public void user_should_see_please_fill_out_this_field_message_on_password_input() {
        String actualMessage = crmlyLoginPage.usernameInput.getAttribute("validationMessage");
        String expectedMessage = "Please fill in this field.";
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @When("User clicks forgot your password link")
    public void user_clicks_forgot_your_password_link() {
        crmlyLoginPage.forgotPasswordLink.click();
    }
    @Then("User should land forgot your password page and should see Forgot Your Password text")
    public void user_should_land_forgot_your_password_page_and_should_see_forgot_your_password_text() {
        String expectedResetPasswordTitle = "FORGOT YOUR PASSWORD?";
        String actualResetPasswordTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedResetPasswordTitle, actualResetPasswordTitle);
    }

}

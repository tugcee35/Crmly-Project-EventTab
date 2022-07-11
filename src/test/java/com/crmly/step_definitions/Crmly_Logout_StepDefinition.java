package com.crmly.step_definitions;

import com.crmly.pages.CrmlyLoginPage;
import com.crmly.pages.CrmlyLogoutPage;
import com.crmly.utilities.ConfigurationReader;
import com.crmly.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Crmly_Logout_StepDefinition {
    CrmlyLoginPage crmlyLoginPage = new CrmlyLoginPage();
    CrmlyLogoutPage crmlyLogoutPage = new CrmlyLogoutPage();

    @Given("User is on the homepage after login with valid credentials.")
    public void user_is_on_the_homepage_after_login_with_valid_credentials() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        crmlyLoginPage.usernameInput.sendKeys("helpdesk9@cybertekschool.com");
        crmlyLoginPage.passwordInput.sendKeys("UserUser"+ Keys.ENTER);
    }
    @When("the user clicks on the username in the upper right corner")
    public void the_user_clicks_on_the_username_in_the_upper_right_corner() {
        crmlyLogoutPage.userNameUpper.click();
    }
    @When("click on log out")
    public void click_on_log_out() {
        crmlyLogoutPage.LogOutLink.click();
    }
    @Then("User should log out and land on login page and should see title is Authorization | Login")
    public void user_should_log_out_and_land_on_login_page_and_should_see_title_is_authorization_login() {
        String expectedTitle = "Authorization | Login";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @When("User should log out and land on login page and should see title is Authorization | Login for startups")
    public void user_should_log_out_and_land_on_login_page_and_should_see_title_is_authorization_login_for_startups() {

    }
    @When("User clicks step back button")
    public void user_clicks_step_back_button() {
        Driver.getDriver().navigate().back();
    }
    @Then("The user cannot return to the homepage and should see Your CRM24 session expired. Please refresh the current web page. messageFeature:As a user, I should be able to log out.")
    public void the_user_cannot_return_to_the_homepage_and_should_see_your_crm24_session_expired_please_refresh_the_current_web_page_message_feature_as_a_user_ı_should_be_able_to_log_out() {
        String expectedMessage = "CRM";
        String actualMessage = crmlyLogoutPage.expiredAlert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


}

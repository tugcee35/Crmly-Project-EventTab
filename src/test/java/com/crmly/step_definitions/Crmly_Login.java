package com.crmly.step_definitions;

import com.crmly.pages.CrmlyLoginPage;
import com.crmly.pages.CrmlyLogoutPage;
import com.crmly.utilities.ConfigurationReader;
import com.crmly.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Crmly_Login {

    CrmlyLoginPage crmlyLoginPage = new CrmlyLoginPage();
    CrmlyLogoutPage crmlyLogoutPage = new CrmlyLogoutPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }

    @When("User enters username {string}")
    public void user_enters_username(String string) {

        crmlyLoginPage.usernameInput.clear();
        crmlyLoginPage.usernameInput.sendKeys(string);


    }

    @When("User enters password {string}")
    public void user_enters_password(String string) {

        crmlyLoginPage.passwordInput.clear();
        crmlyLoginPage.passwordInput.sendKeys(string);

    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(crmlyLoginPage.inputRememberMe);

        crmlyLoginPage.loginButton.click();

    }

    @Then("The user should be logged in to the page and see the CRM24 title")
    public void the_user_should_be_logged_in_to_the_page_and_see_the_crm24_title() {

        String expectedTitle = "(8) Portal";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

    }
    @Then("Log out from homepage")
    public void logOutFromHomepage() {

        crmlyLogoutPage.userNameUpper.click();
        crmlyLogoutPage.logOutLink.click();

    }
}
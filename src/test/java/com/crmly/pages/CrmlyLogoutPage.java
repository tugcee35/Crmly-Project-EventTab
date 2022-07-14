package com.crmly.pages;

import com.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmlyLogoutPage {

public CrmlyLogoutPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}

    @FindBy(id = "user-block")
    public WebElement userNameUpper;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOutLink;

    @FindBy(xpath = "//h4[@class='modal-title']")
    public WebElement expiredAlert;

}

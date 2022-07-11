package com.crmly.pages;

import com.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmlyLogoutPage {

public CrmlyLogoutPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}

    @FindBy(xpath = "//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[3]/span[2]")
    public WebElement userNameUpper;

    @FindBy(linkText = "Log out")
    public WebElement LogOutLink;

    @FindBy(xpath = "//h4[@class='modal-title']")
    public WebElement expiredAlert;
}

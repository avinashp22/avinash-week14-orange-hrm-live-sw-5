package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Jay Vaghani
 */
public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(linkText= "Log in") WebElement loginLink;
  //  By loginLink = By.linkText("Log in");


    @CacheLookup
    @FindBy (linkText = "Register") WebElement registerLink;
  //  By registerLink = By.linkText("Register");

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }

}

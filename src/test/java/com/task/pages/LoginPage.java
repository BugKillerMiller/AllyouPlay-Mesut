package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage {
    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;



    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(css="div[class$='alert-error']")
    public WebElement PopUp;



    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }
}

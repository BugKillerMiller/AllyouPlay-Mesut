package com.task.pages;

import com.task.utilities.BrowserUtils;
import com.task.utilities.ConfigurationReader;
import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage {
    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#Email")
    public WebElement Email;

    @FindBy(css = "#Password")
    public WebElement password;

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    public WebElement signIn;

    @FindBy(xpath = "//button[@id='eu-cookie-ok']")
    public WebElement popUp;

    @FindBy(xpath = "//a[contains(@class,'soundest-form-without-image-close')]")
    public WebElement offerPopUp;

    @FindBy(xpath = "//span[contains(normalize-space(),'Oh')]")
    public WebElement ohNo;

    @FindBy(xpath = "//li[contains(normalize-space(),'Watch')]")
    public WebElement wrongPass;

    @FindBy(xpath = "//li[contains(normalize-space(),'No customer')]")
    public WebElement wrongEmail;


    public void login(String userNameStr, String passwordStr) throws InterruptedException {


        BrowserUtils.waitFor(1);
        Email.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        signIn.click();

    }
}

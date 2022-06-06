package com.task.pages;

import com.task.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class HomePage {
    public HomePage() throws MalformedURLException {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//body/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[1]/a[1]")
    public WebElement myAccount;

    @FindBy(xpath = "//body/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[2]/a[1]")
    public WebElement singOut;

    @FindBy(xpath = "//div/span[contains(@class,'header-notification-cart')]")
    public WebElement basketInfo;

    public void WebElementsSeen (WebElement element){

        Assert.assertTrue(element.isDisplayed());
    }
}

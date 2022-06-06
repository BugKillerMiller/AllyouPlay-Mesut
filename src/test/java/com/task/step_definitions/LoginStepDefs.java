package com.task.step_definitions;

import com.task.pages.HomePage;
import com.task.pages.LoginPage;
import com.task.utilities.BrowserUtils;
import com.task.utilities.ConfigurationReader;
import com.task.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.sql.Connection;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage   = new HomePage();

    public LoginStepDefs() throws MalformedURLException {
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws MalformedURLException {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }


    @When("the user enter valid credentials")
    public void theUserEnterValidCredentials() throws MalformedURLException, InterruptedException {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");


        loginPage.login(username, password);


    }

    @And("user navigate to home page")
    public void userNavigateToHomePage() throws InterruptedException, MalformedURLException {

        BrowserUtils.waitForVisibility(loginPage.offerPopUp,20);
        loginPage.offerPopUp.click();

        String expectedTitle = "ALLYOUPLAY.COM - Official Game Store";
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }


    @And("user should see following options\\(My Account, Sign Out, Basket Info)")
    public void userShouldSeeFollowingOptionsMyAccountSignOutBasketInfo() {

        BrowserUtils.waitFor(1);

       homePage.WebElementsSeen(homePage.myAccount);
       homePage.WebElementsSeen(homePage.singOut);
       homePage.WebElementsSeen(homePage.basketInfo);
    }

    @Then("user should see how many products in the basket")
    public void userShouldSeeHowManyProductsInTheBasket() {

        System.out.println("How many products in your basket = " + homePage.basketInfo.getText());
    }

    @When("the user enter valid username invalid password")
    public void the_user_enter_valid_username_invalid_password()  {

        loginPage.Email.sendKeys(ConfigurationReader.get("username"));

        String invalidPass = "fjfjfjfj";
        loginPage.password.sendKeys(invalidPass);

        loginPage.signIn.click();
    }

    @Then("the user get the message")
    public void the_user_get_the_message() {

        BrowserUtils.waitFor(2);

        String expectedMessage1 = "Oh no! There is an error and you need to fix it before logging in.";
        String actualMessage1 = loginPage.ohNo.getText();

        Assert.assertEquals(expectedMessage1,actualMessage1);

        String expectedMessage2 = "Watch out, the account credentials you have written are not correct.";
        String actualMessage2 = loginPage.wrongPass.getText();

        Assert.assertEquals(expectedMessage2,actualMessage2);

    }
    @And("the user enter invalid username\\(with @abc.com) valid password")
    public void theUserEnterInvalidUsernameWithAbcComValidPassword() {

        String invalidEmail = "abcdefg@gmail.com";
        loginPage.Email.sendKeys(invalidEmail);

        loginPage.password.sendKeys(ConfigurationReader.get("password"));

        loginPage.signIn.click();
    }
    @Then("the user get the message2")
    public void the_user_get_the_message2() {

        BrowserUtils.waitFor(2);

        String expectedMessage1 = "Oh no! There is an error and you need to fix it before logging in.";
        String actualMessage1 = loginPage.ohNo.getText();

        Assert.assertEquals(expectedMessage1,actualMessage1);

        String expectedMessage2 = "No customer account found";
        String actualMessage2 = loginPage.wrongEmail.getText();

        Assert.assertEquals(expectedMessage2,actualMessage2);

    }
    @Then("the user enter invalid username invalid password")
    public void the_user_enter_invalid_username_invalid_password() {

        String invalidEmail = "abcdefg";
        loginPage.Email.sendKeys(invalidEmail);

        String invalidPass = "fjfjfjfj";
        loginPage.password.sendKeys(invalidPass);

        loginPage.signIn.click();
    }
    @Then("the user get the message3")
    public void the_user_get_the_message3() {

        BrowserUtils.waitFor(2);

        String expectedMessage = "It should be some alert message about wrong insert";
        String actualMessage = "No such element =)";

        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @And("click the cookie")
    public void clickTheCookie() throws MalformedURLException {

        BrowserUtils.waitForVisibility(loginPage.popUp,20);
        loginPage.popUp.click();

    }


}

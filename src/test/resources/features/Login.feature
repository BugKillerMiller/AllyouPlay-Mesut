@login
Feature: users should be able login

  Background:
    Given the user is on the login page
    And click the cookie


   Scenario: Login with valid credentials

    Given the user enter valid credentials
    When user navigate to home page
    And user should see following options(My Account, Sign Out, Basket Info)
    Then user should see how many products in the basket


   Scenario: Login with invalid credentials

    When the user enter valid username invalid password
    Then the user get the message
    And the user enter invalid username(with @abc.com) valid password
    Then the user get the message2
    And the user enter invalid username invalid password
    Then the user get the message3






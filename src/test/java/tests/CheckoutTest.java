package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test(description = "Successful checkout test")
    public void successfulCheckoutStepOne(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("John","Smith","12344");
        Assert.assertTrue(checkoutPage.finishButton(),"No finish button is displayed");

    }

    @Test(description = "Unsuccessful checkout test - first name was not provided")
    public void firstNameShouldBeProvided(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("","Smith","12344");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: First Name is required", "Checkout without Firstname is possible");

    }

    @Test(description = "Unsuccessful checkout test - last name was not provided")
    public void lastNameShouldBeProvided(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("John","","12344");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: Last Name is required", "Checkout without Lastname is possible");

    }

    @Test(description = "Unsuccessful checkout test - zip code was not provided")
    public void zipCodeShouldBeProvided(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("John","shshsh","");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: Postal Code is required", "Checkout without zipcode is possible");

    }

    @Test (description = " Test with successful purchase made")
    public void finishThePurchase(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("John","shshsh","");
        checkoutPage.goToFinishCheckoutPage();
        Assert.assertEquals(cartPage.getTitleText(), "Checkout: Complete!", "You are not finish purchase  page");
        checkoutPage.backToHomeButton();
        Assert.assertEquals(cartPage.getTitleText(), "Products", "You are not on product page");

    }



}

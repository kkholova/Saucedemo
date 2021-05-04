package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void successfulCheckoutStepOne(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("John","Smith","12344");
        Assert.assertTrue(checkoutPage.finishButton(),"No finish button is displayed");

    }

    @Test
    public void firstNameShouldBeProvided(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("","Smith","12344");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: First Name is required", "Checkout without Firstname is possible");

    }

    @Test
    public void lastNameShouldBeProvided(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("John","","12344");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: Last Name is required", "Checkout without Lastname is possible");

    }

    @Test
    public void zipCodeShouldBeProvided(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        checkoutPage.checkoutStepOne("John","shshsh","");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: Postal Code is required", "Checkout without zipcode is possible");

    }
}

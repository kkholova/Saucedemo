package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void productCouldBeRemovedFromCartFromCartPage(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCartPage();
        cartPage.removeFromCart("Sauce Labs Backpack");
        //TODO check that item is removed
    }

    @Test
    public void moveToCheckOutPage(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        //TODO check you are on checkout page
//        Assert.assertTrue();

    }
}

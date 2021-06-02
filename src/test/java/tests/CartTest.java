package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void productCouldBeRemovedFromCartFromCartPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCartPage();
        cartPage.removeFromCart("Sauce Labs Backpack");
        //TODO check that item is removed
        boolean isError = cartPage.findRemovedFromCart("Sauce Labs Backpack");
        Assert.assertFalse(isError, "Item was not removed");
    }

    @Test
    public void moveToCheckOutPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCartPage();
        cartPage.goToCheckoutPage();
        //TODO check you are on checkout page
        Assert.assertEquals(cartPage.getTitleText(), "Checkout: Your Information", "You are not on checkout page");

    }
}

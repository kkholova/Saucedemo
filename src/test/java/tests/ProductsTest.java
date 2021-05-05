package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productShouldBeAddedToCart(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCartPage();
        //TODO validate name and price

        Assert.assertEquals(cartPage.itemName(),"Test.allTheThings() T-Shirt (Red)", "Item wasn't added");
        Assert.assertEquals(cartPage.itemPrice(),"$15.99", "Correct price not found");

    }

    @Test
    public void productCouldBeRemovedFromCartFromProductPage(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(productsPage.itemQuantityBadge(),"1", "Item quantity badge not counted");
        productsPage.removeItemFromProductPage("Test.allTheThings() T-Shirt (Red)");
        //TODO check that item is removed
        Assert.assertEquals(productsPage.textOnAddOrRemoveButton("Test.allTheThings() T-Shirt (Red)"),"ADD TO CART", "Button Texted still \"Removed\"");
    }
}

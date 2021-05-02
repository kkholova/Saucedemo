import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends BaseTest{

    @Test
    public void addToCart(){
        WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addButton.click();
        WebElement openCart = driver.findElement(By.id("shopping_cart_container"));
        openCart.click();
        String itemName = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(itemName,"Sauce Labs Backpack", "Item wasn't added");
        String itemPrice = driver.findElement(By.className("inventory_item_price")).getText();
        Assert.assertEquals(itemPrice, "$29.99", "Item has wrong price");

    }
}

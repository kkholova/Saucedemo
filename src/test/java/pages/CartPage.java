package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    String findItemName = "//*[contains(text(),'%s')]";
    String removeFromCartButton = "//*[contains(text(),'%s')]//ancestor::*[@class = 'cart_item']//child::button";
    public static final By ITEMPRICE = By.xpath("//div[@class = 'inventory_item_price']");
    public static final By ITEMNAME = By.xpath("//div[@class = 'inventory_item_name']");
    public static final By CHECKOUT_BUTTON = By.id("checkout");


    public CartPage(WebDriver driver){
        super(driver);
    }

    public void openCartPage(){
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public String itemName(){
        return driver.findElement(ITEMNAME).getText();
    }

    public String itemPrice(){
        return driver.findElement(ITEMPRICE).getText();
    }

    public void removeFromCart(String itemName){
        driver.findElement(By.xpath(String.format(removeFromCartButton, itemName))).click();

    }

    public boolean findRemovedFromCart(String itemName){
       return driver.findElement(By.xpath(String.format(findItemName, itemName))).isDisplayed();

    }

    public void goToCheckoutPage(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }




}

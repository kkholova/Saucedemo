package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage {

    String findItemName = "//*[contains(text(),'%s')]";
    String removeFromCartButton = "//*[contains(text(),'%s')]//ancestor::*[@class = 'cart_item']//child::button";
    public static final By ITEMPRICE = By.cssSelector(".inventory_item_price");
    public static final By ITEMNAME = By.cssSelector(".inventory_item_name");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By TITLE_TEXT = By.cssSelector(".title");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open cart page")
    public void openCartPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Step("Find item name")
    public String itemName() {
        return driver.findElement(ITEMNAME).getText();
    }

    @Step("Find item price")
    public String itemPrice() {
        return driver.findElement(ITEMPRICE).getText();
    }

    @Step("Click on remove button ")
    public void removeFromCart(String itemName) {
        driver.findElement(By.xpath(String.format(removeFromCartButton, itemName))).click();

    }

    @Step("Find product removed from the cart")
    public boolean findRemovedFromCart(String itemName) {
        boolean isDisplayed;
        try{
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            isDisplayed = driver.findElement(By.xpath(String.format(findItemName, itemName))).isDisplayed();
    } catch(NoSuchElementException exception){
            isDisplayed = false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return isDisplayed;

    }

    @Step("Click on checkout button")
    public void goToCheckoutPage() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public String getTitleText() {
        return driver.findElement(TITLE_TEXT).getText();
    }

}

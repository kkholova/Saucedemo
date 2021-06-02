package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    String addToCartButton = "//*[contains(text(),'%s')]//ancestor::*[@class = 'inventory_item']//child::button";
    String removeFromCartProductPageButton = "//*[contains(text(),'%s')]//ancestor::*[@class = 'inventory_item']//child::button";
    public static final By ITEM_BADGE_QUANTITY = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product to the cart")
    public void addToCart(String itemName) {
        driver.findElement(By.xpath(String.format(addToCartButton, itemName))).click();

    }

    @Step("Remove product to the cart")
    public void removeItemFromProductPage(String itemName) {
        driver.findElement(By.xpath(String.format(removeFromCartProductPageButton, itemName))).click();

    }

    @Step("Get text reflected on add/remove button")
    public String textOnAddOrRemoveButton(String itemName) {
        return driver.findElement(By.xpath(String.format(removeFromCartProductPageButton, itemName))).getText();
    }

    public String itemQuantityBadge() {
        return driver.findElement(ITEM_BADGE_QUANTITY).getText();
    }


}

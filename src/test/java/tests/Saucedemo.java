package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class Saucedemo extends BaseTest {

    @Test
    public void locators(){

// menu by id
        driver.findElement(By.id("menu_button_container"));
//name
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
// classname sort
        driver.findElement(By.className("product_sort_container"));
//        tag
        driver.findElement(By.tagName("button"));
//        linktext menu-about
        driver.findElement(By.linkText("About"));
//        partiallinktext - footer-twitter

        driver.findElement(By.partialLinkText("Twitt"));
//        xpath attribute
        driver.findElements(By.xpath("//div[@class = 'inventory_item_price']"));
        driver.findElements(By.xpath("//div[text(),'9.99']"));
        driver.findElements(By.xpath("//div[contains(@class,'Labs Backpack')]"));
        driver.findElements(By.xpath("//div[contains(text(),'All Rights Reserved')]"));
        driver.findElements(By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div"));
        driver.findElements(By.xpath("//div[@class = 'inventory_details_desc_container']//descendant::div"));
        driver.findElements(By.xpath("//li[@class = 'social_twitter']//following::li"));
        driver.findElements(By.xpath("//div[@class = 'inventory_item_desc']//parent"));
        driver.findElements(By.xpath("//li[@class = 'social_linkedin']//preceding::li"));
        driver.findElements(By.xpath("//button[@class = 'btn btn_primary btn_small btn_inventory'" +
                " and @name = 'add-to-cart-sauce-labs-bolt-t-shirt']"));

        driver.findElements(By.cssSelector(".btn"));
        driver.findElements(By.cssSelector(".btn.cart_button"));
        driver.findElements(By.cssSelector(".cart_item_label .item_pricebar"));
        driver.findElements(By.cssSelector("#remove-sauce-labs-bike-light"));
        driver.findElements(By.cssSelector("ul"));
        driver.findElements(By.cssSelector("div.inventory_item"));
        driver.findElements(By.cssSelector("[data-test]"));
        driver.findElements(By.cssSelector("[class= 'pricebar']"));
        driver.findElements(By.cssSelector("[class~=Name]"));
        driver.findElements(By.cssSelector("[alt|= test]"));
        driver.findElements(By.cssSelector("a[href^=\"https\"]"));
        driver.findElements(By.cssSelector("img[scr$=\".jpg\"]"));
        driver.findElements(By.cssSelector("img[alt*=Sauce]"));
    }

}
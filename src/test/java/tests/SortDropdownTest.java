package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SortDropdownTest extends BaseTest{

    @Test
    public void productsAreSortedByNameFromAToZ(){
        loginPage.open();
        loginPage.login(USER, PASSWORD);
//        WebElement itemName = driver.findElement(By.cssSelector(".inventory_item_name"));
//        Select select = new Select(itemName);
//        List<WebElement> allProductsNames = select.getOptions();
//        allProductsNames.sort(itemName);



    }


}

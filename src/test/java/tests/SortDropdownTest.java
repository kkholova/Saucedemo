package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SortDropdownTest extends BaseTest {

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

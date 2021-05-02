import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn extends BaseTest{

    @Test
    public void logIn(){
        WebElement isLogged = driver.findElement(By.id("inventory_container"));

        Assert.assertTrue(isLogged.isDisplayed(),"Log In failed");
    }
}

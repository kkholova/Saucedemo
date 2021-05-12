package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn extends BaseTest{

    @Test
    public void successfulLogIn(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        WebElement isLogged = driver.findElement(By.id("inventory_container"));

        Assert.assertTrue(isLogged.isDisplayed(),"Log In failed");
    }

    @Test
    public void userNameShouldBeRequired(){
        loginPage.open();
        loginPage.login("",PASSWORD);
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error,"Epic sadface: Username is required", "Error message is not correct");
    }

    @Test
    public void userPasswordShouldBeRequired(){
        loginPage.open();
        loginPage.login(USER,"");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error,"Epic sadface: Password is required", "Error message is not correct");
    }

    @Test
    public void userPasswordShouldMatchPassword(){
        loginPage.open();
        loginPage.login(USER,"12344");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error,"Epic sadface: Username and password do not match any user in this service",
                "Error message is not correct");
    }

    @Test
    public void lockedOutUserShouldNotBeLoggedIn(){
        loginPage.open();
        loginPage.login("locked_out_user",PASSWORD);
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error,"Epic sadface: Sorry, this user has been locked out.",
                "Error message is not correct");
    }

    @Test
    public void logout(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        loginPage.logout();
        boolean isLoggedOut = driver.findElement(By.id("login-button")).isDisplayed();
        Assert.assertTrue(isLoggedOut, "Logout failed");

    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

public class LogIn extends BaseTest {

    @DataProvider(name = "Login Data")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"", PASSWORD, "Epic sadface: Username is required"},
                {USER, "", "Epic sadface: Password is required"},
                {USER, "fjfjf", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(retryAnalyzer = Retry.class, description = "Successful log in")
    public void successfulLogIn(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        WebElement isLogged = driver.findElement(By.id("inventory_container"));

        Assert.assertTrue(isLogged.isDisplayed(),"Log In failed");
    }

    @Test(description = "Negative tests for logi - username is absentn", dataProvider = "Login Data")
    public void userNameShouldBeRequired(String user, String password, String errorMessage){
        loginPage.open();
        loginPage.login(user,password);
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error,errorMessage, "Error message is not correct");
    }

    @Test(description = "Negative tests for login - logout", dataProvider = "Login Data")
    public void logout(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        loginPage.logout();
        boolean isLoggedOut = driver.findElement(By.id("login-button")).isDisplayed();
        Assert.assertTrue(isLoggedOut, "Logout failed");

    }
}

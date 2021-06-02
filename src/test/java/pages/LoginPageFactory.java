package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage{

    @FindBy(id = "user-name")
    WebElement userInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(id = "[data-test = error]")
    WebElement errorText;

    public LoginPageFactory(WebDriver driver){
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver,this);
    }

    public void login(String user, String password) {
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorText.getText();
    }



}

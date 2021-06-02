package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public static final By FIRSTNAME_CHECKOUT_INPUT = By.id("first-name");
    public static final By LASTNAME_CHECKOUT_INPUT = By.id("last-name");
    public static final By ZIP_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By BACK_HOME_BUTTON = By.id("back-to-products");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test = error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill the form for checkout")
    public void checkoutStepOne(String firstname, String lastname, String zipcode) {
//        wait.until(ExpectedConditions.)
        driver.findElement(FIRSTNAME_CHECKOUT_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_CHECKOUT_INPUT).sendKeys(lastname);
        driver.findElement(ZIP_INPUT).sendKeys(zipcode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Check that finish button is displayed")
    public boolean finishButton() {
        return driver.findElement(FINISH_BUTTON).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();

    }

    @Step("Click on finish button and go to finish checkout page")
    public void goToFinishCheckoutPage() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Click on back Home button")
    public void backToHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}

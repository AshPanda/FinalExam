package page_object.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalCheck {


    private final By enterFirstName = By.cssSelector("#first-name");
    private final By enterLastName = By.cssSelector("#last-name");
    private final By enterPostalCode = By.cssSelector("#postal-code");

    private final By continueButton = By.cssSelector("#continue");
    private static WebDriver driver = null;

    public FinalCheck(WebDriver driver) {
        FinalCheck.driver = driver;

    }
    @Step("Заполнение поля First Name")
    public void insertFirstName(String firstName) {
        driver.findElement(enterFirstName).sendKeys(firstName);
    }

    @Step("Заполнение поля Last Name")
    public void insertLastName(String lastName) {
        driver.findElement(enterLastName).sendKeys(lastName);
    }
    @Step("Заполнение поля PostalCode")
    public void insertPostalCode(String postCode) {
        driver.findElement(enterPostalCode).sendKeys(postCode);
    }
    @Step("Нажатие кнопки Continue")
    public void clickButton() {
        driver.findElement(continueButton).click();
    }



}

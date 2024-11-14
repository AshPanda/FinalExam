package page_object.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authorization {
    private final By userNameField = By.cssSelector("#user-name");
    private final By passwordField = By.cssSelector("#password");
    private final By errorMessage = By.cssSelector(".error-message-container");
    private final By loginButton = By.cssSelector("#login-button");
    private static WebDriver driver = null;
    public static final String url = "https://www.saucedemo.com/";

    public Authorization(WebDriver driver) {
        Authorization.driver = driver;
    }

    @Step("Открываем сайт")
    public static void open() {
        driver.get(url);
    }

    @Step("Заполнение поля Username")
    public void insertLogin(String usernameStandard) {
        driver.findElement(userNameField).sendKeys(usernameStandard);
    }

    @Step("Заполнение поля Password")
    public void insertPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажатие кнопки")
    public void clickButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Вывод сообщения об ошибки при вводе невалидных данных в форму авторизации")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

}

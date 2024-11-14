package page_object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_object.Base;
import page_object.elements.Authorization;
import page_object.elements.ConfigReader;

import java.util.Objects;

public class LoginPage extends Base {
    private final Authorization auth;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        this.auth = new Authorization(driver);
    }

    @Step("Ввод корректного логина")
    public void getStandardLogin() {
        auth.insertLogin(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("STANDARD_USER"));
    }

    @Step("Ввод заблокированного логина")
    public void getBlockedLogin() {
        auth.insertLogin(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("LOCKED_OUT_USER"));
    }

    @Step("Ввод пароля")
    public void getPassword() {
        auth.insertPassword(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("PASSWORD"));
    }

    @Step("Ввод глючного логина")
    public void getGlitchLogin() {
        auth.insertLogin(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("PERFORMANCE_GLITCH_USER"));
    }

    @Step("Нажатия кнопки \"Login\"")
    public void clickButtonLogin() {
        auth.clickButton();
    }

    @Step("Вывод ошибки при не успешной авторизации")
    public String getErrorMessage() {
        return auth.getErrorMessage();
    }

}

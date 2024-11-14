package page_object;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page_object.elements.Authorization;
import page_object.ext.BasePageResolver;
import page_object.ext.LoginPageResolver;
import page_object.ext.WebDriverShutter;
import page_object.page.BasePage;


@DisplayName("UI Тесты по сайту https://www.saucedemo.com/")
@Epic("Авторизация на сайте")
@ExtendWith(LoginPageResolver.class)
@ExtendWith(BasePageResolver.class)
@ExtendWith(WebDriverShutter.class)
public class AuthorizationTest extends Base {

    @Test
    @DisplayName("Успешная авторизация обычным пользователем")
    @Tag("positive")
    @Story("Проверка авторизации нормальным пользователем")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithStandardUser(BasePage basePage) {
        Authorization.open();
        basePage.loginPage.getStandardLogin();
        basePage.loginPage.getPassword();
        basePage.loginPage.clickButtonLogin();
        Assertions.assertEquals("Products", basePage.catalogPage.getTitle());
    }
    @Test
    @DisplayName("Попытка авторизация заблокированным пользователем")
    @Tag("negative")
    @Story("Проверка авторизации заблокированным пользователем")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithBlockedUser(BasePage basePage) {
        Authorization.open();
        basePage.loginPage.getBlockedLogin();
        basePage.loginPage.getPassword();
        basePage.loginPage.clickButtonLogin();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", basePage.loginPage.getErrorMessage());
    }
}

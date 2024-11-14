package page_object;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page_object.elements.Authorization;
import page_object.elements.ConfigReader;
import page_object.ext.*;
import page_object.page.BasePage;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("E2E Тесты на сайте")
@ExtendWith(LoginPageResolver.class)
@ExtendWith(BasePageResolver.class)
@ExtendWith(CartPageResolver.class)
@ExtendWith(CatalogPageResolver.class)
@ExtendWith(CheckInfoPageResolver.class)
@ExtendWith(FinalPageResolver.class)
@ExtendWith(WebDriverShutter.class)
public class E2ETest {


    @Test
    @DisplayName("Проверка осуществления покупки обычным пользователем")
    void standardBuyer(BasePage basePage) {
        Authorization.open();
        basePage.loginPage.getStandardLogin();
        basePage.loginPage.getPassword();
        basePage.loginPage.clickButtonLogin();
        assertEquals("Products", basePage.catalogPage.getTitle());
        basePage.catalogPage.addToCartBackPack();
        basePage.catalogPage.addToCartTshirt();
        basePage.catalogPage.addToCartOnesie();
        basePage.catalogPage.addToCart();
        assertEquals("Your Cart", basePage.catalogPage.getTitle());
        assertEquals("Sauce Labs Backpack", basePage.checkInfoPage.getBackpack());
        assertEquals("Sauce Labs Bolt T-Shirt", basePage.checkInfoPage.getTshirt());
        assertEquals("Sauce Labs Onesie", basePage.checkInfoPage.getOnesie());
        basePage.checkInfoPage.clickCheckoutButton();
        assertEquals("Checkout: Your Information", basePage.catalogPage.getTitle());
        basePage.finalCheckPage.getFirstName();
        basePage.finalCheckPage.getLastName();
        basePage.finalCheckPage.getPostalCode();
        basePage.finalCheckPage.clickContinueButton();
        assertEquals("Checkout: Overview", basePage.catalogPage.getTitle());
        assertEquals("Sauce Labs Backpack", basePage.checkInfoPage.getBackpack());
        assertEquals("Sauce Labs Bolt T-Shirt", basePage.checkInfoPage.getTshirt());
        assertEquals("Sauce Labs Onesie", basePage.checkInfoPage.getOnesie());
        assertEquals(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("TOTAL_SUM"), basePage.cartPage.getTotal());
        basePage.cartPage.clickButton();
        assertEquals("Checkout: Complete!", basePage.catalogPage.getTitle());

    }
    @Test
    @DisplayName("Проверка осуществления покупки глючным пользователем")
    void GlichBuyer(BasePage basePage){
        Authorization.open();
        basePage.loginPage.getGlitchLogin();
        basePage.loginPage.getPassword();
        basePage.loginPage.clickButtonLogin();
        assertEquals("Products", basePage.catalogPage.getTitle());
        basePage.catalogPage.addToCartBackPack();
        basePage.catalogPage.addToCartTshirt();
        basePage.catalogPage.addToCartOnesie();
        basePage.catalogPage.addToCart();
        assertEquals("Your Cart", basePage.catalogPage.getTitle());
        assertEquals("Sauce Labs Backpack", basePage.checkInfoPage.getBackpack());
        assertEquals("Sauce Labs Bolt T-Shirt", basePage.checkInfoPage.getTshirt());
        assertEquals("Sauce Labs Onesie", basePage.checkInfoPage.getOnesie());
        basePage.checkInfoPage.clickCheckoutButton();
        assertEquals("Checkout: Your Information", basePage.catalogPage.getTitle());
        basePage.finalCheckPage.getFirstName();
        basePage.finalCheckPage.getLastName();
        basePage.finalCheckPage.getPostalCode();
        basePage.finalCheckPage.clickContinueButton();
        assertEquals("Checkout: Overview", basePage.catalogPage.getTitle());
        assertEquals("Sauce Labs Backpack", basePage.checkInfoPage.getBackpack());
        assertEquals("Sauce Labs Bolt T-Shirt", basePage.checkInfoPage.getTshirt());
        assertEquals("Sauce Labs Onesie", basePage.checkInfoPage.getOnesie());
        assertEquals(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("TOTAL_SUM"), basePage.cartPage.getTotal());
        basePage.cartPage.clickButton();
        assertEquals("Checkout: Complete!", basePage.catalogPage.getTitle());}
}

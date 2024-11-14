package page_object.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Catalog {
    private final By titleOfThePage = By.cssSelector(".title");
    private final By addToCartBackPack = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private final By addToCartTshirt = By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addToCartOnesie = By.cssSelector("#add-to-cart-sauce-labs-onesie");
    private final By addToCart = By.cssSelector("#shopping_cart_container");
    private static WebDriver driver = null;

    public Catalog(WebDriver driver) {
        Catalog.driver = driver;
    }

    @Step("Запрос название страницы")
    public String getHeader() {
        return driver.findElement(titleOfThePage).getText();
    }

    @Step("Добавление Рюкзака")
    public void addToCartBackPack() {
        driver.findElement(addToCartBackPack).click();
    }

    @Step("Добавление Футболки")
    public void addToCartTshirt() {
        driver.findElement(addToCartTshirt).click();
    }

    @Step("Добавление Детского Комбинезона")
    public void addToCartOnesie() {
        driver.findElement(addToCartOnesie).click();
    }
    @Step("Добавление Детского Комбинезона")
    public void addToCart() {
        driver.findElement(addToCart).click();
    }
}

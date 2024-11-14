package page_object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_object.Base;
import page_object.elements.Catalog;

public class CatalogPage extends Base {
    private final Catalog catalog;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        this.catalog = new Catalog(driver);
    }

    @Step("Получение заголовка страницы")
    public String getTitle(){
        return catalog.getHeader();
    }

    @Step("Добавление Футболки")
    public void addToCartTshirt() {
        catalog.addToCartTshirt();
    }

    @Step("Добавление Рюкзака")
    public void addToCartBackPack() {
        catalog.addToCartBackPack();
    }

    @Step("Добавление Детского Комбинезона")
    public void addToCartOnesie() {
        catalog.addToCartOnesie();
    }

    @Step("Переход в корзину")
    public void addToCart() {
        catalog.addToCart();
    }

}

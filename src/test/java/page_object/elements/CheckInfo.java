package page_object.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckInfo {
    private final By backpack = By.cssSelector("#item_4_title_link");
    private final By tShirt = By.cssSelector("#item_1_title_link");
    private final By onesie = By.cssSelector("#item_2_title_link");

    private final By checkoutButton = By.cssSelector("#checkout");
    private static WebDriver driver = null;

    public CheckInfo(WebDriver driver) {
        CheckInfo.driver = driver;
    }

    @Step("Получение Рюкзака")
    public String getBackpack() {
        return driver.findElement(backpack).getText();
    }

    @Step("Получение Футболки")
    public String getTshirt() {
        return driver.findElement(tShirt).getText();
    }

    @Step("Получение Детского Комбенизона")
    public String getOnesie() {
        return driver.findElement(onesie).getText();
    }


    @Step("Нажатия кнопки оформления заказа")
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

}

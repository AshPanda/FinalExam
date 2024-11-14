package page_object.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private final By totalSum = By.cssSelector(".summary_total_label");
    private final By FinishButton = By.cssSelector("#finish");
    private final By finalText = By.cssSelector(".complete-header");
    private static WebDriver driver = null;
    public Cart(WebDriver driver) {
        Cart.driver = driver;
    }

    @Step("Получение полной суммы")
    public String getTotalSum() {
        return driver.findElement(totalSum).getText();
    }

    @Step("Нажатия кнопки Finish")
    public void clickFinishButton() {
        driver.findElement(FinishButton).click();
    }

    @Step("Получение подтверждающего сообщения об успешном оформлении заказа")
    public String getFinishText() {
        return driver.findElement(finalText).getText();
    }

}

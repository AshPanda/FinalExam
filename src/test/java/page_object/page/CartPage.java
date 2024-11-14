package page_object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_object.Base;
import page_object.elements.Cart;

public class CartPage extends Base {
    private  final Cart cart;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.cart = new Cart(driver);
    }

    @Step("Получение полной суммы")
    public String getTotal() {
        return cart.getTotalSum();
    }

    @Step("Нажатия кнопки Finish")
    public void clickButton() {
        cart.clickFinishButton();
    }

    @Step("Получение подтверждающего сообщения об успешном оформлении заказа")
    public String getText() {
        return cart.getFinishText();
    }


}

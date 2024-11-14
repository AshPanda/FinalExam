package page_object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_object.Base;
import page_object.elements.CheckInfo;

public class CheckInfoPage extends Base {
    private final CheckInfo checkInfo;

    public CheckInfoPage(WebDriver driver) {
        this.driver = driver;
        this.checkInfo = new CheckInfo(driver);
    }

    @Step("Получение наименования товара Рюкзак")
    public String getBackpack() {
        return checkInfo.getBackpack();
    }

    @Step("Получение наименования товара  Sauce Labs Bolt T-Shirt")
    public String getTshirt() {
        return checkInfo.getTshirt();
    }

    @Step("Получение наименования товара Sauce Labs Onesie")
    public String getOnesie() {
        return checkInfo.getOnesie();
    }


    @Step("Нажатие кнопки Chekout")
    public void clickCheckoutButton() {
        checkInfo.clickCheckoutButton();
    }
}

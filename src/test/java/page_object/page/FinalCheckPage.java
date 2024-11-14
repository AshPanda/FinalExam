package page_object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_object.Base;
import page_object.elements.ConfigReader;
import page_object.elements.FinalCheck;

import java.util.Objects;

public class FinalCheckPage extends Base {
    private final FinalCheck finalCheck;

    public FinalCheckPage(WebDriver driver) {
        this.driver = driver;
        this.finalCheck = new FinalCheck(driver);
    }

    @Step("Получение Имени")
    public void getFirstName() {
       finalCheck.insertFirstName(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("FIRST_NAME"));
    }

    @Step("Получение Фамилии")
    public void getLastName() {
        finalCheck.insertLastName(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("LAST_NAME"));
    }

    @Step("Получение почтового индекса")
    public void getPostalCode() {
        finalCheck.insertPostalCode(Objects.requireNonNull(ConfigReader.getProperties()).getProperty("POST_CODE"));
    }

    @Step("Нажатие кнопки Continue")
    public void clickContinueButton() {
        finalCheck.clickButton();
    }
}

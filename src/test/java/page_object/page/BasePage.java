package page_object.page;

import org.openqa.selenium.WebDriver;
import page_object.Base;

public class BasePage extends Base {

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.catalogPage = new CatalogPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkInfoPage = new CheckInfoPage(driver);
        this.finalCheckPage = new FinalCheckPage(driver);
    }
}

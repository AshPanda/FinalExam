package page_object.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.page.FinalCheckPage;

import static page_object.ext.WebDriverShutter.WD_KEY;

public class FinalPageResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(FinalCheckPage.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        WebDriver driver =
                extensionContext
                        .getStore(WebDriverShutter.namespace)
                        .getOrComputeIfAbsent(WD_KEY, (s) -> new ChromeDriver(), WebDriver.class);

        return new FinalCheckPage(driver);
    }
}

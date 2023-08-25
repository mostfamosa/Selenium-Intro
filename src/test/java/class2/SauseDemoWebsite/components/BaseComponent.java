package class2.SauseDemoWebsite.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    protected WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
    public WebElement waitToLoadComponent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

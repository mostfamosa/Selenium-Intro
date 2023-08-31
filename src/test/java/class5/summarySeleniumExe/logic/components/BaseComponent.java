package class5.summarySeleniumExe.logic.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    private static final Logger logger = LogManager.getLogger(BaseComponent.class);

    protected WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    //wait the element to be found
    public WebElement waitToLoad(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            logger.error("NoSuchElementException: \n" + e.getMessage());

            throw new NoSuchElementException("NoSuchElementException: " + e.getMessage());
        } catch (TimeoutException e) {
            logger.error("TimeoutException: \n" + e.getMessage());
            throw new TimeoutException("TimeoutException: " + e.getMessage());
        }
    }

}

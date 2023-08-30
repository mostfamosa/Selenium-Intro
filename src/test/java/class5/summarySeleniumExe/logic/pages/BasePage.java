package class5.summarySeleniumExe.logic.pages;

import class5.summarySeleniumExe.Infra.HttpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final Logger logger = LogManager.getLogger(HttpRequest.class);

    protected WebDriver driver;

    //locators
    private final By LABEL_TITLE = By.xpath("(//h2)[1]");

    //web elements
    private WebElement titlePage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        initPage();
    }

    private void initPage() {
        titlePage = waitToLoad(LABEL_TITLE);
    }

    public WebDriver getDriver() {
        return driver;
    }

    //get the title of the page
    public String getPageTitle() {
        return titlePage.getText();
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

    //wait the element to be deleted
    public boolean waitToDelete(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            logger.error("NoSuchElementException: \n" + e.getMessage());
            throw new NoSuchElementException("NoSuchElementException: " + e.getMessage());
        } catch (TimeoutException e) {
            logger.error("TimeoutException: \n" + e.getMessage());
            throw new TimeoutException("TimeoutException: " + e.getMessage());
        }
    }

}

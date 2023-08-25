package class2.SauseDemoWebsite.pages;

import class2.SauseDemoWebsite.components.Footer;
import class2.SauseDemoWebsite.components.Header;
import class2.SauseDemoWebsite.components.SideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    private final By BUTTON_ADDTOCART = By.xpath("(//button[text()='Add to cart'])[1]");
    private final By BUTTON_REMOVE = By.xpath("(//button[text()='Remove'])[1]");

    private WebElement removeFromCartBtn;
    private WebElement addToCartBtn;

    private Header header;
    private Footer footer;
    private SideMenu sideMenu;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
        this.footer = new Footer(driver);
        this.sideMenu = new SideMenu(driver);
    }

    public WebElement waitToLoad(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Header getHeader() {
        return header;
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

    public Footer getFooter() {
        return footer;
    }

    public void addItemToCart() {
        this.addToCartBtn = waitToLoad(BUTTON_ADDTOCART);
        addToCartBtn.click();
    }

    public void removeItemfromCart() {
        this.removeFromCartBtn = waitToLoad(BUTTON_REMOVE);
        removeFromCartBtn.click();
    }
}

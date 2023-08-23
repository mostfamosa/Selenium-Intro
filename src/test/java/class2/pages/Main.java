package class2.pages;

import class2.Items;
import class2.components.Footer;
import class2.components.Header;
import class2.components.SideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {
    protected WebDriver driver;

    private final String BUTTON_ADDTOCART = "(//button[text()='Add to cart'])[1]";
    private final String BUTTON_REMOVE = "(//button[text()='Remove'])[1]";
    private WebElement removeFromCartBtn;
    private WebElement addToCartBtn;
    private Header header;
    private SideMenu sideMenu;
    private Footer footer;

    public Main(WebDriver driver) {
        this.driver = driver;
        this.initPage();
    }

    private void initPage() {
        this.header = new Header(this.driver);
        this.sideMenu = new SideMenu(this.driver);
        this.footer = new Footer(this.driver);
    }

    public void addItemToCart() {
        this.addToCartBtn = driver.findElement(By.xpath(BUTTON_ADDTOCART));
        addToCartBtn.click();
    }

    public void removeItemfromCart() {
        this.removeFromCartBtn = driver.findElement(By.xpath(BUTTON_REMOVE));
        removeFromCartBtn.click();
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
}

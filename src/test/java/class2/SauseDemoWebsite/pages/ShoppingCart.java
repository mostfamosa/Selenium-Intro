package class2.SauseDemoWebsite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ShoppingCart extends BasePage {

    private final By BUTTON_CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By BUTTON_CHECKOUT = By.id("checkout");
    private final By CART_ITEMS = By.xpath("//div[@class = 'cart_item']");

    private WebElement continueShoppingBtn;
    private WebElement checkoutBtn;
    private List<WebElement> cartItems;

    public ShoppingCart(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void initPage() {
        continueShoppingBtn = waitToLoad(BUTTON_CONTINUE_SHOPPING);
        checkoutBtn = waitToLoad(BUTTON_CHECKOUT);
    }

    public void clickOnCheckout() {
        this.checkoutBtn.click();
    }

    public void clickOnContinueShopping() {
        this.continueShoppingBtn.click();
    }

    public int getCartQuantity() {
        cartItems = this.driver.findElements(CART_ITEMS);
        return cartItems.size();
    }
}

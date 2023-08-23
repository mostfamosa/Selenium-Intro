package class2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCart extends Main {

    private final String  BUTTON_CONTINUE_SHOPPING = "continue-shopping";
    private final String  BUTTON_CHECKOUT = "checkout";
    private final String CART_ITEMS = "//div[@class = 'cart_item']";

    private WebElement continueShoppingBtn;
    private WebElement checkoutBtn;
    private List<WebElement> cartItems;

    public ShoppingCart(WebDriver driver) {
        super(driver);
        this.initPage();
    }
    public void initPage(){
        continueShoppingBtn = this.driver.findElement(By.id(BUTTON_CONTINUE_SHOPPING));
        checkoutBtn = this.driver.findElement(By.id(BUTTON_CHECKOUT));
    }

    public void clickOnCheckout(){
        this.checkoutBtn.click();
    }

    public void clickOnContinueShopping(){
        this.continueShoppingBtn.click();
    }

    public int getCartQuantity(){
        cartItems = this.driver.findElements(By.xpath(CART_ITEMS));
        return cartItems.size();
    }

}

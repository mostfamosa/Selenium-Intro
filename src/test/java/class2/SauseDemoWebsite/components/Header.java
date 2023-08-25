package class2.SauseDemoWebsite.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BaseComponent {
    private final static By HEADER_TITLE = By.xpath("//div[@class='primary_header']//div[@class='header_label']//div[@class='app_logo']");
    private final static By BUTTON_CART = By.xpath("//a[@class='shopping_cart_link']");

    private WebElement title;
    private WebElement cart;

    public Header(WebDriver driver) {
        super(driver);
        this.initComponent();
    }

    private void initComponent() {
        title = waitToLoadComponent(HEADER_TITLE);
        cart = waitToLoadComponent(BUTTON_CART);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public void goToCart() {
        this.cart.click();
    }
}

package class2.SauseDemoWebsite.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {

    protected WebDriver driver;
    private final static String HEADER_TITLE = "//div[@class='primary_header']//div[@class='header_label']//div[@class='app_logo']";
    private final static String BUTTON_CART = "//a[@class='shopping_cart_link']";

    private WebElement title;
    private WebElement cart;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.initComponent();
    }

    private void initComponent() {
        title = driver.findElement(By.xpath(HEADER_TITLE));
        cart = driver.findElement(By.xpath(BUTTON_CART));
    }

    public String getTitle() {
        title = driver.findElement(By.xpath(HEADER_TITLE));
        return this.title.getText();
    }

    public void goToCart() {
        cart = driver.findElement(By.xpath(BUTTON_CART));
        this.cart.click();
    }

}

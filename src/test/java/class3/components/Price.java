package class3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Price extends BaseComponent{

    private By MIN_PRICE = By.id("s0-1-17-5[2]-@range-comp[]-@range-textbox[]-textbox");
    private By MAX_PRICE = By.id("s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox");

    private WebElement minPrice;
    private WebElement maxPrice;

    public Price(WebDriver driver) {
        super(driver);
        componentInit();
    }

    private void componentInit() {
        minPrice = waitToLoadComponent(MIN_PRICE);
        maxPrice = waitToLoadComponent(MAX_PRICE);
    }

    private void fillMinPrice(String min){
        minPrice.sendKeys(min);
    }

    private void fillMaxPrice(String max){
        maxPrice.sendKeys(max);
    }

    public void fillPriceOption(String min,String max){
        fillMinPrice(min);
        fillMaxPrice(max);
    }
}

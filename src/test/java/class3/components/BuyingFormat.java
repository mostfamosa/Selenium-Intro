package class3.components;

import class3.entity.BuyingFormatOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyingFormat extends BaseComponent{

    public BuyingFormat(WebDriver driver) {
        super(driver);
    }

    public void selectBuyingFormat(BuyingFormatOptions toSelect) {
        By OptionToSelect = By.id(toSelect.getId());
        WebElement checkbox = waitToLoadComponent(OptionToSelect);
        checkbox.click();
    }
}

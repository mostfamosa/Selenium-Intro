package class3.components;

import class3.entity.ShippingOptions;
import class3.entity.ShowResultsOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shipping extends BaseComponent{
    public Shipping(WebDriver driver) {
        super(driver);
    }

    public void selectShippingOption(ShippingOptions toSelect) {
        By OptionToSelect = By.id(toSelect.getId());
        WebElement checkbox = waitToLoadComponent(OptionToSelect);
        if(!checkbox.isSelected())
            checkbox.click();
    }

    public void deSelectShippingOption(ShippingOptions toSelect) {
        By OptionToSelect = By.id(toSelect.getId());
        WebElement checkbox = waitToLoadComponent(OptionToSelect);
        if(checkbox.isSelected())
            checkbox.click();
    }
}

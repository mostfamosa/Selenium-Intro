package class3.components;

import class3.entity.ConditionOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Condition extends BaseComponent{
    public Condition(WebDriver driver) {
        super(driver);
    }

    public void selectCondition(ConditionOptions toSelect) {
        By OptionToSelect = By.id(toSelect.getId());
        WebElement checkbox = waitToLoadComponent(OptionToSelect);
        checkbox.click();
    }
}

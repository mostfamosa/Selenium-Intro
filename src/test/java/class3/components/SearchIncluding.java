package class3.components;

import class3.entity.SearchIncludeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchIncluding extends BaseComponent {

    public SearchIncluding(WebDriver driver) {
        super(driver);
    }

    public void selectSearchIncludingOptions(SearchIncludeOptions toCheck) {
        By OptionToCheck = By.id(toCheck.getId());
        WebElement checkbox = waitToLoadComponent(OptionToCheck);
        if (!checkbox.isSelected())
            checkbox.click();
    }

    public void deSelectSearchIncludingOptions(SearchIncludeOptions toCheck) {
        By OptionToCheck = By.id(toCheck.getId());
        WebElement checkbox = waitToLoadComponent(OptionToCheck);
        if (checkbox.isSelected())
            checkbox.click();
    }
}

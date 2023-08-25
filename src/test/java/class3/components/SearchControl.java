package class3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchControl extends BaseComponent{

    private By SEARCH_BUTTON = By.xpath("//div[@class = 'adv-form__actions']//button");
    private By CLEAR_OPTION = By.xpath("//div[@class = 'adv-form__actions']//a");

    private WebElement searchBtn;
    private WebElement clearOption;

    public SearchControl(WebDriver driver) {
        super(driver);
        componentInit();
    }

    private void componentInit() {
        searchBtn = waitToClickComponent(SEARCH_BUTTON);
        clearOption = waitToLoadComponent(CLEAR_OPTION);
    }

    public void search(){
        searchBtn.click();
    }

    public void clearOptions(){
        clearOption.click();
    }
}

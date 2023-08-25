package class3.components;

import class3.entity.Pattern;
import class3.entity.PatternTime;
import class3.entity.ShowResultsOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShowResults extends BaseComponent {

    private By PATTERN = By.id("s0-1-17-5[5]-3[@field[]]-1[0]-_ftrt");
    private By PATTERN_TIME = By.id("s0-1-17-5[5]-3[@field[]]-1[1]-_ftrv");
    private By MIN_BID_COUNT = By.id("s0-1-17-5[5]-@range-comp[]-@range-textbox[]-textbox");
    private By MAX_BID_COUNT = By.id("s0-1-17-5[5]-@range-comp[]-@range-textbox[]_1-textbox");
    private By MIN_QUANTITY = By.id("s0-1-17-5[5]-@range-comp[]_1-@range-textbox[]-textbox");
    private By MAX_QUANTITY = By.id("s0-1-17-5[5]-@range-comp[]_1-@range-textbox[]_1-textbox");

    private WebElement pattern;
    private WebElement patternTime;
    private WebElement minBidCount;
    private WebElement maxBidCount;
    private WebElement minQuantity;
    private WebElement maxQuantity;

    public ShowResults(WebDriver driver) {
        super(driver);
        componentInit();
    }

    private void componentInit() {
        pattern = waitToLoadComponent(PATTERN);
        patternTime = waitToLoadComponent(PATTERN_TIME);
        minBidCount = waitToLoadComponent(MIN_BID_COUNT);
        maxBidCount = waitToLoadComponent(MAX_BID_COUNT);
        minQuantity = waitToLoadComponent(MIN_QUANTITY);
        maxQuantity = waitToLoadComponent(MAX_QUANTITY);
    }

    public void fillMinBidCount(String minBid) {
        this.minBidCount.sendKeys(minBid);
    }

    public void fillMaxBidCount(String maxBid) {
        this.maxBidCount.sendKeys(maxBid);
    }

    public void fillMinQuantity(String minQuantity) {
        this.minQuantity.sendKeys(minQuantity);
    }

    public void fillMaxQuantity(String maxQuantity) {
        this.maxQuantity.sendKeys(maxQuantity);
    }

    public void selectItemPattern(Pattern pattern) {
        Select select = new Select(this.pattern);
        select.selectByVisibleText(pattern.getValue());
    }

    public void selectItemPatternTime(PatternTime time) {
        Select select = new Select(this.patternTime);
        select.selectByVisibleText(time.getValue());
    }

    public void selectShowResultsOptions(ShowResultsOptions toSelect) {
        By OptionToSelect = By.id(toSelect.getId());
        WebElement checkbox = waitToLoadComponent(OptionToSelect);
        if(!checkbox.isSelected())
            checkbox.click();
    }

    public void deSelectShowResultsOptions(ShowResultsOptions toSelect) {
        By OptionToSelect = By.id(toSelect.getId());
        WebElement checkbox = waitToLoadComponent(OptionToSelect);
        if(checkbox.isSelected())
            checkbox.click();
    }
}

package class3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeywordsSearch extends BaseComponent {
    private By INPUT_KEYWORD = By.id("_nkw");
    private By DROPDOWN_OPTIONS = By.id("s0-1-17-4[0]-7[1]-_in_kw");

    private By INPUT_ADDETIONALWORDS = By.id("_ex_kw");
    private By DROPDOWN_CATEGORY = By.id("s0-1-17-4[0]-7[3]-_sacat");
    private By BUTTON_SEARCH = By.xpath("//fieldset[@class='adv-fieldset__keyword']//button");

    private WebElement keywords;
    private WebElement options;
    private WebElement anotherKeywords;
    private WebElement categorys;
    private WebElement searchBtn;

    public KeywordsSearch(WebDriver driver) {
        super(driver);
        componentInit();
    }

    private void componentInit() {
        keywords = waitToLoadComponent(INPUT_KEYWORD);
        options = waitToLoadComponent(DROPDOWN_OPTIONS);
        anotherKeywords = waitToLoadComponent(INPUT_ADDETIONALWORDS);
        categorys = waitToLoadComponent(DROPDOWN_CATEGORY);
        searchBtn = waitToLoadComponent(BUTTON_SEARCH);
    }

    private void fillKeyword(String keyword) {
        keywords.sendKeys(keyword);
    }

    private void fillExtraKeyword(String extraKeyword) {
        anotherKeywords.sendKeys(extraKeyword);
    }

    private void selectOptions(String option) {
        Select select = new Select(options);
        select.selectByVisibleText(option);
    }

    private void selectCategory(String category) {
        Select select = new Select(categorys);
        select.selectByVisibleText(category);
    }

    public void search() {
        searchBtn.click();
    }

    public void fillSearchByKeyword(String keyword, String extraKeyword, String option, String category) {
        fillKeyword(keyword);
        fillExtraKeyword(extraKeyword);
        selectOptions(option);
        selectCategory(category);
    }

}

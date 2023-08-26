package class3.components;

import class3.entity.CategoryOptions;
import class3.entity.KeywordOptions;
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
    private By LINK_SEARCH_TIPS = By.xpath("//span[@class='adv-keywords__help']//a[text()='search tips']");
    private By LINK_ADVANCED_SEARCH = By.xpath("//span[@class='adv-keywords__help']//a[text()='using advanced search options']");

    private WebElement keywords;
    private WebElement options;
    private WebElement anotherKeywords;
    private WebElement categorys;
    private WebElement searchBtn;
    private WebElement searchTipsLink;
    private WebElement advancedSearchLink;

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
        searchTipsLink = waitToLoadComponent(LINK_SEARCH_TIPS);
        advancedSearchLink = waitToLoadComponent(LINK_ADVANCED_SEARCH);
    }

    private void fillKeyword(String keyword) {
        keywords.sendKeys(keyword);
    }

    private void fillExtraKeyword(String extraKeyword) {
        anotherKeywords.sendKeys(extraKeyword);
    }

    private void selectOptions(KeywordOptions option) {
        Select select = new Select(options);
        select.selectByVisibleText(option.getValue());
    }

    private void selectCategory(CategoryOptions category) {
        Select select = new Select(categorys);
        select.selectByVisibleText(category.getValue());
    }

    public void search() {
        searchBtn.click();
    }

    public void searchTipsLink() {
        searchTipsLink.click();
    }

    public void advancedSearchOptionsLink() {
        advancedSearchLink.click();
    }

    public void fillSearchByKeyword(String keyword, String extraKeyword, KeywordOptions option, CategoryOptions category) {
        fillKeyword(keyword);
        fillExtraKeyword(extraKeyword);
        selectOptions(option);
        selectCategory(category);
    }

}

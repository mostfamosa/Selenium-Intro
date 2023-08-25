package class3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
    protected WebDriver driver;

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

    public Keywords(WebDriver driver) {
        this.driver = driver;
        componentInit();
    }

    private void componentInit() {
        keywords = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(INPUT_KEYWORD));
        options = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_OPTIONS));
        anotherKeywords = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(INPUT_ADDETIONALWORDS));
        categorys = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_CATEGORY));
        searchBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(BUTTON_SEARCH));
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

    private void search(){
        searchBtn.click();
    }

    public void searchByKeyword(String keyword, String extraKeyword, String option, String category) {
        fillKeyword(keyword);
        fillExtraKeyword(extraKeyword);
        selectOptions(option);
        selectCategory(category);
        search();
    }

}

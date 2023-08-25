package class3.components;

import class3.entity.PerPageOptions;
import class3.entity.SortByOptions;
import class3.entity.ViewResultOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ViewResultsControl extends BaseComponent{
    private By SORT_BY_SELECT = By.id("s0-1-17-8[9]-1[0]-_sop");
    private By VIEW_RESULT_SELECT = By.id("s0-1-17-8[9]-1[1]-_dmd");
    private By RESULT_PER_PAGE_SELECT = By.id("s0-1-17-8[9]-1[2]-_ipg");

    private WebElement sortBySelect;
    private WebElement viewResultSelect;
    private WebElement resultPerPageSelect;

    public ViewResultsControl(WebDriver driver) {
        super(driver);
        componentInit();
    }

    private void componentInit() {
        this.sortBySelect = waitToLoadComponent(SORT_BY_SELECT);
        this.viewResultSelect = waitToLoadComponent(VIEW_RESULT_SELECT);
        this.resultPerPageSelect = waitToLoadComponent(RESULT_PER_PAGE_SELECT);
    }

    public void selectSortByOption(SortByOptions sortBy) {
        Select select = new Select(sortBySelect);
        select.selectByVisibleText(sortBy.getValue());
    }

    public void selectViewOption(ViewResultOptions viewBy) {
        Select select = new Select(viewResultSelect);
        select.selectByVisibleText(viewBy.getValue());
    }

    public void selectPerPageOption(PerPageOptions viewPerPage) {
        Select select = new Select(resultPerPageSelect);
        select.selectByVisibleText(viewPerPage.getValue());
    }

}

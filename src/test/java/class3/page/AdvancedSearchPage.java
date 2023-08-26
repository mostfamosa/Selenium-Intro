package class3.page;

import class3.components.*;
import org.openqa.selenium.WebDriver;

public class AdvancedSearchPage {

    private WebDriver driver;

    private KeywordsSearch keywordsSearch;
    private SearchIncluding searchIncluding;
    private Price price;
    private BuyingFormat buyingFormat;
    private Condition condition;
    private ShowResults showResults;
    private Shipping shipping;
    private ItemLocation itemLocation;
    private Sellers sellers;
    private ViewResultsControl viewResultsControl;
    private SearchControl searchControl;

    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
        pageInit(driver);
    }

    private void pageInit(WebDriver driver) {
        this.keywordsSearch = new KeywordsSearch(driver);
        this.searchIncluding = new SearchIncluding(driver);
        this.price = new Price(driver);
        this.buyingFormat = new BuyingFormat(driver);
        this.condition = new Condition(driver);
        this.showResults = new ShowResults(driver);
        this.shipping = new Shipping(driver);
        this.itemLocation = new ItemLocation(driver);
        this.sellers = new Sellers(driver);
        this.viewResultsControl = new ViewResultsControl(driver);
        this.searchControl = new SearchControl(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public KeywordsSearch getKeywordsSearch() {
        return keywordsSearch;
    }

    public SearchIncluding getSearchIncluding() {
        return searchIncluding;
    }

    public Price getPrice() {
        return price;
    }

    public BuyingFormat getBuyingFormat() {
        return buyingFormat;
    }

    public Condition getCondition() {
        return condition;
    }

    public ShowResults getShowResults() {
        return showResults;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public ItemLocation getItemLocation() {
        return itemLocation;
    }

    public Sellers getSellers() {
        return sellers;
    }

    public ViewResultsControl getViewResultsControl() {
        return viewResultsControl;
    }

    public SearchControl getSearchControl() {
        return searchControl;
    }
}

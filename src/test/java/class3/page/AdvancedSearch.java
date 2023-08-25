package class3.page;

import class3.components.*;
import class3.entity.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

public class AdvancedSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        KeywordsSearch keywordsSearch = new KeywordsSearch(driver);
        keywordsSearch.fillSearchByKeyword("hi", "lol", "Any words, any order", "Books & Magazines");

        SearchIncluding searchIncluding = new SearchIncluding(driver);
        searchIncluding.searchIncludingOptions(SearchIncludeOptions.TITLE_AND_DESCRIPTION);
        searchIncluding.searchIncludingOptions(SearchIncludeOptions.COMPLETED_ITEMS);
        searchIncluding.searchIncludingOptions(SearchIncludeOptions.SOLD_ITEMS);

        Price price = new Price(driver);
        price.fillPriceOption("200", "1524");

        BuyingFormat buyingFormat = new BuyingFormat(driver);

        buyingFormat.selectBuyingFormat(BuyingFormatOptions.ACCEPT_OFFERS);
        buyingFormat.selectBuyingFormat(BuyingFormatOptions.BUY_NOW);
        buyingFormat.selectBuyingFormat(BuyingFormatOptions.CLASSIFIED_ADS);
        buyingFormat.selectBuyingFormat(BuyingFormatOptions.AUCTION);

        Condition condition = new Condition(driver);
        condition.selectCondition(ConditionOptions.NEW);
        condition.selectCondition(ConditionOptions.USED);
        condition.selectCondition(ConditionOptions.NOT_SPECIFIED);

        ShowResults showResults = new ShowResults(driver);
        showResults.selectShowResultsOptions(ShowResultsOptions.FREE_RETURNS);
        showResults.selectShowResultsOptions(ShowResultsOptions.RETURNS_ACCEPTED);
        showResults.selectShowResultsOptions(ShowResultsOptions.AUTHORIZED_SELLER);
        showResults.selectShowResultsOptions(ShowResultsOptions.DEALS_AND_SAVINGS);
        showResults.selectShowResultsOptions(ShowResultsOptions.SALE_ITEMS);
        showResults.selectShowResultsOptions(ShowResultsOptions.LISTED_AS_LOTS);
        showResults.selectShowResultsOptions(ShowResultsOptions.BENEFITS_CHARITY);
        showResults.selectShowResultsOptions(ShowResultsOptions.AUTHENTICITY_GUARANTEE);
        showResults.deSelectShowResultsOptions(ShowResultsOptions.FREE_RETURNS);

        showResults.selectShowResultsOptions(ShowResultsOptions.ITEMS_WITH_PATTERN);
        showResults.selectItemPattern(Pattern.ENDING_IN_MORE_THAN);
        showResults.selectItemPattern(Pattern.STARTED_WITHIN);
        showResults.selectItemPatternTime(PatternTime.DAY_2);

        showResults.selectShowResultsOptions(ShowResultsOptions.NUMBER_OF_BIDS);
        showResults.fillMinBidCount("5");
        showResults.fillMaxBidCount("15");
        showResults.selectShowResultsOptions(ShowResultsOptions.ITEMS_QUANTITY);
        showResults.fillMinQuantity("51");
        showResults.fillMaxQuantity("510");

        Shipping shipping = new Shipping(driver);
        shipping.selectShippingOption(ShippingOptions.FREE_SHIPPING);
        shipping.selectShippingOption(ShippingOptions.LOCAL_SHIPPING);
        shipping.deSelectShippingOption(ShippingOptions.FREE_SHIPPING);

        ItemLocation itemLocation = new ItemLocation(driver);
        itemLocation.selectItemLocationOptions(ItemLocationOptions.DEFAULT);
        itemLocation.selectItemLocationOptions(ItemLocationOptions.ITEMS_WITHIN);
        itemLocation.fillWithInMiles(LocationByMiles.MILES_100);
        itemLocation.fillWithPostalCode("0020188");
        itemLocation.selectItemLocationOptions(ItemLocationOptions.US_ONLY);
        itemLocation.selectItemLocationOptions(ItemLocationOptions.NORTH_AMERICA);
        itemLocation.selectItemLocationOptions(ItemLocationOptions.WORLDWIDE);
        itemLocation.selectItemLocationOptions(ItemLocationOptions.LOCATED_IN);
        itemLocation.fillLocatedIn("Israel");
        itemLocation.selectItemLocationOptions(ItemLocationOptions.AVAILABLE_TO);
        itemLocation.fillAvailable("Italy");

        Sellers sellers = new Sellers(driver);
        sellers.selectEbaySellersOption();
        sellers.selectSavedSellersOption();
        sellers.selectSpecificSellersOption(true,"123520");

        ViewResultsControl viewResultsControl = new ViewResultsControl(driver);
        viewResultsControl.selectSortByOption(SortByOptions.BEST_MATCH);
        viewResultsControl.selectViewOption(ViewResultOptions.GALLERY_VIEW);
        viewResultsControl.selectPerPageOption(PerPageOptions.PER_PAGE_120);

        SearchControl searchControl = new SearchControl(driver);
        //searchControl.clearOptions();
        searchControl.search();
    }
}

package class3;

import class3.components.*;
import class3.page.AdvancedSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

//enums
import static class3.entity.CategoryOptions.*;
import static class3.entity.KeywordOptions.*;
import static class3.entity.SearchIncludeOptions.*;
import static class3.entity.BuyingFormatOptions.*;
import static class3.entity.ConditionOptions.*;
import static class3.entity.ShowResultsOptions.*;
import static class3.entity.Pattern.*;
import static class3.entity.PatternTime.*;
import static class3.entity.ShippingOptions.*;
import static class3.entity.ItemLocationOptions.*;
import static class3.entity.LocationByMiles.*;
import static class3.entity.SortByOptions.*;
import static class3.entity.ViewResultOptions.*;
import static class3.entity.PerPageOptions.*;
import static class3.entity.Country.*;


public class AdvancedSearchDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);

        KeywordsSearch keywordsSearch = advancedSearchPage.getKeywordsSearch();
        keywordsSearch.fillSearchByKeyword("hi", "lol", ALL_WORDS_ANY_ORDER, ART);

        SearchIncluding searchIncluding = advancedSearchPage.getSearchIncluding();
        searchIncluding.selectSearchIncludingOptions(TITLE_AND_DESCRIPTION);
        searchIncluding.selectSearchIncludingOptions(COMPLETED_ITEMS);
        searchIncluding.selectSearchIncludingOptions(SOLD_ITEMS);

        Price price = advancedSearchPage.getPrice();
        price.fillPriceOption("200", "1524");

        BuyingFormat buyingFormat = advancedSearchPage.getBuyingFormat();

        buyingFormat.selectBuyingFormat(ACCEPT_OFFERS);
        buyingFormat.selectBuyingFormat(BUY_NOW);
        buyingFormat.selectBuyingFormat(CLASSIFIED_ADS);
        buyingFormat.selectBuyingFormat(AUCTION);

        Condition condition = advancedSearchPage.getCondition();
        condition.selectCondition(NEW);
        condition.selectCondition(USED);
        condition.selectCondition(NOT_SPECIFIED);

        ShowResults showResults = advancedSearchPage.getShowResults();
        showResults.selectShowResultsOptions(FREE_RETURNS);
        showResults.selectShowResultsOptions(RETURNS_ACCEPTED);
        showResults.selectShowResultsOptions(AUTHORIZED_SELLER);
        showResults.selectShowResultsOptions(DEALS_AND_SAVINGS);
        showResults.selectShowResultsOptions(SALE_ITEMS);
        showResults.selectShowResultsOptions(LISTED_AS_LOTS);
        showResults.selectShowResultsOptions(BENEFITS_CHARITY);
        showResults.selectShowResultsOptions(AUTHENTICITY_GUARANTEE);
        showResults.deSelectShowResultsOptions(FREE_RETURNS);

        showResults.selectShowResultsOptions(ITEMS_WITH_PATTERN);
        showResults.selectItemPattern(ENDING_IN_MORE_THAN);
        showResults.selectItemPattern(STARTED_WITHIN);
        showResults.selectItemPatternTime(DAY_2);

        showResults.selectShowResultsOptions(NUMBER_OF_BIDS);
        showResults.fillMinBidCount("5");
        showResults.fillMaxBidCount("15");
        showResults.selectShowResultsOptions(ITEMS_QUANTITY);
        showResults.fillMinQuantity("51");
        showResults.fillMaxQuantity("510");

        Shipping shipping = advancedSearchPage.getShipping();
        shipping.selectShippingOption(FREE_SHIPPING);
        shipping.selectShippingOption(LOCAL_SHIPPING);
        shipping.deSelectShippingOption(FREE_SHIPPING);

        ItemLocation itemLocation = advancedSearchPage.getItemLocation();
        itemLocation.selectItemLocationOptions(DEFAULT);
        itemLocation.selectItemLocationOptions(ITEMS_WITHIN);
        itemLocation.fillWithInMiles(MILES_100);
        itemLocation.fillWithPostalCode("0020188");
        itemLocation.selectItemLocationOptions(US_ONLY);
        itemLocation.selectItemLocationOptions(NORTH_AMERICA);
        itemLocation.selectItemLocationOptions(WORLDWIDE);
        itemLocation.selectItemLocationOptions(LOCATED_IN);
        itemLocation.fillLocatedIn(SWITZERLAND);
        itemLocation.selectItemLocationOptions(AVAILABLE_TO);
        itemLocation.fillAvailable(AFGHANISTAN);

        Sellers sellers = advancedSearchPage.getSellers();
        sellers.selectEbaySellersOption();
        sellers.selectSavedSellersOption();
        sellers.selectSpecificSellersOption(true,"123520");

        ViewResultsControl viewResultsControl = advancedSearchPage.getViewResultsControl();
        viewResultsControl.selectSortByOption(BEST_MATCH);
        viewResultsControl.selectViewOption(GALLERY_VIEW);
        viewResultsControl.selectPerPageOption(PER_PAGE_120);

//        SearchControl searchControl = advancedSearchPage.getSearchControl();
//        searchControl.clearOptions();
//        searchControl.search();
    }
}

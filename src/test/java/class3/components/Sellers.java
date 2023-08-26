package class3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Sellers extends BaseComponent {

    private By SELECT_SELLER = By.id("s0-1-17-7[8]-_fss");
    private By SPECIFIC_SELLERS = By.id("s0-1-17-7[8]-LH_SpecificSeller");
    private By INCLUDE_SELECT = By.id("s0-1-17-7[8]-7[0[@adv-seller]]-_saslop");
    private By SELLER_ID = By.id("s0-1-17-7[8]-_sasl");
    private By EBAY_SELLERS = By.id("s0-1-17-7[8]-LH_SellerWithStore");
    private By SAVED_SELLERS = By.id("s0-1-17-7[8]-LH_FavSellers");

    private WebElement selectSeller;
    private WebElement specificSeller;
    private WebElement includeSelect;
    private WebElement sellerId;
    private WebElement ebaySeller;
    private WebElement savedSeller;

    public Sellers(WebDriver driver) {
        super(driver);
        componentInit();
    }

    private void componentInit() {
        this.specificSeller = waitToLoadComponent(SPECIFIC_SELLERS);
        this.ebaySeller = waitToLoadComponent(EBAY_SELLERS);
        this.savedSeller = waitToLoadComponent(SAVED_SELLERS);
        this.includeSelect = waitToLoadComponent(INCLUDE_SELECT);
        this.sellerId = waitToLoadComponent(SELLER_ID);
        this.selectSeller = waitToLoadComponent(SELECT_SELLER);
    }

    public void selectSpecificSellersOption(boolean isInclude, String sellerId) {
        specificSeller.click();
        Select select = new Select(includeSelect);
        if (isInclude)
            select.selectByVisibleText("Include");
        else
            select.selectByVisibleText("Exclude");
        this.sellerId.sendKeys(sellerId);
    }

    public void selectEbaySellersOption() {
        ebaySeller.click();
    }

    public void selectSavedSellersOption() {
        savedSeller.click();
    }

    public void deSelectSeller() {
        if (selectSeller.isSelected())
            selectSeller.click();
    }

}

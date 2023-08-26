package class3.components;

import class3.entity.Country;
import class3.entity.ItemLocationOptions;
import class3.entity.LocationByMiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ItemLocation extends BaseComponent {

    private By MILES = By.id("s0-1-17-6[7]-4[@field[]]-2-_sadis");
    private By POSTAL_CODE = By.id("s0-1-17-6[7]-4[@field[]]-3-_stpos");
    private By LOCATED_IN = By.id("s0-1-17-6[7]-5[@field[]]-_salic");
    private By AVAILABLE_TO = By.id("s0-1-17-6[7]-5[@field[]]_1-_saact");
    private WebElement miles;
    private WebElement postalCode;
    private WebElement locatedIn;
    private WebElement availableTo;

    public ItemLocation(WebDriver driver) {
        super(driver);
        componentInit();
    }

    private void componentInit() {
        this.miles = waitToLoadComponent(MILES);
        this.postalCode = waitToLoadComponent(POSTAL_CODE);
        this.locatedIn = waitToLoadComponent(LOCATED_IN);
        this.availableTo = waitToLoadComponent(AVAILABLE_TO);
    }

    public void selectItemLocationOptions(ItemLocationOptions toCheck) {
        By OptionToCheck = By.id(toCheck.getId());
        WebElement checkbox = waitToLoadComponent(OptionToCheck);
        checkbox.click();
    }

    public void fillWithInMiles(LocationByMiles miles) {
        Select select = new Select(this.miles);
        select.selectByVisibleText(miles.getValue());
    }

    public void fillWithPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
    }

    public void fillLocatedIn(Country country) {
        Select select = new Select(this.locatedIn);
        select.selectByVisibleText(country.getValue());
    }

    public void fillAvailable(Country country) {
        Select select = new Select(this.availableTo);
        select.selectByVisibleText(country.getValue());
    }
}

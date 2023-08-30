package class5.summarySeleniumExe.logic.pages;

import class5.summarySeleniumExe.logic.components.CreateRestaurantPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestaurantListPage extends BasePage {

    //locators
    private final By BUTTON_CREATE = By.xpath("//button[text() = 'Create new']");
    private final By BUTTON_CONFIRM = By.xpath("(//button[text() = 'OK'])[1]");

    //web elements
    private WebElement createBtn;
    private WebElement deleteBtn;
    private WebElement confirmBtn;

    public RestaurantListPage(WebDriver driver) {
        super(driver);
        initPage();
    }

    private void initPage() {
        createBtn = waitToLoad(BUTTON_CREATE);
    }

    public void createNewRestaurant(String id, String name, String address, String score) {
        createBtn.click();
        CreateRestaurantPopUp createRestaurantPopUp = new CreateRestaurantPopUp(getDriver());
        createRestaurantPopUp.createRestaurantProcess(id, name, address, score);
        confirmBtn = waitToLoad(BUTTON_CONFIRM);
        confirmBtn.click();
    }

    public void closePopUp() {
        CreateRestaurantPopUp createRestaurantPopUp = new CreateRestaurantPopUp(getDriver());
        createRestaurantPopUp.closePopUp();
    }

    public boolean deleteRestaurant(String id) {
        By BUTTON_DELETE = By.xpath(String.format("//td[text() = '%s']//..//button", id));
        deleteBtn = waitToLoad(BUTTON_DELETE);
        deleteBtn.click();
        confirmBtn = waitToLoad(BUTTON_CONFIRM);
        confirmBtn.click();
        return waitToDelete(BUTTON_DELETE);
    }

    public boolean findRestaurantInPage(String id, String name, String address, String score) {
        By RESTAURANT_ROW = By.xpath(String.format("//tr[td[text()= '%s'] and td[text()= '%s'] and td[text()= '%s'] and td[text()= '%s']]", id, name, address, score));
        try {
            WebElement restaurantRow = waitToLoad(RESTAURANT_ROW);
            return true;
        }catch (NoSuchElementException e){
            System.out.println("NoSuchElementException: " + e.getMessage());
            return false;
        }
    }
}

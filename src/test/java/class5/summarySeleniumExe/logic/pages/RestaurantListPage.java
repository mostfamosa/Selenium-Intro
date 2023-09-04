package class5.summarySeleniumExe.logic.pages;

import class5.summarySeleniumExe.logic.components.AlertPopUp;
import class5.summarySeleniumExe.logic.components.CreateRestaurantPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestaurantListPage extends BasePage {

    //locators
    private final By BUTTON_CREATE = By.xpath("//button[text() = 'Create new']");

    //web elements
    private WebElement createBtn;
    private WebElement deleteBtn;

    //popup
    private AlertPopUp alertPopUp;
    public RestaurantListPage(WebDriver driver) {
        super(driver);
        initPage();
    }

    private void initPage() {
        createBtn = waitToLoad(BUTTON_CREATE);
        alertPopUp = new AlertPopUp(driver);
    }

    public void createNewRestaurant(String id, String name, String address, String score) {
        createBtn.click();
        CreateRestaurantPopUp createRestaurantPopUp = new CreateRestaurantPopUp(getDriver());
        createRestaurantPopUp.createRestaurantProcess(id, name, address, score);
    }

    public void closePopUp() {
        CreateRestaurantPopUp createRestaurantPopUp = new CreateRestaurantPopUp(getDriver());
        createRestaurantPopUp.closeCreateRestaurantPopUp();
    }

    public boolean deleteRestaurant(String id) {
        By BUTTON_DELETE = By.xpath(String.format("//td[text() = '%s']//..//button", id));
        deleteBtn = waitToLoad(BUTTON_DELETE);
        deleteBtn.click();
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

    public AlertPopUp getAlertPopUp() {
        return alertPopUp;
    }
}

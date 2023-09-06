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
    private final String RESTAURANT_ROW_LOCATOR = "//tr[td[text()= '%s'] and td[text()= '%s'] and td[text()= '%s'] and td[text()= '%s']]";
    private final String BUTTON_DELETE_LOCATOR = "//td[text() = '%d']//..//button";

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
        createBtn = waitToVisible(BUTTON_CREATE);
        alertPopUp = new AlertPopUp(driver);
    }

    public void createNewRestaurant(int id, String name, String address, double score) {
        createBtn.click();
        CreateRestaurantPopUp createRestaurantPopUp = new CreateRestaurantPopUp(this.driver);
        createRestaurantPopUp.createRestaurantProcess(id, name, address, score);
    }

    public void closePopUp() {
        CreateRestaurantPopUp createRestaurantPopUp = new CreateRestaurantPopUp(this.driver);
        createRestaurantPopUp.closeCreateRestaurantPopUp();
    }

    public void deleteRestaurant(int id) {
        By BUTTON_DELETE = By.xpath(String.format(BUTTON_DELETE_LOCATOR, id));
        deleteBtn = waitToVisible(BUTTON_DELETE);
        deleteBtn.click();
    }

    public boolean findRestaurantInPage(int id, String name, String address, double score) {
        By RESTAURANT_ROW = By.xpath(String.format(RESTAURANT_ROW_LOCATOR, id, name, address, score));
        try {
            waitToVisible(RESTAURANT_ROW);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage());
            return false;
        }
    }

    public AlertPopUp getAlertPopUp() {
        return alertPopUp;
    }
}

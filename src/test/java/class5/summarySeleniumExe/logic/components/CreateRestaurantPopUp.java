package class5.summarySeleniumExe.logic.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateRestaurantPopUp extends BaseComponent {

    //locators
    private final By INPUT_ID = By.id("id");
    private final By INPUT_NAME = By.id("name");
    private final By INPUT_ADDRESS = By.id("address");
    private final By INPUT_SCORE = By.id("score");
    private final By BUTTON_CLOSE = By.id("close-button");
    private final By BUTTON_SUBMIT = By.xpath("//button[text() = 'Submit']");

    //web elements
    private WebElement idInput;
    private WebElement nameInput;
    private WebElement addressInput;
    private WebElement scoreInput;
    private WebElement closeBtn;
    private WebElement submitBtn;

    public CreateRestaurantPopUp(WebDriver driver) {
        super(driver);
        initPage();
    }

    private void initPage() {
        idInput = waitToLoad(INPUT_ID);
        nameInput = waitToLoad(INPUT_NAME);
        addressInput = waitToLoad(INPUT_ADDRESS);
        scoreInput = waitToLoad(INPUT_SCORE);
        closeBtn = waitToLoad(BUTTON_CLOSE);
        submitBtn = waitToLoad(BUTTON_SUBMIT);
    }

    public void closePopUp() {
        closeBtn.click();
    }

    private void submit() {
        submitBtn.click();
    }

    private void insertId(String id) {
        idInput.sendKeys(id);
    }

    private void insertName(String name) {
        nameInput.sendKeys(name);
    }

    private void insertAddress(String address) {
        addressInput.sendKeys(address);
    }

    private void insertScore(String score) {
        scoreInput.sendKeys(score);
    }

    private void clearInputs() {
        idInput.clear();
        nameInput.clear();
        addressInput.clear();
        scoreInput.clear();
    }

    public void createRestaurantProcess(String id, String name, String address, String score) {
        clearInputs();
        insertId(id);
        insertName(name);
        insertAddress(address);
        insertScore(score);
        submit();
    }

}

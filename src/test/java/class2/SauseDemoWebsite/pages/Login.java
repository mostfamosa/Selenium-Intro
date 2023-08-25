package class2.SauseDemoWebsite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    protected WebDriver driver;
    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MSG = By.xpath("//h3[@data-test='error']");


    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginBtn;
    private WebElement errorMsg;

    public Login(WebDriver driver) {
        this.driver = driver;
        this.initPage();
    }

    public void initPage() {
        usernameInput = waitToLoad(USERNAME_INPUT);
        passwordInput = waitToLoad(PASSWORD_INPUT);
        loginBtn = waitToLoad(LOGIN_BUTTON);
    }

    public void fullLoginProcess(String userName, String password) {
        this.fillUserName(userName);
        this.fillPassword(password);
        this.clickOnSubmit();
    }

    public void fillUserName(String userName) {
        this.usernameInput.sendKeys(userName);
    }

    public void fillPassword(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickOnSubmit() {
        this.loginBtn.click();
    }

    public String getErrorMsg() {
        errorMsg = waitToLoad(ERROR_MSG);
        return errorMsg.getText();
    }

    private WebElement waitToLoad(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

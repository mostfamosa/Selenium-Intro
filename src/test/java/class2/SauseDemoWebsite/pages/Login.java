package class2.SauseDemoWebsite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    protected WebDriver driver;
    private final String USERNAME_INPUT = "user-name";
    private final String PASSWORD_INPUT = "password";
    private final String LOGIN_BUTTON = "login-button";
    private final String ERROR_MSG = "//h3[@data-test='error']";


    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginBtn;
    private WebElement errorMsg;

    public Login(WebDriver driver) {
        this.driver = driver;
        this.initPage();
    }

    public void initPage() {
        usernameInput = this.driver.findElement(By.id(USERNAME_INPUT));
        passwordInput = this.driver.findElement(By.id(PASSWORD_INPUT));
        loginBtn = this.driver.findElement(By.id(LOGIN_BUTTON));
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

    public String getErrorMsg(){
        errorMsg = this.driver.findElement(By.xpath(ERROR_MSG));
        return errorMsg.getText();
    }
}

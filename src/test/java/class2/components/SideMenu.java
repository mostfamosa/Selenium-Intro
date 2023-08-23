package class2.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideMenu {
    protected WebDriver driver;

    private final static String BUTTON_MENU = "//button[@id='react-burger-menu-btn']";
    private final static String BUTTON_CLOSE_MENU = "//button[@id='react-burger-cross-btn']";

    private final static String SIDEBAR_INVENTORY = "inventory_sidebar_link";
    private final static String SIDEBAR_ABOUT = "about_sidebar_link";
    private final static String SIDEBAR_LOGOUT = "logout_sidebar_link";
    private final static String SIDEBAR_RESET = "reset_sidebar_link";

    private WebElement menu;
    private WebElement closeMenu;
    private WebElement linkInventory;
    private WebElement linkAbout;
    private WebElement linkLogout;
    private WebElement linkReset;


    public SideMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void openSideMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_MENU)));
        menu.click();
    }

    public void closeSideMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        closeMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_CLOSE_MENU)));
        this.closeMenu.click();
    }

    public void goToAllItems() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        linkInventory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SIDEBAR_INVENTORY)));
        this.linkInventory.click();
    }

    public void goToAbout() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        linkAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SIDEBAR_ABOUT)));
        this.linkAbout.click();
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        linkLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SIDEBAR_LOGOUT)));
        this.linkLogout.click();
    }

    public void reset() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        linkReset = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SIDEBAR_RESET)));
        this.linkReset.click();
    }

}

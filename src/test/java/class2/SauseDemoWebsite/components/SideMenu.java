package class2.SauseDemoWebsite.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends BaseComponent {
    private final static By BUTTON_MENU = By.xpath("//button[@id='react-burger-menu-btn']");
    private final static By BUTTON_CLOSE_MENU = By.xpath("//button[@id='react-burger-cross-btn']");
    private final static By SIDEBAR_INVENTORY = By.id("inventory_sidebar_link");
    private final static By SIDEBAR_ABOUT = By.id("about_sidebar_link");
    private final static By SIDEBAR_LOGOUT = By.id("logout_sidebar_link");
    private final static By SIDEBAR_RESET = By.id("reset_sidebar_link");

    private WebElement openMenu;
    private WebElement closeMenu;
    private WebElement linkInventory;
    private WebElement linkAbout;
    private WebElement linkLogout;
    private WebElement linkReset;

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    public void openSideMenu() {
        openMenu = waitToLoadComponent(BUTTON_MENU);
        openMenu.click();
    }

    public void closeSideMenu() {
        closeMenu = waitToLoadComponent(BUTTON_CLOSE_MENU);
        this.closeMenu.click();
    }

    public void goToAllItems() {
        linkInventory = waitToLoadComponent(SIDEBAR_INVENTORY);
        this.linkInventory.click();
    }

    public void goToAbout() {
        linkAbout = waitToLoadComponent(SIDEBAR_ABOUT);
        this.linkAbout.click();
    }

    public void logout() {
        linkLogout = waitToLoadComponent(SIDEBAR_LOGOUT);
        this.linkLogout.click();
    }

    public void reset() {
        linkReset = waitToLoadComponent(SIDEBAR_RESET);
        this.linkReset.click();
    }
}

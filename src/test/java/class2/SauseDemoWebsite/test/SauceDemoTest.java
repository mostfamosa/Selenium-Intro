package class2.SauseDemoWebsite.test;

import class2.SauseDemoWebsite.components.SideMenu;
import class2.SauseDemoWebsite.pages.Login;
import class2.SauseDemoWebsite.pages.Main;
import class2.SauseDemoWebsite.pages.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class SauceDemoTest {

    public WebDriver driver;

    private Login loginPage;
    private Main mainPage;
    private ShoppingCart shoppingCartPage;

    private String userName;
    private String password;

    @BeforeEach
    void setUp() {
        userName = "standard_user";
        password = "secret_sauce";

        System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());
        driver = new ChromeDriver();
        driver.get("http://www.saucedemo.com");
        //Arrange
        loginPage = new Login(driver);
    }

    @Test
    public void login_Standard_User_Validation() {
        //user login to the site with max attempts = 5
        loadMainPage(5);
        //Assert
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void login_Failed_Inputs_Empty() {
        loginPage.clickOnSubmit();
        String errorMsg = loginPage.getErrorMsg();
        //Assert
        assertEquals("Epic sadface: Username is required", errorMsg);
    }

    @Test
    public void login_Failed_UserName_Empty() {
        this.userName = "";
        this.password = "ABC";
        loginPage.fullLoginProcess(userName,password);
        String errorMsg = loginPage.getErrorMsg();
        //Assert
        assertEquals("Epic sadface: Username is required", errorMsg);
    }

    @Test
    public void login_Failed_Password_Empty() {
        this.userName = "abc";
        this.password = "";
        loginPage.fullLoginProcess(userName,password);
        String errorMsg = loginPage.getErrorMsg();
        //Assert
        assertEquals("Epic sadface: Password is required", errorMsg);
    }

    @Test
    public void login_Failed_Wrong_User_And_Password() {
        this.userName = "abc";
        this.password = "ABC";
        loginPage.fullLoginProcess(userName,password);
        String errorMsg = loginPage.getErrorMsg();
        //Assert
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMsg);
    }

    @Test
    public void login_Standard_User_Then_Logout_Validation() {
        //Act
        //user login to the site with max attempts = 5
        loadMainPage(5);
        mainPage = new Main(driver);
        mainPage.getSideMenu().openSideMenu();
        mainPage.getSideMenu().logout();

        //Assert
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @Test
    public void side_Menu_About_Link_Validation() {
        //Act
        //user login to the site with max attempts = 5
        loadMainPage(5);
        mainPage = new Main(driver);
        SideMenu sideMenu = mainPage.getSideMenu();
        sideMenu.openSideMenu();
        sideMenu.goToAbout();

        //Assert
        assertEquals("https://saucelabs.com/", driver.getCurrentUrl());
    }

    @Test
    public void side_Menu_All_Items_Link_Validation() {
        //Act
        //user login to the site with max attempts = 5
        loadMainPage(5);
        mainPage = new Main(driver);
        //go to the cart page with max attempts = 5
        loadCartPage(5);
        shoppingCartPage = new ShoppingCart(driver);
        SideMenu sideMenu = shoppingCartPage.getSideMenu();
        sideMenu.openSideMenu();
        sideMenu.goToAllItems();

        //Assert
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void side_Menu_Logout_Link_Validation() {
        //Act
        //user login to the site with max attempts = 5
        loadMainPage(5);
        mainPage = new Main(driver);
        SideMenu sideMenu = mainPage.getSideMenu();
        sideMenu.openSideMenu();
        sideMenu.logout();

        //Assert
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @Test
    public void add_Two_Items_To_Cart_And_Validate() {
        //Act
        //user login to the site with max attempts = 5
        loadMainPage(5);
        mainPage = new Main(driver);
        mainPage.addItemToCart();
        mainPage.addItemToCart();
        //go to the cart page with max attempts = 5
        loadCartPage(5);
        shoppingCartPage = new ShoppingCart(driver);
        int itemsInCart = shoppingCartPage.getCartQuantity();

        //Assert
        assertEquals(2, itemsInCart, "The number of items in the cart is not equal to 2!");
    }

    @Test
    public void add_Three_Items_To_Cart_And_Remove_Item_Then_Validate() {
        //Act
        //user login to the site with max attempts = 5
        loadMainPage(5);
        mainPage = new Main(driver);
        mainPage.addItemToCart();
        mainPage.addItemToCart();
        mainPage.addItemToCart();

        //go to the cart page with max attempts = 5
        loadCartPage(5);

        shoppingCartPage = new ShoppingCart(driver);
        shoppingCartPage.removeItemfromCart();
        int itemsInCart = shoppingCartPage.getCartQuantity();

        //Assert
        assertEquals(2, itemsInCart, "The number of items in the cart is not equal to 2!");
    }

    @Test
    public void add_Items_Then_Remove_It_Then_Validate_Card() {
        //Act
        //user login to the site with max attempts = 5
        loadMainPage(5);
        mainPage = new Main(driver);
        mainPage.addItemToCart();
        //go to the cart page with max attempts = 5
        loadCartPage(5);
        shoppingCartPage = new ShoppingCart(driver);
        shoppingCartPage.removeItemfromCart();
        int itemsInCart = shoppingCartPage.getCartQuantity();

        //Assert
        assertEquals(0, itemsInCart, "The number of items in the cart is not equal to 0!");
    }

    @AfterEach
    void clear() {
        driver.close();
    }

    private void loadMainPage(int maxAttempts) {
        int loginAttempts = 0;
        //make sure the user login to the site and in the main page loaded
        while (!Objects.equals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html")) {
            if (loginAttempts != maxAttempts)
                loginPage.fullLoginProcess(userName, password);
            else {
                throw new RuntimeException("Failed To Login (Max Attempts Reached)!");
            }
            loginAttempts++;
        }
    }

    private void loadCartPage(int maxAttempts) {
        int goCartAttempts = 0;
        //make sure the cart page loaded
        while (!Objects.equals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html")) {
            if (goCartAttempts != maxAttempts)
                mainPage.getHeader().goToCart();
            else {
                throw new RuntimeException("Failed To go To Cart Page (Max Attempts Reached)!");
            }
            goCartAttempts++;
        }
    }
}

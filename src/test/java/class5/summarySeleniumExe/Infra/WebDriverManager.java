package class5.summarySeleniumExe.Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

public class WebDriverManager {
    protected static WebDriver driver;

    public WebDriverManager() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set the path to the chromedriver executable
            System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());

            // Initialize the WebDriver
            driver = new ChromeDriver();
            driver.get("https://testomate-test.web.app/home");
        }
        return driver;
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}

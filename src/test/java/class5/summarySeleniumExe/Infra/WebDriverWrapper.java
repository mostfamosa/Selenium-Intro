package class5.summarySeleniumExe.Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

public class WebDriverWrapper {
    protected WebDriver driver;

    public WebDriverWrapper() {

    }

    public WebDriver getDriver() {
        if (driver == null) {
            // Set the path to the chromedriver executable
            System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());

            // Initialize the WebDriver
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}

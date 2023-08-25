package class3.page;

import class3.components.Keywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

public class AdvancedSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
        Keywords keywords = new Keywords(driver);
        keywords.searchByKeyword("hi","lol","Any words, any order","Books & Magazines");
    }
}

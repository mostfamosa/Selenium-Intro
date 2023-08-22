package class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiSearchExe {
    public static void main(String[] args) {
        wikiSearch("Aardvark", "bear");
        wikiSearch("Lion", "king");
    }

    public static void wikiSearch(String searchInput, String inputToCount) {
        System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.wikipedia.org");

        //find the searchBar and add the input to search
        WebElement searchBar = driver.findElement(By.id("searchInput"));
        searchBar.sendKeys(searchInput);

        //find the search button and click it
        WebElement button = driver.findElement(By.xpath("//form[@id='search-form']//button[@type='submit']"));
        button.click();

        //get all the body content and save it in a string
        String pageText = driver.findElement(By.tagName("body")).getText();
        driver.close();

        //count and print how many the word appeared
        int count = countWordOccurrences(pageText, inputToCount);
        System.out.println("The word \"" + inputToCount + "\" appears " + count + " times.");

    }


    // Method to count occurrences of a word in a text
    public static int countWordOccurrences(String text, String word) {
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);//
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
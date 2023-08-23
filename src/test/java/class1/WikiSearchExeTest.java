package class1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;

import java.util.stream.Stream;

import static class1.WikiSearchExe.countWordOccurrences;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikiSearchExeTest {

    public ChromeDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());
        driver = new ChromeDriver();
    }

    @ParameterizedTest
    @MethodSource("getInputs")
    void search_Word_And_Count_In_Wikipedia(String searchInput, String inputToCount, int expectedResult){

        driver.get("http://www.wikipedia.org");

        //find the searchBar and add the input to search
        WebElement searchBar = driver.findElement(By.id("searchInput"));
        searchBar.sendKeys(searchInput);

        //find the search button and click it
        WebElement button = driver.findElement(By.xpath("//form[@id='search-form']//button[@type='submit']"));
        button.click();

        //get all the body content and save it in a string
        String pageText = driver.findElement(By.tagName("body")).getText();

        //count and print how many the word appeared
        int count = countWordOccurrences(pageText, inputToCount);
        System.out.println("The word \"" + inputToCount + "\" appears " + count + " times.");

        //assert
        assertEquals(expectedResult, count, "Expected count is "+expectedResult);

    }

    private static Stream<Arguments> getInputs() {
        return Stream.of(
                Arguments.of("Aardvark", "bear",4),
                Arguments.of("Lion", "king",29)
        );
    }

    @AfterEach
    void after(){
        driver.close();
    }

}

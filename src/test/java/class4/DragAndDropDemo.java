package class4;

import class4.page.DragAndDropPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Drivers;
import static class4.entity.DragAndDeleteOptions.*;

public class DragAndDropDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Drivers.getChromeDriver());
        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/ovvn/full/Nqxzjg");

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        dragAndDropPage.addDetails("Hi Moose!");
        dragAndDropPage.dragAndDrop(TEXT);
        dragAndDropPage.dragAndDrop(TEXT);
        dragAndDropPage.dragAndDrop(TEXTAREA);
        dragAndDropPage.dragAndDrop(NUMBER);
        dragAndDropPage.dragAndDrop(NUMBER);

        dragAndDropPage.clickOnTrash(NUMBER);
        dragAndDropPage.clickOnTrash(TEXT);
        dragAndDropPage.clickOnTrash(TEXTAREA);

    }
}

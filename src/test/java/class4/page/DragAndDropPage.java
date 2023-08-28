package class4.page;

import class4.entity.DragAndDeleteOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage {
    protected WebDriver driver;

    //locators
    private By DRAGGABLE_TEXT = By.xpath("//div[@id='modules']//a[text()='Text']/..");
    private By DRAGGABLE_TEXTAREA = By.xpath("//a[text() = 'Textarea']");
    private By DRAGGABLE_NUMBER = By.xpath("//a[text() = 'Number']");
    private By INPUT_DETAILS = By.xpath("//input[@name='blah']");
    private By BUTTON_DETAILS = By.xpath("//details");
    private By DROP_ZONE = By.id("dropzone");

    //web elements 
    private WebElement textToDrag;
    private WebElement textAreaToDrag;
    private WebElement numberToDrag;
    private WebElement trashCan;
    private WebElement detailsInput;
    private WebElement detailsButton;
    private WebElement dropZone;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        driver.switchTo().frame("result");
        initPage();
    }

    private void initPage() {
        textToDrag = waitToClickComponent(DRAGGABLE_TEXT);
        textAreaToDrag = waitToLoadComponent(DRAGGABLE_TEXTAREA);
        numberToDrag = waitToLoadComponent(DRAGGABLE_NUMBER);
        detailsButton = waitToClickComponent(BUTTON_DETAILS);
        dropZone = waitToLoadComponent(DROP_ZONE);
    }

    public void clickOnTrash(DragAndDeleteOptions toDelete) {
        By BUTTON_REMOVE = null;
        switch (toDelete) {
            case TEXT ->
                    BUTTON_REMOVE = By.xpath("//summary[text()='Text']/../..//button");
            case TEXTAREA ->
                    BUTTON_REMOVE = By.xpath("//summary[text()='Textarea']/../..//button");
            case NUMBER ->
                    BUTTON_REMOVE = By.xpath("//summary[text()='Number']/../..//button");
        }
        trashCan = waitToLoadComponent(BUTTON_REMOVE);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", trashCan);
    }

    public void addDetails(String detailInput) {
        this.detailsInput = waitToLoadComponent(INPUT_DETAILS);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].open = true", detailsButton);
        jsExecutor.executeScript("arguments[0].value=arguments[1];", detailsInput, detailInput);
    }

    public void dragAndDrop(DragAndDeleteOptions toDrag) {
        WebElement dragElement = null;
        switch (toDrag) {
            case TEXT -> dragElement = textToDrag;
            case TEXTAREA -> dragElement = textAreaToDrag;
            case NUMBER -> dragElement = numberToDrag;
        }
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "// Create the outer div element with class \"dropitem\"\n" +
                        "var outerDiv = document.createElement(\"div\");\n" +
                        "outerDiv.className = \"drop-item\";\n" +
                        "\n" +
                        "// Create the details element\n" +
                        "var details = document.createElement(\"details\");\n" +
                        "\n" +
                        "// Create the summary element inside details\n" +
                        "var summary = document.createElement(\"summary\");\n" +
                        "summary.textContent = arguments[1].textContent;\n" +
                        "details.appendChild(summary);\n" +
                        "\n" +
                        "// Create the div element inside details\n" +
                        "var innerDiv = document.createElement(\"div\");\n" +
                        "\n" +
                        "// Create the label element inside the div\n" +
                        "var label = document.createElement(\"label\");\n" +
                        "label.textContent = \"More Data\";\n" +
                        "innerDiv.appendChild(label);\n" +
                        "\n" +
                        "// Create the input element inside the div\n" +
                        "var input = document.createElement(\"input\");\n" +
                        "input.type = \"text\";\n" +
                        "innerDiv.appendChild(input);\n" +
                        "\n" +
                        "// Append the inner div to the details\n" +
                        "details.appendChild(innerDiv);\n" +
                        "\n" +
                        "// Create the button element\n" +
                        "var button = document.createElement(\"button\");\n" +
                        "button.type = \"button\";\n" +
                        "button.className = \"btn btn-default btn-xs remove\";\n" +
                        "button.addEventListener(\"click\", function() {\n" +
                        "    // Handle button click here\n" +
                        "    outerDiv.remove(); // Remove the entire \"dropitem\" div\n" +
                        "});\n" +
                        "\n" +
                        "// Create the span element inside the button\n" +
                        "var span = document.createElement(\"span\");\n" +
                        "span.className = \"glyphicon glyphicon-trash\";\n" +
                        "button.appendChild(span);\n" +
                        "\n" +
                        "// Append the details and button elements to the outer div\n" +
                        "outerDiv.appendChild(details);\n" +
                        "outerDiv.appendChild(button);\n" +
                        "\n" +
                        "// Get the dropzone element by ID\n" +
                        "var dropzone = arguments[0];\n" +
                        "\n" +
                        "// Append the outer div to the dropzone element\n" +
                        "if (dropzone) {\n" +
                        "    dropzone.appendChild(outerDiv);\n" +
                        "} else {\n" +
                        "    console.error(\"Dropzone element not found.\");\n" +
                        "}", dropZone, dragElement);

    }

    public WebElement waitToLoadComponent(By locator) {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitToClickComponent(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}

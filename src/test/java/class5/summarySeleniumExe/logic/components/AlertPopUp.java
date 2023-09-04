package class5.summarySeleniumExe.logic.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertPopUp extends BaseComponent{

    // Locators
    private final By ALERT_POPUP_MSG = By.xpath("//div[@id = 'alert-popup']//h2");
    private final By ALERT_POPUP_BUTTON = By.xpath("//div[@id = 'alert-popup']//button");

    // Web Elements
    private WebElement alertMsg;
    private WebElement alertBtn;

    public AlertPopUp(WebDriver driver) {
        super(driver);
    }

    public void clickOnConfirmAlertBtn(){
        alertBtn = waitToLoad(ALERT_POPUP_BUTTON);
        alertBtn.click();
    }

    public String getAlertMsg(){
        alertMsg = waitToLoad(ALERT_POPUP_MSG);
        return alertMsg.getText();
    }

}

package class2.SauseDemoWebsite.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {
    protected WebDriver driver;

    private final static String LINK_TWITTER = "//li[@class='social_twitter']//a";
    private final static String LINK_FACEBOOK = "//li[@class='social_facebook']//a";
    private final static String LINK_LINKEDIN = "//li[@class='social_linkedin']//a";
    private final static String LABEL_COPYRIGHTS = "//div[@class='footer_copy']";

    private WebElement twitter;
    private WebElement facebook;
    private WebElement linkedIn;
    private WebElement copyRights;

    public Footer(WebDriver driver) {
        this.driver = driver;
        this.initComponent();
    }

    private void initComponent() {
        twitter = driver.findElement(By.xpath(LINK_TWITTER));
        facebook = driver.findElement(By.xpath(LINK_FACEBOOK));
        linkedIn = driver.findElement(By.xpath(LINK_LINKEDIN));
        copyRights = driver.findElement(By.xpath(LABEL_COPYRIGHTS));
    }

    public void goToTwitter() {
        this.twitter.click();
    }
    public void goToFacebook() {
        this.facebook.click();
    }
    public void goToLinkedIn() {
        this.linkedIn.click();
    }
    public void getCopyRightText() {
        this.copyRights.getText();
    }


}

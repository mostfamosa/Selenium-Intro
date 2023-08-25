package class2.SauseDemoWebsite.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer extends BaseComponent {
    private final static By LINK_TWITTER = By.xpath("//li[@class='social_twitter']//a");
    private final static By LINK_FACEBOOK = By.xpath("//li[@class='social_facebook']//a");
    private final static By LINK_LINKEDIN = By.xpath("//li[@class='social_linkedin']//a");
    private final static By LABEL_COPYRIGHTS = By.xpath("//div[@class='footer_copy']");

    private WebElement twitter;
    private WebElement facebook;
    private WebElement linkedIn;
    private WebElement copyRights;

    public Footer(WebDriver driver) {
        super(driver);
        this.initComponent();
    }

    private void initComponent() {
        twitter = waitToLoadComponent(LINK_TWITTER);
        facebook = waitToLoadComponent(LINK_FACEBOOK);
        linkedIn = waitToLoadComponent(LINK_LINKEDIN);
        copyRights = waitToLoadComponent(LABEL_COPYRIGHTS);
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

package com.retail.ui.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.retail.ui.automation.base.BaseTest;
import com.retail.ui.automation.india.stores.pages.AppleBKC;
import com.retail.ui.automation.india.stores.pages.AppleHebbal;
import com.retail.ui.automation.india.stores.pages.AppleKoregaonPark;
import com.retail.ui.automation.utils.TestUtils;
import com.retail.ui.automation.utils.WaitUtils;

public class LandingPageIndia extends BaseTest {
	private WebDriver driver;
    private WaitUtils waitUtils;
    private TestUtils testUtils;

    public LandingPageIndia(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.testUtils = new TestUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Find a store")
    private WebElement findAStoreLink;

    @FindBy(xpath = "//input[@type='text' and @class='form-textbox-input']")
    private WebElement searchBar;

    @FindBy(xpath = "//span[@class='form-icons form-icons-search19']")
    private WebElement magnifyingIcon;

    @FindBy(linkText = "Complete store list")
    private WebElement completeStoreList;

    @FindBy(xpath = "//h2[@class='headline']")
    private WebElement pageHeadline;

    @FindBy(xpath = "//h3[text()='Apple Koregaon Park']")
    private WebElement storeCardAppleKoregaonPark;

    @FindBy(xpath = "//h3[text()='Apple Hebbal']")
    private WebElement storeCardAppleHebbal;

    @FindBy(xpath = "//h3[text()='Apple BKC']")
    private WebElement storeCardAppleBKC;

    @FindBy(xpath = "//h2[text()='Come see the best of Apple at our stores.']")
    private WebElement programCardsHeader;

    public String verifyLandingPageTitle() {
        return driver.getTitle();
    }

    public boolean verifyFindAStoreLink() {
        return findAStoreLink.isDisplayed();
    }

    public boolean verifySearchBar() {
        return searchBar.isDisplayed();
    }

    public boolean verifyMagnifyingIconInSearchBar() {
        return magnifyingIcon.isDisplayed();
    }

    public boolean verifyCompleteStoreListLink() {
        return completeStoreList.isDisplayed();
    }

    public boolean verifyHeadline() {
        return pageHeadline.isDisplayed();
    }

    public String verifyHeadlineText() {
        return pageHeadline.getText();
    }

    public boolean verifyStoreCardAppleKoregaonPark() {
        return waitUtils.waitForElementVisible(storeCardAppleKoregaonPark).isDisplayed();
    }

    public boolean verifyStoreCardAppleHebbal() {
        return waitUtils.waitForElementVisible(storeCardAppleHebbal).isDisplayed();
    }

    public boolean verifyStoreCardAppleBKC() {
        return waitUtils.waitForElementVisible(storeCardAppleBKC).isDisplayed();
    }

    public AppleKoregaonPark openAppleKoregaonPark() {
        waitUtils.waitForElementVisible(storeCardAppleKoregaonPark).click();
        return new AppleKoregaonPark(driver);
    }

    public AppleHebbal openAppleHebbal() {
        waitUtils.waitForElementVisible(storeCardAppleHebbal).click();
        return new AppleHebbal(driver);
    }

    public AppleBKC openAppleBKC() {
        waitUtils.waitForElementVisible(storeCardAppleBKC).click();
        return new AppleBKC(driver);
    }

    public boolean verifyProgramCardHeader() {
        return waitUtils.waitForElementVisible(programCardsHeader).isDisplayed();
    }

    public String verifyProgramCardHeaderText() {
        testUtils.scrollToFeatures(programCardsHeader);
        return programCardsHeader.getText();
    }
}

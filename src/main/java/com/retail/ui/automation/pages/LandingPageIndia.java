package com.retail.ui.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.retail.ui.automation.base.BaseTest;
import com.retail.ui.automation.india.stores.pages.AppleBKC;
import com.retail.ui.automation.india.stores.pages.AppleHebbal;
import com.retail.ui.automation.india.stores.pages.AppleKoregaonPark;
import com.retail.ui.automation.utils.TestUtils;
import com.retail.ui.automation.utils.WaitUtils;

public class LandingPageIndia extends BaseTest {

    private WaitUtils waitUtils;
    private TestUtils testUtils;

    public LandingPageIndia() {
        this.waitUtils = new WaitUtils(getDriver());
        this.testUtils = new TestUtils(getDriver());
        PageFactory.initElements(getDriver(), this);
    }
    
    private By findAStoreLink =
            By.linkText("Find a store");
    
    private By searchBar =
            By.xpath("//input[@type='text' and @class='form-textbox-input']");
    
    private By magnifyingIcon =
            By.xpath("//span[@class='form-icons form-icons-search19']");
    
    private By completeStoreList =
            By.linkText("Complete store list");

    private By pageHeadline =
            By.xpath("//h2[@class='headline']");
    
    private By storeCardAppleKoregaonPark =
            By.xpath("//h3[text()='Apple Koregaon Park']");
    
    private By storeCardAppleHebbal =
            By.xpath("//h3[text()='Apple Hebbal']");

    private By storeCardAppleBKC =
            By.xpath("//h3[text()='Apple BKC']");
    
   
    private By programCardsHeader =
            By.xpath("//h2[text()='Come see the best of Apple at our stores.']");
    
    
    public String verifyLandingPageTitle() {
        return getDriver().getTitle();
    }

    public boolean verifyFindAStoreLink() {
        return waitUtils.waitForElementVisible(findAStoreLink).isDisplayed();
    }

    public boolean verifySearchBar() {
        return waitUtils.waitForElementVisible(searchBar).isDisplayed();
    }

    public boolean verifyMagnifyingIconInSearchBar() {
        return waitUtils.waitForElementVisible(magnifyingIcon).isDisplayed();
    }

    public boolean verifyCompleteStoreListLink() {
        return waitUtils.waitForElementVisible(completeStoreList).isDisplayed();
    }

    public boolean verifyHeadline() {
        return waitUtils.waitForElementVisible(pageHeadline).isDisplayed();
    }

    public String verifyHeadlineText() {
        return waitUtils.waitForElementVisible(pageHeadline).getText();
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
        return new AppleKoregaonPark();
    }

    public AppleHebbal openAppleHebbal() {
        waitUtils.waitForElementVisible(storeCardAppleHebbal).click();
        return new AppleHebbal();
    }

    public AppleBKC openAppleBKC() {
        waitUtils.waitForElementVisible(storeCardAppleBKC).click();
        return new AppleBKC();
    }

    public boolean verifyProgramCardHeader() {
        return waitUtils.waitForElementVisible(programCardsHeader).isDisplayed();
    }

    public String verifyProgramCardHeaderText() {
        WebElement header =
                waitUtils.waitForElementVisible(programCardsHeader);
        testUtils.scrollToFeatures(programCardsHeader);
        return header.getText();
    }
}

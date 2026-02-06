package com.retail.ui.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.retail.ui.automation.base.BaseTest;
import com.retail.ui.automation.pages.LandingPageIndia;
import com.retail.ui.automation.utils.test.ExpectedJsonReader;

public class LandingPageIndiaTest extends BaseTest{
	
	private LandingPageIndia landingPageIndia;

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        // BaseTest.setup() is automatically executed
        landingPageIndia = new LandingPageIndia(driver);
    }

    @Test(groups = "smoke")
    public void testPageTitle() {
        Assert.assertEquals(
            landingPageIndia.verifyLandingPageTitle(),
            ExpectedJsonReader.getExpectedValue("landingPageIN", "title")
        );
    }

    @Test(groups = "smoke")
    public void testFindAstoreLink() {
        Assert.assertTrue(landingPageIndia.verifyFindAStoreLink());
    }

    @Test(groups = "smoke")
    public void testSearchBarIsPresent() {
        Assert.assertTrue(landingPageIndia.verifySearchBar());
    }

    @Test(groups = "smoke")
    public void testMagnifyingIconInSearchBar() {
        Assert.assertTrue(landingPageIndia.verifyMagnifyingIconInSearchBar());
    }

    @Test(groups = "smoke")
    public void testCompleteStoreListLink() {
        Assert.assertTrue(landingPageIndia.verifyCompleteStoreListLink());
    }

    @Test(groups = "smoke")
    public void testPageHeadline() {
        Assert.assertTrue(landingPageIndia.verifyHeadline());
    }

    @Test(groups = "smoke")
    public void testPageHeadlineText() {
        Assert.assertEquals(
            landingPageIndia.verifyHeadlineText(),
            ExpectedJsonReader.getExpectedValue("landingPageIN", "headline")
        );
    }

    @Test(groups = "smoke")
    public void testStoreCardAppleKoregaonPark() {
        Assert.assertTrue(landingPageIndia.verifyStoreCardAppleKoregaonPark());
    }

    @Test(groups = "smoke")
    public void testStoreCardAppleHebbal() {
        Assert.assertTrue(landingPageIndia.verifyStoreCardAppleHebbal());
    }

    @Test(groups = "smoke")
    public void testStoreCardAppleBKC() {
        Assert.assertTrue(landingPageIndia.verifyStoreCardAppleBKC());
    }

    @Test(groups = "sanity")
    public void testStoreAppleKoregaonPark() {
        landingPageIndia.openAppleKoregaonPark();
        Assert.assertEquals(
            driver.getTitle(),
            ExpectedJsonReader.getExpectedValue("landingPageIN", "appleKoregaonParkPageTitle")
        );
    }

    @Test(groups = "sanity")
    public void testStoreAppleHebbal() {
        landingPageIndia.openAppleHebbal();
        Assert.assertEquals(
            driver.getTitle(),
            ExpectedJsonReader.getExpectedValue("landingPageIN", "appleHebbalPageTitle")
        );
    }

    @Test(groups = "sanity")
    public void testStoreAppleBKC() {
        landingPageIndia.openAppleBKC();
        Assert.assertEquals(
            driver.getTitle(),
            ExpectedJsonReader.getExpectedValue("landingPageIN", "appleBKCPageTitle")
        );
    }

    @Test(groups = "smoke")
    public void testProgramCardHeaderIsPresent() {
        Assert.assertTrue(landingPageIndia.verifyProgramCardHeader());
    }

    @Test(groups = "smoke")
    public void testProgramCardHeaderText() {
        Assert.assertEquals(
            landingPageIndia.verifyProgramCardHeaderText(),
            ExpectedJsonReader.getExpectedValue("landingPageIN", "programCardSecHeader")
        );
    }
}

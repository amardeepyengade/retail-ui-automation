package com.retail.ui.automation.base;

import org.openqa.selenium.WebDriver;

import com.retail.ui.automation.utils.TestUtils;
import com.retail.ui.automation.utils.WaitUtils;

public class BasePage {

	 protected WebDriver driver;
	    protected WaitUtils waitUtils;
	    protected TestUtils testUtils;

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        this.waitUtils = new WaitUtils(driver);
	        this.testUtils = new TestUtils(driver);
	    }
}

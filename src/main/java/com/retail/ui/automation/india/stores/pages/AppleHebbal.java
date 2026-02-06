package com.retail.ui.automation.india.stores.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppleHebbal {

	 private WebDriver driver;

	    public AppleHebbal(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
}

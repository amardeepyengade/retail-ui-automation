package com.retail.ui.automation.india.stores.pages;

import org.openqa.selenium.support.PageFactory;

import com.retail.ui.automation.base.BaseTest;

public class AppleBKC extends BaseTest{
	
	//private WebDriver driver;
	
	/*
	 * public AppleBKC(WebDriver driver) { 
	 * PageFactory.initElements(driver, this); }
	 */
	
	public AppleBKC() {
        PageFactory.initElements(getDriver(), this);
    }
}

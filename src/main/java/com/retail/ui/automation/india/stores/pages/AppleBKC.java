package com.retail.ui.automation.india.stores.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppleBKC {
	private WebDriver driver;
	public AppleBKC(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

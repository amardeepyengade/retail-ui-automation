package com.retail.ui.automation.india.stores.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppleKoregaonPark{
	
	private WebDriver driver;
	
	public AppleKoregaonPark(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

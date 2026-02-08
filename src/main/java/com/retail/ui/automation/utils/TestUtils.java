package com.retail.ui.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestUtils {
	
	 private WebDriver driver;

	    public TestUtils(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void scrollToFeatures(By locator) {
	        WebElement element = driver.findElement(locator);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	
}

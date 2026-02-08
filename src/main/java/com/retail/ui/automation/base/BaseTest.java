package com.retail.ui.automation.base;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class BaseTest {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	protected static Properties prop;

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
	}

	public static void unload() {
		driver.remove();
	}

	static {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/main/java/com/retail/ui/automation/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void setup(Method method) {
		String browserName = prop.getProperty("browser");
		

		WebDriver localDriver;

		if ("chrome".equals(browserName)) {
			WebDriverManager.chromedriver().setup();
			localDriver = new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			localDriver = new FirefoxDriver();
		}

		setDriver(localDriver);
		
		System.out.println(
		        "Thread: " + Thread.currentThread().getId() +
		        " | Test: " + method.getName() +
		        " | Browser: " + browserName
		    );
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		System.out.println(">>> TEARDOWN CALLED <<<");

		if (ITestResult.FAILURE == result.getStatus()) {
			Allure.addAttachment("Failure Screenshot",
					new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
		}

		if (getDriver() != null) {
			getDriver().quit();
			unload(); // VERY important for ThreadLocal cleanup
		}
	}
}
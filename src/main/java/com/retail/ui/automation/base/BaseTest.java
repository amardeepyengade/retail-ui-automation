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

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class BaseTest {

	protected WebDriver driver;
    protected static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                "src/main/java/com/retail/ui/automation/config/config.properties"
            );
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        String browserName = prop.getProperty("browser");

        if ("chrome".equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        System.out.println(">>> TEARDOWN CALLED <<<");
        if (ITestResult.FAILURE == result.getStatus()) {
            Allure.addAttachment(
                "Failure Screenshot",
                new ByteArrayInputStream(
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
                )
            );
        }

        if (driver != null) {
            driver.quit();
        }
   }
}
package com.opencart.base;

import com.opencart.readutilityfiles.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;

public class DriverBaseClass {

    public WebDriver getDriver() {
        return setUpWebdriver();
    }

    private WebDriver driver;
    public String url;
    private ReadPropertyFile readPropertyFile;
    private Properties prop;

    public DriverBaseClass() {
        readPropertyFile = new ReadPropertyFile();
        try {
            prop = readPropertyFile.getConfigPropertyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Initializing driver here. getting driver name as a string from prop files.
     */

    /**
     * Bonagarcia is a webdriverManager. This will automatically downloads the chrome.exe from CFT dashboard.
     */

    public WebDriver setUpWebdriver() {

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            launchBrowser();
        }
        if (prop.getProperty("browser").equalsIgnoreCase("firefox") ||
                prop.getProperty("browser").equalsIgnoreCase("mozilla") ||
                prop.getProperty("browser").equalsIgnoreCase("mozilla firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            launchBrowser();
        }
        return driver;
    }

    public void launchBrowser() {
        driver.get(prop.getProperty("testURL"));
        driver.manage().window().fullscreen();
    }

    public void tearDown() {
        driver.close();
    }
}

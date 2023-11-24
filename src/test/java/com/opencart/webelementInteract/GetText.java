package com.opencart.webelementInteract;

import com.opencart.base.DriverBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class GetText {
    WebDriver driver;

    public GetText(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextOfWebElement(WebElement element, String textBy, WebDriver driver) {
        String strTxt = "";
        try {
            waitForElementPresence(element, driver);
            switch (textBy.toLowerCase()) {
                case "value":
                    strTxt = element.getAttribute("value");
                    break;
                default:
                    strTxt = element.getText();
                    break;
            }

        }
        catch(NoSuchElementException exception){
            System.out.println(exception.getMessage());
        }
        return strTxt;
    }

    private void waitForElementPresence(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

package com.opencart.webelementInteract;

import com.opencart.base.DriverBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencart.readutilityfiles.ReadExcelFile;
import com.opencart.readutilityfiles.ReadPropertyFile;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FindElementLocator extends DriverBaseClass{
    WebDriver driver;
    private String text;
    private ReadPropertyFile readProp;
    private Properties pr;
    private WebElement element;
    private GetText objGetText;
    private WaitClass objWaitClass;

    public FindElementLocator(WebDriver driver) {
        this.driver = driver;
        objWaitClass= new WaitClass(driver);
        readProp = new ReadPropertyFile();
        try {
            pr = readProp.getConfigPropertyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement findElementByLinkText(String link) {
        element = driver.findElement(By.linkText(link));
        objWaitClass.waitForElement(element);
        return element;
    }

    public WebElement findElementByXpath(String xPath) {
        element = driver.findElement(By.xpath(xPath));
        objWaitClass.waitForElement(element);
        return element;
    }


    public WebElement findElementById(String id) {
        element = driver.findElement(By.id(id));
        objWaitClass.waitForElement(element);
        return element;
    }

    public void clickElement(WebElement ele) {
        objWaitClass.waitForElement(ele);
        ele.click();

    }
    public void sendText(WebElement element, String textToEnter){
        objWaitClass.waitForElement(element);
        element.sendKeys(textToEnter);
    }


    public String getTitleOfWebPage() {
        text = driver.getTitle();
        return text;
    }
}

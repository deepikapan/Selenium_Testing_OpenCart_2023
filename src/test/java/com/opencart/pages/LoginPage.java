package com.opencart.pages;

import com.opencart.base.DriverBaseClass;
import com.opencart.base.ScreenShot;
import com.opencart.readutilityfiles.ReadExcelFile;
import com.opencart.readutilityfiles.ReadPropertyFile;
import com.opencart.webelementInteract.ActionClassInteractions;
import com.opencart.webelementInteract.FindElementLocator;
import com.opencart.webelementInteract.GetText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends DriverBaseClass {
    WebDriver driver;
    DriverBaseClass driverBaseClass;
    FindElementLocator objFindElementLocator;
    private ReadPropertyFile readProp;
    private Properties configPropFile;
    private Properties locatorsPropFile;
    private WebElement element;
    private ReadExcelFile readTestDataUsingExcel;
    private boolean status;
    private String text;
    private GetText objGetText;
    private ScreenShot objSceenshot;
    private ActionClassInteractions objActionClassInteractions;

    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        driverBaseClass = new DriverBaseClass();
        readProp = new ReadPropertyFile();
        configPropFile = readProp.getConfigPropertyFile();
        locatorsPropFile = readProp.getLocatorsPropertyFile();
        readTestDataUsingExcel = new ReadExcelFile();
       objFindElementLocator = new FindElementLocator(driver);
       objGetText = new GetText(driver);
       objSceenshot = new ScreenShot(driver);
       objActionClassInteractions = new ActionClassInteractions(driver);
    }

    public boolean verifyTitleOfLoginPage() {

    text= objFindElementLocator.getTitleOfWebPage();
    if(text.equalsIgnoreCase(locatorsPropFile.getProperty("loginPageTitle"))){
        status = true;
        Reporter.log("Title of Opened WebPage is: "+text);
    }
    else{
        status = false;
        Reporter.log("Title is not verified. Title is: "+text);
    }
    return status;
    }

    public boolean verifyTelephoneNumberOnLoginPage() {
        element= objFindElementLocator.findElementByXpath(locatorsPropFile.getProperty("telephoneOnLoginPage"));
        text= objGetText.getTextOfWebElement(element, "text",driver);
        if(text.equalsIgnoreCase(locatorsPropFile.getProperty("telephoneNumberDisplayedToTestLoginPage"))){
            status = true;
            Reporter.log("Displayed Telephone number on LoginPage: "+text);
        }
        else {
            status = false;
            Reporter.log("Displayed Number on LoginPage: " + text);
        }
        return status;
    }


    public void verifyLoginLinkOnLoginPage(){
        element = objFindElementLocator.findElementByXpath(locatorsPropFile.getProperty("myAccountElementLoginPage"));
        objActionClassInteractions.moveToElementAndClickUsingMouse(element);
        element = objFindElementLocator.findElementByXpath(locatorsPropFile.getProperty("myAccountLoginLinkLoginPage"));
        objActionClassInteractions.moveToElementAndClickUsingMouse(element);
        element= objFindElementLocator.findElementById(locatorsPropFile.getProperty("emailIdToRegisterLoginPage"));

        objFindElementLocator.sendText(element,"");
    }
}

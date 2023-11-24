package com.opencart.base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class MyListeners implements ITestListener {

    private String testMethodName;
    private ScreenShot objScreenShot;

    private static String getTestMethodName(ITestResult iTestResult) {

        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    /**
     * This @Attachement annotaion is of Allure reports. This below method is to take screenshot and return the bytes.
     *
     * @param driver
     * @return
     */

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestFailure(ITestResult result) {

        Object currentClass = result.getInstance();
        WebDriver webDriver = ((DriverBaseClass) currentClass).getDriver();
        testMethodName = result.getMethod().getConstructorOrMethod().getName();
        if(webDriver!=null)
        {
            objScreenShot =  new ScreenShot(webDriver);
            objScreenShot.takeScreenShotOfPage(testMethodName);

        }


    }
}

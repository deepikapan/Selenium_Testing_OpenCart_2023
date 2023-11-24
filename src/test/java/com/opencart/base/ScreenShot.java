package com.opencart.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends DriverBaseClass {
        WebDriver driver;
        File fileSrc;
        File fileDest;

        public ScreenShot(WebDriver driver){
        this.driver= driver;
        }
        public void takeElementScreenShot(WebElement element){
            fileSrc= element.getScreenshotAs(OutputType.FILE);
            fileDest = new File(System.getProperty("user.dir")+
                    "\\src\\main\\ScreenShots\\"+timeStampForScreenshot()+".png");
            try {
                FileHandler.copy(fileSrc,fileDest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void takeScreenShotOfPage(String testMethodName){
            fileSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            fileDest = new File(System.getProperty("user.dir")+
                    "\\src\\main\\ScreenShots\\"+testMethodName+ "- "+timeStampForScreenshot()+".png");
            try {
                FileHandler.copy(fileSrc,fileDest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static String timeStampForScreenshot(){
            return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        }

    }

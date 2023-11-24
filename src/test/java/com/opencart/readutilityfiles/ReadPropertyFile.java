package com.opencart.readutilityfiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadPropertyFile {
    private FileReader fileReader;
    Properties property = new Properties();
    private String browserName;
    private String testURL;
    private String excelFileName;
    private Map<String, String> propFileData = new HashMap<>();
    private String locatorPropertyFileName ="locators.loginpage.properties";
    private String configPropertyFile= "config.properties";

    private FileReader fileReader1;
    private FileReader fileReader2;
    public Properties getConfigPropertyFile() throws IOException {
        fileReader1 = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\ConfigFiles\\"+configPropertyFile);
        property.load(fileReader1);
        return property;
    }
    public Properties getLocatorsPropertyFile() throws IOException {
        fileReader2 = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\ConfigFiles\\" +locatorPropertyFileName);
        property.load(fileReader2);
        return property;
    }
    public Map<String, String> readConfigPropertyFile() throws IOException {
        getConfigPropertyFile();
        browserName = property.getProperty("browser");
        testURL = property.getProperty("testURL");
        excelFileName = property.getProperty("excelFileName");

        propFileData.put("browserName", browserName);
        propFileData.put("testURL", testURL);
        propFileData.put("excelFileName", excelFileName);
        return propFileData;

    }
}

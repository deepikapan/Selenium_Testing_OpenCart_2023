package com.opencart.webelementInteract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassInteractions  {
    WebDriver driver;
    private Actions action;
    private WaitClass objWaitClass;

    public ActionClassInteractions(WebDriver driver) {
        this.driver = driver;
        objWaitClass = new WaitClass(driver);
        action = new Actions(driver);

    }

    //Double Click on Element
    public void doubleClickUsingMouseOnElement(WebElement element){
        objWaitClass.waitForElement(element);
        action.doubleClick(element).perform();
    }

    //Single click using mouse

    public void singleClickUsingMouseOnElement(WebElement element){
        objWaitClass.waitForElement(element);
        action.click(element).perform();
    }

    //Move To Element Using Mouse

    public void moveToElementUsingMouseOnElement(WebElement element){
        objWaitClass.waitForElement(element);
        action.moveToElement(element).build().perform();
    }

    //Move To Element and click using Mouse
    public void moveToElementAndClickUsingMouse(WebElement element){
        objWaitClass.waitForElement(element);
        action.moveToElement(element).click().build().perform();
    }

    //Move To Element and Double click using Mouse
    public void moveToElementAndDoubleClickUsingMouse(WebElement element){
        objWaitClass.waitForElement(element);
        action.moveToElement(element).doubleClick(element).build().perform();
    }

    //Move Element and Right Click on Element using mouse
    public void moveToElementAndRightClickOnElementUsingMouse(WebElement element){
        objWaitClass.waitForElement(element);
        action.moveToElement(element).contextClick().build().perform();
    }

    //Right Click On Element using Mouse
    public void rightClickOnElementUsingMouse(WebElement element){
        objWaitClass.waitForElement(element);
        action.contextClick(element).perform();
    }
}

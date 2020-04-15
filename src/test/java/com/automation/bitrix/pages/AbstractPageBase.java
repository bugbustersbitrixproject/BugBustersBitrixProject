package com.automation.bitrix.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public abstract class AbstractPageBase {


    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);
    protected StringSelection stringSelection;
    protected Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    @FindBy(id = "search-textbox-input")
    protected WebElement searchBox;

    @FindBy(id = "user-name")
    protected WebElement user;


    public AbstractPageBase() {

        PageFactory.initElements(driver, this);
    }

    public void navigateToTab(String tabName) {
        String tabXpath = "//span[@class='feed-add-post-form-link']//span[text()='" + tabName + "']";
        WebElement tab = driver.findElement(By.xpath(tabXpath));
        BrowserUtils.waitForPageToLoad(20);
        if (tabName.equals("File") || tabName.equals("Appreciation") ||
                tabName.equals("Announcement") || tabName.equals("Workflow")) {
            WebElement more = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text' and contains(text(),'More')]"));
            more.click();
            BrowserUtils.wait(3);
            WebElement subModule=driver.findElement(By.xpath("//span[@class='menu-popup-item-text' and contains(text(),'"+tabName+"')]"));
            subModule.click();
        } else {
            tab.click();
        }
    }

    /**

     * Method for Btrix24 navigation. Provide tab name to navigate
     * @param tabName, like Message, Task, Poll, Event, File, Appreciation, Announcement, Workflow
     */
    public void navigateTo(String tabName) {
        BrowserUtils.waitForPageToLoad(10);
        String tabNameXpath = "//span[contains(@class,'feed-add-post-form-')]/span[text()='"+tabName+"']";
        if(tabName.equals("File")|| tabName.equals("Appreciation") || tabName.equals("Announcement") || tabName.equals("Workflow")){
            BrowserUtils.wait(2);
            WebElement moreTab = driver.findElement(By.cssSelector("[id=\"feed-add-post-form-link-more\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(moreTab)).click();
        }
        BrowserUtils.wait(2);
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();
        BrowserUtils.wait(3);
    }

}




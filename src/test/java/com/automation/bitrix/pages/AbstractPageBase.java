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

public abstract class AbstractPageBase {


       protected WebDriver driver= Driver.getDriver();
       protected WebDriverWait wait =new WebDriverWait(driver,20);

       @FindBy(id = "search-textbox-input")
      protected WebElement searchBox;

       @FindBy(id="user-name")
       protected WebElement user;



       public AbstractPageBase(){

           PageFactory.initElements(driver,this);
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

       public void navigateTo(String moduleName){

              String moduleXpath="//span[@class='menu-item-link-text'  and contains(text(),'" + moduleName + "')]";

              WebElement module= driver.findElement(By.xpath(moduleXpath));

              if(moduleName.equals("Applications") || moduleName.equals("Workflows")){
                     WebElement more=driver.findElement(By.xpath("//span[@class='menu-favorites-more-text']"));
                     more.click();
                     wait.until(ExpectedConditions.elementToBeClickable(module)).click();


              }else{
                     module.click();
              }

       }
    //to  navigate modules under Activity Stream
    public void navigateToTab(String tabName) {
        if (tabName.equals("File") || tabName.equals("Appreciation") ||
                tabName.equals("Announcement") || tabName.equals("Workflow")) {
            WebElement more = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text' and contains(text(),'More')]"));
            more.click();
            BrowserUtils.wait(3);
            WebElement subModule=driver.findElement(By.xpath("//span[@class='menu-popup-item-text' and contains(text(),'"+tabName+"')]"));
            subModule.click();
        } else {
            String tabXpath = "//span[@class='feed-add-post-form-link']//span[text()='" + tabName + "']";
            WebElement tab = driver.findElement(By.xpath(tabXpath));

            tab.click();
        }
    }
}




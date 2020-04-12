package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class EventTab extends AbstractPageBase {
    @FindBy(xpath = "//*[@id='feed-add-post-form-tab-calendar']/span")
//"//span[text()='Event']")
    private WebElement eventModule;
    @FindBy(id = "bx-b-uploadfile-blogPostForm_calendar")
    private WebElement uploadFileIcon;
    @FindBy(id = "bx-b-link-blogPostForm_calendar")
    private WebElement uploadlinkIcon;
    @FindBy(id = "bx-b-link-blogPostForm_calendar")
    private WebElement uploadVideo;
    @FindBy(xpath = "(//tr/td/div[@class='diskuf-uploader'])[3]")
    private WebElement placeForUpload;
    @FindBy(xpath = "(//*[text()='Select document from Bitrix24'])[3]")
    private WebElement selectDocumentFromBitrix24;
    @FindBy(xpath = "//*[@id='DiskFileDialog']/div[3]/span[1]")
    private WebElement selectDocumentButton;
//company drive with name 'Sales and marketing' click
    @FindBy(xpath = "//*[@title='Sales and marketing']")
    private WebElement salesAndMarketigFile;
    //company drive with name 'Marketing and Advertising File' click
    @FindBy(xpath = "//*[text()='Marketing and advertising']")
    private WebElement MarketingandAdvertisingFile;
    @FindBy(xpath = "//a[@href='#'][@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file']")
    private List<WebElement> documentsFromBitrix24;
   //this sales marketing open  Marketing and advertising file


    String imageName = "catPicture.jfif";
    String fileName = "file.txt";
////this method will usd for uploading file from File yor computer
    public void uploadFileMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(eventModule));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", eventModule);
        //eventModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileIcon));
        uploadFileIcon.click();
        //click on file upload button
        placeForUpload.click();
        BrowserUtils.wait(5);
        String filePath="C://Users//golcu//OneDrive//Masaüstü";
        String filename="myfirstWebsite";
        placeForUpload.sendKeys(filePath);
     //this method does not work




    }
    //this method will usd for uploading file from File From Bitrix24
    public void uploadFileFromBitrix24(){
        wait.until(ExpectedConditions.elementToBeClickable(eventModule));
        //click event module
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", eventModule);
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileIcon));
        BrowserUtils.wait(4);
        //click upload icon
        uploadFileIcon.click();

        //click select Document From Bitrix
        selectDocumentFromBitrix24.click();
        BrowserUtils.wait(3);
        //click file name sales and marketing
        salesAndMarketigFile.click();
        BrowserUtils.wait(3);
        //click files marketing and advertising
        MarketingandAdvertisingFile.click();
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(selectDocumentFromBitrix24));
        BrowserUtils.wait(3);
        //his gives some times error because of no file
        // click which document you want to dowload chose by index
       // documentsFromBitrix24.get(index).click();
        //click one file
        documentsFromBitrix24.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDocumentButton));
        BrowserUtils.wait(3);
        selectDocumentButton.click();

    //this method will use to prove file uploaded FromBitrix24
    }
    public String fileNameFromBitix24(){
     String actualfileName = documentsFromBitrix24.get(0).getText();
     return actualfileName;
    }//this method filename from the place we upload
    public String uploodedFileName(){
        //title="Click to insert file"
        return driver.findElement(By.xpath("//*[@id='disk-edit-attachn513']/td[1]/span[1]/span[1]")).getText();
    }
}

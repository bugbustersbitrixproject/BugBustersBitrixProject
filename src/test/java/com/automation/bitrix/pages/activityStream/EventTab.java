package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
    @FindBy(xpath = "//a[@href='#'][@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file']")
    private WebElement fileFromBitrix24;
    @FindBy(xpath = "//*[@title='Click to insert file']")
    private WebElement clickToInsertFile;
    @FindBy(xpath = "//*[@id='blog-submit-button-save']")
    private WebElement submit;
    @FindBy(xpath = "//*[text()='Logo.gif']")
    private WebElement filenameFromBitrix24;
    @FindBy(css = "img[id^='disk-inline-image']")
    private WebElement image;

    ////this method will usd for uploading file from File yor computer
    public void uploadFileMethod() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(eventModule));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //  js.executeScript("arguments[0].click();", eventModule);//eventModule.click();
        //navigateToTab("Event");
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileIcon));
        uploadFileIcon.click();
        //click on file upload button
        placeForUpload.click();
        Robot r = new Robot();
        StringSelection strS = new StringSelection("C:\\Users\\golcu\\OneDrive\\Belgeler\\file.txt\\");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strS, null);
        BrowserUtils.wait(3);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        BrowserUtils.wait(3);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        BrowserUtils.wait(3);

        BrowserUtils.clickWithJS(submit);

    }
    //thid method upload file from computer without robot class


    //this method will used for uploading file from File From Bitrix24
    public void uploadFileFromBitrix24() {
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
        //click one file
        documentsFromBitrix24.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDocumentButton));
        BrowserUtils.wait(3);
        selectDocumentButton.click();


        //this method will use to prove file uploaded FromBitrix24
    }

    public String fileNameFromBitrix24() {
        ////*[text()="Logo.gif"]   name of the file == logo.gif
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", eventModule);
        String actualfileName = filenameFromBitrix24.getText();
        return actualfileName;
    }

    //this method filename from the place we upload

    public String uplodedFileName(String fileName) {
        //this part can change because of the file name of we uploded

        WebElement fileThatWeSend = driver.findElement(By.xpath("//*[@class='feed-com-file-name'][contains(@title,'" + fileName.substring(0, fileName.indexOf(".")) + "')]"));
        BrowserUtils.wait(3);
        return fileThatWeSend.getText();


    }

    // "this method uploadfile from inteljID")
    public void uploadfromintelIJ() {
        wait.until(ExpectedConditions.elementToBeClickable(eventModule));
        navigateToTab("Event");
        //eventModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileIcon));
        uploadFileIcon.click();
        //click on file upload button
        placeForUpload.click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("bxu_files[]")).sendKeys(System.getProperty("user.dir") + "/pom.xml");
        BrowserUtils.wait(2);

    }
  //I am working this method it is not pass yet
    public void uploadFile(String file1, String file2) {
        wait.until(ExpectedConditions.elementToBeClickable(eventModule));

        wait.until(ExpectedConditions.elementToBeClickable(uploadFileIcon));
        uploadFileIcon.click();
        //click on file upload button

        String path;
        String path2;

        //user.dir will give this path
        path = System.getProperty("user.dir") + System.getProperty("file.separator") + file1;
        path2 = System.getProperty("user.dir") + System.getProperty("file.separator") + file2;
        BrowserUtils.wait(3);
        placeForUpload.sendKeys(path);
        BrowserUtils.wait(3);
        placeForUpload.sendKeys(path2);
        BrowserUtils.wait(3);
    } public void sendFiles() {
        submit.click();
        BrowserUtils.wait(3);
    }
    public String photoNameText(String imageName){

        WebElement imageN=driver.findElement(By.xpath("[contains(@title,'" + imageName.substring(0, imageName.indexOf(".")) + "')]"));
        return imageN.getText();
    }

    public void clickOnImage(){
        image.click();
    }}

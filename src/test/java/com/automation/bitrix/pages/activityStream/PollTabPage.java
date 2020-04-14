package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class PollTabPage extends AbstractPageBase {
    private String uploadedFileXpath;
    private String uploadedImageXpath;


    public void setUploadedFileXpath(String uploadedFileXpath) {
        this.uploadedFileXpath = uploadedFileXpath;
    }

    public void setUploadedImageXpath(String uploadedImageXpath) {
        this.uploadedImageXpath = uploadedImageXpath;
    }



    /**
     * US#4; AC#1
     * User should be able to click on upload files icon to upload files
     * and pictures from local disks,
     * download from external drive,
     * select documents from bixtrix24,
     * and create files to upload.
     */

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']/span")
    private WebElement pollTab;
    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    private WebElement uploadFileIcon;
    @FindBy(xpath = "(//div[@class='diskuf-uploader'])[1]")
    private WebElement fileAndImgUpload;
    @FindBy(id = "blog-submit-button-save")
    private WebElement sendBtn;
    @FindBy(xpath = "//span[@class='feed-com-file-name-wrap']")
    private WebElement uploadedFile;
//    @FindBy(xpath = "//span[text()='"+imageName+".jpg']") ==> checkout how to pass dynamic argument in FindBy
//    private  WebElement uploadedImage; //found this webelement dynamically inside the method instead
    @FindBy(xpath = "//span[@class='feed-com-files-photo']")
    private WebElement uploadedImage;
    @FindBy(xpath = "//span[@class='bx-viewer-file-name']")
    private WebElement imageTitle;

    public WebElement getUploadedFile() {
        return uploadedFile;
    }

    public WebElement getUploadedImage() {
        return uploadedImage;
    }

    public  WebElement uploadFileFromDesktop(String filePath, String expectedFileName, WebElement uploadedFile) {
        //click on icon
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fileAndImgUpload)).click();
        stringSelection = new StringSelection(filePath);
        //pasting file path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        BrowserUtils.wait(3);
        //using Robot class methods to manipulate with keyboard.
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        BrowserUtils.wait(3);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        BrowserUtils.wait(3);
        sendBtn.click();
        //wait.until(ExpectedConditions.visibilityOf(uploadedFile));
       //* wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(uploadedFile)));
        return uploadedFile;
                //.getText().contains(expectedFileName);


    }
    public boolean uploadImageFromDesktop(String imagePath, String imageName, WebElement uploadedImage ){
    uploadedImage = uploadFileFromDesktop(imagePath, imageName, uploadedImage); //calling the method above instead of repeating the steps.
   wait.until(ExpectedConditions.elementToBeClickable(uploadedImage)).click();
   String actualImgName = wait.until(ExpectedConditions.visibilityOf(imageTitle)).getText();

        return actualImgName.contains(imageName);
    }
}

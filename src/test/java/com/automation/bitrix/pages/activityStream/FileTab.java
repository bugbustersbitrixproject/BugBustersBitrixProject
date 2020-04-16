package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileTab extends AbstractPageBase {

    @FindBy(name = "bxu_files[]")
    private WebElement uploadFileOption;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(css = "img[id^='disk-attach-image']")
    private WebElement image;

    @FindBy(xpath = "//span[@title='teamlogo.jpg'][text()]")
    private WebElement photoTitle;

    @FindBy(css = "[class='feed-com-file-name']")
    private WebElement fileTitle;

    public void uploadFile(String file1, String file2) {
        String path = System.getProperty("user.dir") + System.getProperty("file.separator") + file1;
        String path2 = System.getProperty("user.dir") + System.getProperty("file.separator") + file2;
        //path2="C:\Users\1\Desktop\bugbusters\BugBustersBitrixProject\teamlogo.jpg"
        BrowserUtils.wait(3);
        uploadFileOption.sendKeys(path);
        BrowserUtils.wait(3);
        uploadFileOption.sendKeys(path2);
        BrowserUtils.wait(3);
    }

    public void sendFiles() {
        sendButton.click();
        BrowserUtils.wait(3);
    }

    public String fileNameText() {
        return fileTitle.getText();
    }

    public String photoNameText() {
        return photoTitle.getText();
    }

    public void clickOnImage(){
        image.click();
    }
//See some examples about properties for our System
//    public static void main(String[] args) {
//        String osname = System.getProperty("os.name");
//        System.out.println("osname = " + osname);
//
//        String path1 = System.getProperty("user.dir");
//        String path2 = System.getProperty("user.home");
//        String path3 = System.getProperty("user.name");
//
//        System.out.println("path1 = " + path1);
//        System.out.println("path2 = " + path2);
//        System.out.println("path3 = " + path3);
//
//    }
}

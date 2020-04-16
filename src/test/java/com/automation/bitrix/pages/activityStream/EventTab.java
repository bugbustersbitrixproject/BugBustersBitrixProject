package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private WebElement SelectDocumentFromBitrix24;
    @FindBy(xpath = "//a[@href='#'][@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file']")
    private List<WebElement> documentsFromBitrix24;
    @FindBy(xpath = "//*[text()='Select document']")
    private WebElement selectDocumentButton;
    String imageName = "catPicture.jfif";
    String fileName = "file.txt";

    public void uploadFileMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(eventModule));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", eventModule);
        //eventModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileIcon));
        uploadFileIcon.click();
        placeForUpload.click();
        BrowserUtils.wait(5);
        placeForUpload.sendKeys(fileName, Keys.ENTER);
    }
}

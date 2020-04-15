package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppreciationTab extends AbstractPageBase {


/*
"6. As a user, I should be able to send
appreciation by clicking on Appreciation subheading from ""More"" tab under Activity Stream."

"1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.
2. User should be able to add users and recipients from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
3. User should be able to attach link by clicking on the link icon.
4. User should be able to insert videos by clicking on the video icon and entering the video URL.
5. User should be able to create a quote by clicking on the Comma icon.
6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
7. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
8. User should be able to click on the Topic icon to see the Appreciation Topic text box displays on top of the message box.
9. User should be able to click on ""Record Video"" tab to record a video and attach it with the message.
10. User should be able to add tags by selecting existing tags or creating new tags by clicking on the # icon.
11. User should be able to see all types of appreciation illustration/emojis by clicking on the existing illustration/emojis."
 */

    @FindBy(xpath = "//*[@id=\"feed-add-post-content-message\"]/div//span[@class=\"feed-add-post-form-but feed-add-file\"]")
    private WebElement upload_files_icon;

    @FindBy(name = "bxu_files[]")
    private WebElement upload_files_and_images_tab;


    public void click_upload_btn() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(upload_files_icon)).click();
    }

    public void upload_file_and_images(){
        BrowserUtils.waitForPageToLoad(10);
            BrowserUtils.wait(2);
            driver.findElement(By.name("bxu_files[]")).sendKeys(System.getProperty("user.dir")+"/pom.xml");
            BrowserUtils.wait(2);



        //BrowserUtils.wait(2);
        //    driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click();
        //    BrowserUtils.wait(2);
        //    driver.findElement(By.name("bxu_files[]")).sendKeys(System.getProperty("user.dir")+"/pom.xml");
        //    BrowserUtils.wait(2);


    }




}


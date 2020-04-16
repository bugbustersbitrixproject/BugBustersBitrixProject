package com.automation.bitrix.pages.activityStream;

    import com.automation.bitrix.pages.AbstractPageBase;
    import com.automation.utilities.BrowserUtils;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.ui.ExpectedConditions;

    import java.util.List;
    import java.util.Random;

    public class AppreciationTab extends AbstractPageBase {

        //upload files
        @FindBy(id = "bx-b-uploadfile-blogPostForm")
        private WebElement uploadFilesIcon;

        @FindBy(css = "[name=\"bxu_files[]\"]")
        private WebElement uploadFilesAndImages;

        @FindBy(id = "blog-submit-button-save")
        private WebElement sendBtn;

        @FindBy(css = "[class=\"insert-btn\"]")
        private WebElement insertInText;

        @FindBy(css = "[title=\"Click to insert file\"]")
        private WebElement attachedFiles;

        @FindBy(xpath = "//div[@id=\"divoPostFormLHE_blogPostForm\"]//span[text()=\"Select document from Bitrix24\"]")
        private WebElement documentFromBtrix24;

        @FindBy(css = "[class=\"bx-file-dialog-content-wrap\"]>div")
        private List<WebElement> recentItemsList;

        @FindBy(css = "[class=\"popup-window-buttons\"]>span:nth-child(1)")
        private WebElement selectDocument;

        public void clickUploadFilesIcon(){
            BrowserUtils.waitForPageToLoad(10);
            wait.until(ExpectedConditions.elementToBeClickable(uploadFilesIcon)).click();
        }
        public void uploadFilesFromLocal(){
            BrowserUtils.waitForPageToLoad(10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=\"bxu_files[]\"]")));

            uploadFilesAndImages.sendKeys(System.getProperty("user.dir")+"/pom.xml");
            wait.until(ExpectedConditions.visibilityOf(insertInText));
        }
        public WebElement getAttachedFiles(){
            BrowserUtils.waitForPageToLoad(10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title=\"Click to insert file\"]")));
            return attachedFiles;
        }
        public void selectDocumentsFromBtrix24(){
            BrowserUtils.waitForPageToLoad(10);
            wait.until(ExpectedConditions.
                    presenceOfElementLocated(By.xpath("//div[@id=\"divoPostFormLHE_blogPostForm\"]//span[text()=\"Select document from Bitrix24\"]"))).click();
            Random random = new Random();
            BrowserUtils.wait(2);
            int index = random.nextInt(recentItemsList.size());
            recentItemsList.get(index).click();
            wait.until(ExpectedConditions.elementToBeClickable(selectDocument)).click();
        }

    }

package com.automation.bitrix.tests.activityStream;


import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.AppreciationTab;


import org.testng.Assert;
import org.testng.annotations.Test;


public class AppreciationTabTest extends AbstractTestBase {

    @Test(description = "User should be able to click on upload files icon to upload files and pictures from local disks")
    public void verifyUploadFromLocal(){

        test = report.createTest("Verify upload file from local disk");

        LoginPage loginPage = new LoginPage();
        AppreciationTab appreciationTab_ =new AppreciationTab();
        loginPage.loginAs("hr1");

        test.info("Login as HR");
        appreciationTab_.navigateToTab("Appreciation");
        appreciationTab_.clickUploadFilesIcon();
        appreciationTab_.uploadFilesFromLocal();
        Assert.assertTrue(appreciationTab_.getAttachedFiles().isDisplayed());

        test.pass("Upload file from local disk is verified");
    }

    @Test(description = "User should be able to click select documents from Bitrix24")
    public void verifySelectDocumentFromBtrix24(){

        test = report.createTest("Verify select documents from Bitrix24");

        LoginPage loginPage = new LoginPage();
        AppreciationTab appreciationTab_ =new AppreciationTab();
        loginPage.loginAs("hr1");

        test.info("Login as HR");
        appreciationTab_.navigateToTab("Appreciation");
        appreciationTab_.clickUploadFilesIcon();
        appreciationTab_.selectDocumentsFromBtrix24();
        Assert.assertTrue(appreciationTab_.getAttachedFiles().isDisplayed());

        test.pass("Select documents from Bitrix24 is verified");
    }

}
package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;

import com.automation.bitrix.pages.activityStream.UploadFile;

import org.testng.annotations.Test;

public class UploadFileTest extends AbstractTestBase {

    @Test
    public void fileUploadPage() {
        test = report.createTest("Verify Upload File");
        LoginPage loginPage = new LoginPage();
        UploadFile uploadFile = new UploadFile();
        test.info("Login as hr1");
        loginPage.login();
        test.info("Go to file tab");
        uploadFile.navigateToTab("File");
        uploadFile.uploadFileImage();
        test.info("file Uploaded ");
    }
}

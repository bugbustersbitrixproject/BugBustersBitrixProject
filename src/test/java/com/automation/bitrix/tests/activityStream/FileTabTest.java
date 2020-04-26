package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.FileTab;
import com.automation.bitrix.tests.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileTabTest extends AbstractTestBase {


    @Test
    public void uploadFileTestUnderFileTab() {
        test = report.createTest("Uploading File");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("marketing2");
        test.info("Login successfully");

        FileTab fileTab = new FileTab();
        //fileTab.navigateToTab("File");
        test.info("Navigated to File tab");

        fileTab.uploadFile("diary.txt", "teamlogo.jpg");
        test.info("diary.txt and  teamlogo.jpg files uploaded");

        fileTab.sendFiles();

        Assert.assertEquals(fileTab.fileNameText(), "diary.txt");
        fileTab.clickOnImage();
        Assert.assertEquals(fileTab.photoNameText(), "teamlogo.jpg");

        test.pass("Files uploaded successfully");
    }
}

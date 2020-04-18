package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.EventTab;
import com.automation.bitrix.pages.activityStream.FileTab;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.BrowserUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class EventTabTest extends AbstractTestBase {


    @Test(description = "User should be able to click on upload files icon to upload files")
    public void test1() throws Exception {
        test = report.createTest("upload file from computer");

        LoginPage login = new LoginPage();
        login.loginAs("help_desk2");
        BrowserUtils.wait(4);
        EventTab eventPage = new EventTab();
        eventPage.navigateToTab("Event");
        eventPage.uploadFileMethod();
        BrowserUtils.wait(4);
        eventPage.uplodedFileName("file.txt");
        BrowserUtils.wait(4);
        Assert.assertTrue(eventPage.uplodedFileName("file.txt").contains("file"));

        BrowserUtils.wait(3);

    }

    @Test(description = "User should be able to click on upload files icon to upload Bitrix24files")
    public void test2() {
        test = report.createTest("upload file from Bitrix24");
        LoginPage login = new LoginPage();
        login.loginAs("help_desk2");
        BrowserUtils.wait(4);
        EventTab eventPage = new EventTab();

        eventPage.navigateToTab("Event");
        eventPage.uploadFileFromBitrix24();
        System.out.println(eventPage.fileNameFromBitrix24());

    }

    @Test(description = "this method uploadfile from inteljID")
    public void uploadFromIntelj() {
        test = report.createTest("upload file from computer");
        LoginPage login = new LoginPage();
        login.loginAs("help_desk2");
        BrowserUtils.wait(4);
        EventTab eventPage = new EventTab();
        eventPage.uploadfromintelIJ();


    }

    @Test(description = "uploding file and images from computer")
    public void uploadFile() {
        test = report.createTest("Uploading File");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("help_desk2");
        test.info("Login successfully");

        EventTab eventTab = new EventTab();
        eventTab.navigateToTab("Event");
        test.info("Navigated to EventTab");

        eventTab.uploadFile("Encapsulation.txt", "11111111.jpg");
        test.info("Encapsulation.txt and  11111111.jpg files uploaded");

        eventTab.sendFiles();
        Assert.assertTrue(eventTab.uplodedFileName("Encapsulation.txt").contains(eventTab.uplodedFileName("Encapsulation.txt")));
        eventTab.clickOnImage();
        BrowserUtils.wait(3);
        Assert.assertTrue(eventTab.photoNameText("11111111.jpg").contains(eventTab.photoNameText("11111111.jpg")));

        test.pass("Files uploaded successfully");
    }
 //User shoul able to attached link
@Test(description = "user able to attaced url")
    public void attachedLink() throws Exception{
        test = report.createTest("Attach Url Link");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("help_desk2");
        test.info("Login successfully");
        EventTab eventTab = new EventTab();
        eventTab.navigateToTab("Event");
        test.info("Navigated to EventTab");
        BrowserUtils.wait(3);
        eventTab.clickLinkIcon();
        BrowserUtils.wait(3);

        eventTab.attachUrlLink("https://qa2.vytrack.com/user/login");
        BrowserUtils.wait(3);
        eventTab.sendFiles();
        BrowserUtils.wait(3);

        String urlactual = eventTab.attachedLinkName("https://qa2.vytrack.com/user/login");
        BrowserUtils.wait(3);
        String urlExpected = "https://qa2.vytrack.com/user/login";
        BrowserUtils.wait(3);
        Assert.assertEquals(urlactual, urlExpected);

        test.pass("url attached successfully");
    }
}
//https://www.youtube.com/watch?v=niQ0A1xz0Os
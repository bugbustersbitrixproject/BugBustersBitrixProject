package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.EventTab;
import com.automation.bitrix.pages.activityStream.FileTab;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.BrowserUtils;

import org.openqa.selenium.WebElement;
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

        eventTab.sendSubmit();
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
        eventTab.sendSubmit();;
        BrowserUtils.wait(3);

        String urlactual = eventTab.attachedLinkName("https://qa2.vytrack.com/user/login");
        BrowserUtils.wait(3);
        String urlExpected = "https://qa2.vytrack.com/user/login";
        BrowserUtils.wait(3);
        Assert.assertEquals(urlactual, urlExpected);
        test.pass("url attached successfully");
    }

@Test(description = "User should be able to create a quote by clicking on the Comma icon")
    public void createQuote(){
    test = report.createTest("Attach Url Link");

    LoginPage loginPage = new LoginPage();
    loginPage.loginAs("help_desk2");
    test.info("Login successfully");
    EventTab eventTab = new EventTab();
    eventTab.navigateToTab("Event");
    test.info("Navigated to EventTab");
    BrowserUtils.wait(3);
    eventTab.clickQuoteIcon();
    eventTab.sendQuoteInput("Hello BugBusters");
    eventTab.sendSubmit();
    Assert.assertEquals(eventTab.getSendQuote(),"Hello BugBusters");

    test.pass("Quote created successfully");
    }

    @Test(description = "User should able to click Visual editor icon and see text_bar")
    public void visualEditor(){
        test = report.createTest("Attach Url Link");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("help_desk2");
        test.info("Login successfully");
        EventTab eventTab = new EventTab();
        eventTab.navigateToTab("Event");
        test.info("Navigated to EventTab");
        BrowserUtils.wait(3);
        eventTab.clickVisualEditor();
        BrowserUtils.wait(1);
        for(int i=0;i<eventTab.getText_bar().size();i++) {
            Assert.assertTrue(eventTab.getText_bar().get(i).isDisplayed());

        }
}
        @Test(description = "User should be able to add Event start and ending date and time, and specify the time zone.")
        public void dateEditor(){
            test = report.createTest("Attach Url Link");

            LoginPage loginPage = new LoginPage();
            loginPage.loginAs("help_desk2");
            test.info("Login successfully");
            EventTab eventTab = new EventTab();
            eventTab.navigateToTab("Event");
            test.info("Navigated to EventTab");
            BrowserUtils.wait(3);
            eventTab.setFromDate("05/23/2020");
            eventTab.setDateTo("05/23/2020");
            eventTab.setFromTime("10:30 am");
            eventTab.setTimeTo("11:30 pm");
            eventTab.chooseEventLocation("Central Meeting Room");
            eventTab.sendSubmit();
            String expected="05/23/2020, 10:30 am";
            String actual=eventTab.eventDateAndTime();
            Assert.assertEquals(actual,expected);
            String expectedRoom="Central Meeting Room";
            String actualRoom=eventTab.meetingLocation();
            Assert.assertEquals(actualRoom,expectedRoom);
//
}}

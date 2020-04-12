package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.EventTab;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.BrowserUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EventTabTest extends AbstractTestBase {
    @Test(description = "User should be able to click on upload files icon to upload files")
    public void test1(){


       LoginPage login=new LoginPage();
       login.loginAs("help_desk2");
       BrowserUtils.wait(4);
       EventTab eventPage = new EventTab();
       eventPage.uploadFileMethod();
    }
    @Test(description="User should be able to click on upload files icon to upload Bitrix24files")
     public void test2(){
        LoginPage login=new LoginPage();
        login.loginAs("help_desk2");
        BrowserUtils.wait(4);
        EventTab eventPage = new EventTab();
        eventPage.uploadFileFromBitrix24();
        Assert.assertTrue(eventPage.fileNameFromBitix24().equals(eventPage.uploodedFileName()));
    }


}

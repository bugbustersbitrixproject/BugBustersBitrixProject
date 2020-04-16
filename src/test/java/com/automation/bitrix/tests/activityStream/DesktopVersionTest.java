package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.DeviceVersionUpload;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DesktopVersionTest extends AbstractTestBase {
    /**
     * 11. User Story:
     * As a PC user, I should be able to download
     * Desktop version of the application.
     * AC 1: User should be able to click on Mac Os icon under Desktop
     * Client to download Mac version of Bitrix.
     * AC 2: User should be able to click on Windows icon under Desktop
     * Client to download Windows version of Bitrix.
     * AC 3: User should be able to click on Linux icon under Desktop
     * Client to download Linux version of Bitrix."
     */

    @Test
    public void chooseYourDevice() {
        test= report.createTest("Verify login as marketing1 user");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("marketing1");
        test.pass("Login Succeed");

        test = report.createTest("As a PC user should be able to download Desktop version of the application.");
       DeviceVersionUpload deviceVersion = new DeviceVersionUpload();
        deviceVersion.navigateTo("linuxIcon");
        BrowserUtils.wait(10);
        String expected = "GitHub - buglloc/brick: An open source Bitrix24 messenger client.";
        List<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        String actual = Driver.getDriver().switchTo().window(tabs.get(1)).getTitle();
        Assert.assertEquals(actual, expected);
        test.pass("Upload Succeed");

    }

}



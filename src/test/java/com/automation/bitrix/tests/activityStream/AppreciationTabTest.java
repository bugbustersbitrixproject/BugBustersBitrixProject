package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.AppreciationTab;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class AppreciationTabTest extends AbstractTestBase {

    @Test
    public void upload_download_test(){
        LoginPage loginPage=new LoginPage();
        AppreciationTab appreciationTab = new AppreciationTab();

        loginPage.loginAs("hr1");
        BrowserUtils.wait(3);
        appreciationTab.navigateTo("Appreciation");

        BrowserUtils.wait(3);


        appreciationTab.upload_random_recent_items_from_Bitrix24();


    }


}

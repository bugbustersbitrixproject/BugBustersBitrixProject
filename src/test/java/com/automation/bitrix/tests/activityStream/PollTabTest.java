package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.PollTab;
import com.automation.bitrix.tests.AbstractTestBase;
import org.testng.annotations.Test;

public class PollTabTest extends AbstractTestBase {

    @Test
    public void test() {
        test = report.createTest("abc0");
        LoginPage login = new LoginPage();
        login.loginAs("hr1");
        PollTab pollTab = new PollTab();
        pollTab.navigateToTab("Poll");
    }
}

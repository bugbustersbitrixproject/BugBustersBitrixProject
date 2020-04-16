package com.automation.bitrix.tests;

import com.automation.bitrix.pages.LoginPage;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends AbstractTestBase {
    @Test
    public void login() {
        test = report.createTest("verify login as a user");
        LoginPage loginpage = new LoginPage();
        loginpage.loginAs("help_desk1");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");
        test.pass("Login succeed");
    }
}

package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TaskTabTest extends AbstractTestBase {


    @Test
    public void test() {

        test = report.createTest("Verify user name");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr1");

        Driver.getDriver().findElement(By.id("microoPostFormLHE_blogPostForm")).click();
        Driver.getDriver().switchTo().frame(0);
        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.id("bx-b-uploadfile-blogPostForm")).click();
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.name("bxu_files[]")).sendKeys(System.getProperty("user.dir") + "/pom.xml");
        BrowserUtils.wait(2);
    }

    @Test
    public void test2() {
        test = report.createTest("Test");
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir") + "/pom.xml");
        Driver.getDriver().findElement(By.id("file-submit")).click();
    }
}

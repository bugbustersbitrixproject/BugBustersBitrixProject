package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.activityStream.EventTab;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventTabTest extends AbstractTestBase {


    @Test(description = "User should be able to click on upload files icon to upload files")
    public void test1() {
        String username = "helpdesk2@cybertekschool.com";//1=2
        String username2 = "marketing2@cybertekschool.com";//1=2
        String username3 = "hr2@cybertekschool.com";//1==2
        String password = "UserUser";
        Driver.getDriver().findElement(By.name("USER_LOGIN")).sendKeys(username3);
        Driver.getDriver().findElement(By.name("USER_PASSWORD")).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(4);
        EventTab eventPage = new EventTab();
        eventPage.uploadFileMethod();
    }

}
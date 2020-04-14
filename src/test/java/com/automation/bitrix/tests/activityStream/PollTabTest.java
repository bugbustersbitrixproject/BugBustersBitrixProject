package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.PollTabPage;
import com.automation.bitrix.tests.AbstractTestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PollTabTest extends AbstractTestBase {
LoginPage loginPage = new LoginPage();
PollTabPage poll = new PollTabPage();

@Test(priority = 0, description = "Verify that user can upload file from personal desktop")
    public void test1(){
    test= report.createTest("user can upload file from desktop");
    loginPage.loginAs("hr1");
    poll.navigateToTab("Poll");
    String filePath ="\"C:\\Users\\QCSS\\Desktop\\invitation.docx\"";
    String expectedFileName = "invitation";
    WebElement uploadedFile = poll.getUploadedFile();
   // Assert.assertTrue(poll.uploadFileFromDesktop(filePath, expectedFileName,uploadedFile));
   String str1 =poll.uploadFileFromDesktop(filePath, expectedFileName,uploadedFile).getText();
    Assert.assertTrue(str1.contains(expectedFileName));
    test.pass("verified that user can upload file from desktop");
}

@Test(priority =1, description = "Verify that user can upload file from personal desktop")
    public void test2(){
    test= report.createTest("user can upload image from desktop");
    loginPage.loginAs("hr1");
    poll.navigateToTab("Poll");
    String filePath ="\"C:\\Users\\QCSS\\Desktop\\kitten.jpg\"";
    String expectedFileName = "kitten";
    WebElement uploadedImage = poll.getUploadedImage();
    Assert.assertTrue(poll.uploadImageFromDesktop(filePath,expectedFileName,uploadedImage));
    test.pass("verified that user can upload image from desktop");
}
}

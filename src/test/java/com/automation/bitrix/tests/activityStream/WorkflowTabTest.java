package com.automation.bitrix.tests.activityStream;
import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.WorkflowTabPage;
import com.automation.bitrix.tests.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkflowTabTest extends AbstractTestBase{


    @Test
    public void accessToLeaveApproval() {
        test = report.createTest("Verify Leave Approval");
        LoginPage loginPage = new LoginPage();
        WorkflowTabPage workflowTabPage = new WorkflowTabPage();
        test.info("Login as marketing");
        loginPage.loginAs("marketing1");
        test.info("Go to workflow tab");
        workflowTabPage.navigateToTab("Workflow");
        test.info("Click on Leave Approval");
        workflowTabPage.navigateToSubModule("Leave Approval");
        test.info("Close window");
        workflowTabPage.clickCloseSymbol();
        test.info("Enter Start Date");
        workflowTabPage.enterStartDate();
        test.info("Enter End Date");
        workflowTabPage.enterEndDate();
        test.info("Choose Absence Type from dropdown");
        workflowTabPage.chooseAbsenceType();
        test.info("Enter reason for leave");
        workflowTabPage.reasonForLeave();
        test.info("Send your Leave Approval");
        workflowTabPage.clickSendBtn();
        Assert.assertEquals(workflowTabPage.approveMessage(),"Workflow parameters need to be configured.");
        test.pass("Workflow parameters need to be configured.");
    }
}




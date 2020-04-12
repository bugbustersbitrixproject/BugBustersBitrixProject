package com.automation.bitrix.tests.activityStream;
import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.WorkflowTabPage;
import com.automation.bitrix.tests.AbstractTestBase;
import org.testng.annotations.Test;

public class WorkflowTabTest extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    WorkflowTabPage workflowTabPage = new WorkflowTabPage();


    // This module  is not working.
    //After clicking send key, new page is not loading.
    @Test
    public void accessToLeaveApproval() {
        loginPage.loginAs("marketing1");
        workflowTabPage.navigateToTab("Workflow");
        workflowTabPage.navigateToSubModule("Leave Approval");
        workflowTabPage.clickCloseSymbol();
        workflowTabPage.enterStartDate();
        workflowTabPage.enterEndDate();
        workflowTabPage.chooseAbsenceType();
        workflowTabPage.reasonForLeave();
        workflowTabPage.clickSendBtn();

    }
}

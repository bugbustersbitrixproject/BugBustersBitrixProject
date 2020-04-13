package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.FilterAndSearchFunctionality;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import org.testng.annotations.Test;


public class FilterAndSearchTesting extends AbstractTestBase {


    LoginPage loginPage = new LoginPage();
    FilterAndSearchFunctionality functionality = new FilterAndSearchFunctionality();


    @Test(priority = 0)
    public void searchByDifferentFilters() {

        test = report.createTest("Verify search function with different filters");

        loginPage.loginAs("hr1");
        functionality.clickToFilterAndSearchBox();
        functionality.filters();

        test.pass("Search function with different filters verified");

    }

    @Test(priority = 1)
    public void searchByDifferentFields() {

        test = report.createTest("Verify search function with different fields");
        LoginPage loginPage = new LoginPage();
        FilterAndSearchFunctionality functionality = new FilterAndSearchFunctionality();
        loginPage.loginAs("hr1");
        BrowserUtils.wait(2);
        functionality.clickToFilterAndSearchBox();
        BrowserUtils.wait(1);
        functionality.searchByDate();
        functionality.searchByType();
        functionality.searchByAuthor();
        functionality.searchByTo();
        functionality.addField();

        test.pass("Search function with different fields verified");
    }

    @Test(priority = 2)
    public void searchFunction() {

        test = report.createTest("Verify search function");

        LoginPage loginPage = new LoginPage();
        FilterAndSearchFunctionality functionality = new FilterAndSearchFunctionality();
        loginPage.loginAs("hr1");
        functionality.searchFunction();

        test.pass("Search function verified");
    }

    @Test(priority = 3)
    public void saveFilterFunctionality() {

        test = report.createTest("Verify save filter functionality");

        LoginPage loginPage = new LoginPage();
        FilterAndSearchFunctionality functionality = new FilterAndSearchFunctionality();
        loginPage.loginAs("hr1");
        functionality.saveFilterSettings();

        test.pass("Save filter functionality verified");
    }

}

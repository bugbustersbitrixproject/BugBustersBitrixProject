package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class FilterAndSearchFunctionality extends AbstractPageBase {

    @FindBy(css = "#LIVEFEED_search")
    private WebElement searchBox;

    @FindBy(xpath = "//*[text()='Work']")
    private WebElement filterByWork;

    @FindBy(xpath = "//div[@class = 'main-ui-filter-sidebar-item']//*[text()='Favorites'][1]")
    private WebElement filterByFavorites;

    @FindBy(xpath = "//*[text()='My Activity']")
    private WebElement filterByMyActivity;

    @FindBy(xpath = "//div[@class = 'main-ui-filter-sidebar-item']//*[text()='Announcements']")
    private WebElement filterByAnnouncement;

    @FindBy(xpath = "//div[@class = 'main-ui-filter-sidebar-item']//*[text()='Workflows']")
    private WebElement filterByWorkflows;

    @FindBy(xpath = "(//span[@class='main-ui-item-icon main-ui-delete'])[1]")
    private WebElement defaultMenu;

    @FindBy(xpath = "//span[text()='Any date']")
    private WebElement searchByDate;

    @FindBy(xpath = "//span[text()='Current day']")
    private WebElement currentDay;

    @FindBy(xpath = "//div[@class = 'main-ui-control main-ui-multi-select']")
    private WebElement searchByType;

    @FindBy(xpath = "//div[@class = 'main-ui-control main-ui-multi-select main-ui-focus']")
    private WebElement searchByType2;

    @FindBy(xpath = "//span[@class = 'main-ui-square']")
    private WebElement calendar;

    @FindBy(xpath = "(//span[@class = 'main-ui-square-search']//input)[3]")
    private WebElement searchByAuthor;

    @FindBy(xpath = "(//span[@class = 'main-ui-square-search']//input)[4]")
    private WebElement searchByTo;

    @FindBy(xpath = "(//div[@class='main-ui-square-item'])[2]")
    private WebElement allEmployees;

    @FindBy(xpath = "(//div[@class = 'main-ui-control main-ui-select'])[2]")
    private WebElement searchByFavorites;

    @FindBy(xpath = "(//input[@class = 'main-ui-control main-ui-control-string'])[3]")
    private WebElement searchByTag;

    @FindBy(xpath = "(//div[@class = 'main-ui-control main-ui-select'])[3]")
    private WebElement searchByExtranet;

    @FindBy(xpath = "//span[@class = 'main-ui-filter-field-add-item']")
    private WebElement addField;

    @FindBy(xpath = "//span[@title = 'Extranet']")
    private WebElement emptySpace;

    @FindBy(xpath = "//div[text()='Favorites']")
    private WebElement addFavoritesField;

    @FindBy(xpath = "//div[text()='Tag']")
    private WebElement addTagField;

    @FindBy(xpath = "//div[text()='Extranet']")
    private WebElement addFieldExtranet;

    @FindBy(xpath = "//span[text()='Save filter']")
    private WebElement saveFilterFunction;

    @FindBy(xpath = "//input[@class='main-ui-filter-sidebar-edit-control']")
    private WebElement setFilterNameFunction;

    @FindBy(xpath = "//span[@class='ui-btn ui-btn-success main-ui-filter-field-button main-ui-filter-save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[text()='Restore default fields']")
    private WebElement defaultFields;

    // opening search box options
    public void clickToFilterAndSearchBox() {
        BrowserUtils.wait(2);
        searchBox.click();
    }

    //trying different filters
    public void filters() {
        List<WebElement> listOfFilters = Arrays.asList(filterByWork, filterByFavorites, filterByMyActivity, filterByAnnouncement, filterByWorkflows);
        for (WebElement listOfFilter : listOfFilters) {
            BrowserUtils.wait(1);
            listOfFilter.click();
            BrowserUtils.wait(1);
            searchBox.click();
            BrowserUtils.wait(1);

        }
    }

    public void searchByDate() {
        BrowserUtils.wait(3);
        defaultFields.click();
        BrowserUtils.wait(3);
        searchByDate.click();
        BrowserUtils.wait(1);
        searchByDate.click();
        BrowserUtils.wait(1);
    }

    public void searchByType() {
        BrowserUtils.wait(1);
        searchByType.click();
        BrowserUtils.wait(1);
        searchByType2.click();
        BrowserUtils.wait(1);
    }

    public void searchByAuthor() {
        BrowserUtils.wait(1);
        searchByAuthor.sendKeys("hr99@cybertekschool.com", Keys.ENTER);
        BrowserUtils.wait(1);
    }

    public void searchByTo() {
        searchByTo.sendKeys("Marufjon", Keys.ENTER);
        BrowserUtils.wait(1);

    }


    public void addField() {
        addField.click();
        BrowserUtils.wait(1);
        addFavoritesField.click();
        BrowserUtils.wait(1);
        addTagField.click();
        BrowserUtils.wait(1);
        addFieldExtranet.click();
        BrowserUtils.wait(1);
        addField.click();
        BrowserUtils.wait(2);
        searchByFavorites.click();
        BrowserUtils.wait(1);
        searchByFavorites.click();
        BrowserUtils.wait(1);
        searchByTag.sendKeys("BugBusters");
        BrowserUtils.wait(1);
        searchByExtranet.click();
        BrowserUtils.wait(1);
    }

    public void searchFunction() {
        searchBox.sendKeys("Cucumber");
    }

    public void saveFilterSettings() {
        searchBox.click();
        BrowserUtils.wait(1);
        saveFilterFunction.click();
        setFilterNameFunction.sendKeys("Group-3");
        BrowserUtils.wait(1);
        saveButton.click();
        BrowserUtils.wait(1);
    }
}

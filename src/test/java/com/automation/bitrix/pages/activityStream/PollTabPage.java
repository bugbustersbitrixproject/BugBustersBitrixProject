package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PollTabPage extends AbstractPageBase {

    @FindBy(xpath = "body[contenteditable='true']")
    protected WebElement emailTextBox;

    public static void main(String[] args) {

    }
}

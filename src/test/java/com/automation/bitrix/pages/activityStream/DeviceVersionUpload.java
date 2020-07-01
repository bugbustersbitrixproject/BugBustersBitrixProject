package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeviceVersionUpload extends AbstractPageBase {
    /**
     * 11. User Story:
     * As a PC user, I should be able to download
     * Desktop version of the application.
     *
     * AC 1: User should be able to click on Mac Os icon under Desktop
     * Client to download Mac version of Bitrix.
     * AC 2: User should be able to click on Windows icon under Desktop
     * Client to download Windows version of Bitrix.
     * AC 3: User should be able to click on Linux icon under Desktop
     * Client to download Linux version of Bitrix."
     */

    @FindBy(xpath ="//span[text()='Mac OS']/preceding-sibling::span")
    private WebElement macIcon;

    @FindBy(xpath = "//span[text()='Windows']/preceding-sibling::span")
    private WebElement windowsIcon;

    @FindBy(xpath = "//span[text()='Linux']/preceding-sibling::span")
    private WebElement linuxIcon;

    @FindBy(xpath = "//div[text()='Desktop client']")
    private WebElement desktopClient;


    public void navigateTo(String deviceIcon) {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.scrollTo(desktopClient);
        switch (deviceIcon) {
            case "macIcon":
                macIcon.click();
                break;
            case "windowsIcon":
                windowsIcon.click();
                break;
            case "linuxIcon":
                linuxIcon.click();
                break;

            default:
                throw new RuntimeException("Invalid navigation for device icon");

        }
    }
}



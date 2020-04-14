package com.automation.bitrix.pages;

<<<<<<< HEAD
=======
import com.automation.utilities.BrowserUtils;
>>>>>>> 218558cc75200978fd0ce3a8c4c6bb2f10131751
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "USER_LOGIN")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(id = "USER_REMEMBER")
    private WebElement rememberMe;

    @FindBy(className = "login-btn")
    private WebElement login;

    @FindBy(className = "login-link-forgot-pass")
    private WebElement forgotPassword;

    @FindBy(name = "USER_EMAIL")
    private WebElement loginWithEmail;

    @FindBy(className = "login-links")
    private WebElement authorization;

    @FindBy(className = "login-btn")
    private WebElement resetPassword;

<<<<<<< HEAD
=======
    @FindBy(name = "USER_LOGIN")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(id = "USER_REMEMBER")
    private WebElement rememberMe;

    @FindBy(className = "login-btn")
    private WebElement login;

    @FindBy(className = "login-link-forgot-pass")
    private WebElement forgotPassword;

    @FindBy(name = "USER_EMAIL")
    private WebElement loginWithEmail;

    @FindBy(className = "login-links")
    private WebElement authorization;

    @FindBy(className = "login-btn")
    private WebElement resetPassword;

>>>>>>> 218558cc75200978fd0ce3a8c4c6bb2f10131751
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void loginAs(String userValue, String passwordValue) {
        userName.sendKeys(userValue);
        password.sendKeys(passwordValue);
        login.click();

    }

    public void loginAs(String userType) {

        userName.sendKeys(ConfigurationReader.getProperty(userType));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();

    }

}


<<<<<<< HEAD
=======

>>>>>>> 218558cc75200978fd0ce3a8c4c6bb2f10131751

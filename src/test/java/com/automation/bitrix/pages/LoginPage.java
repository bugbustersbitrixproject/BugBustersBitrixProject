package com.automation.bitrix.pages;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


        @FindBy(name = "USER_LOGIN")
        private WebElement userName;

        @FindBy(name="USER_PASSWORD")
        private WebElement password;

        @FindBy(id = "USER_REMEMBER")
        private WebElement rememberMe;

        @FindBy(className = "login-btn")
        private WebElement login;

        @FindBy(className = "login-link-forgot-pass")
        private WebElement forgotPassword;

        @FindBy(name="USER_EMAIL")
        private WebElement loginWithEmail;

        @FindBy(className = "login-links")
        private WebElement authorization;

        @FindBy(className = "login-btn")
        private WebElement resetPassword;

        public LoginPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }


        public void loginHelp_desk1(){
            userName.sendKeys(ConfigurationReader.getProperty("help_desk1"));
            password.sendKeys(ConfigurationReader.getProperty("password"));

        }

        public void loginHelp_desk2(){
            userName.sendKeys(ConfigurationReader.getProperty("help_desk2"));
            password.sendKeys(ConfigurationReader.getProperty("password"));

        }

        public void loginMarketing1(){
            userName.sendKeys(ConfigurationReader.getProperty("marketing1"));
            password.sendKeys(ConfigurationReader.getProperty("password"));

        }

        public void loginMarketing2(){
            userName.sendKeys(ConfigurationReader.getProperty("marketing2"));
            password.sendKeys(ConfigurationReader.getProperty("password"));

        }

        public void loginHr1(){
            userName.sendKeys(ConfigurationReader.getProperty("hr1"));
            password.sendKeys(ConfigurationReader.getProperty("password"));

        }

        public void loginHr2(){
            userName.sendKeys(ConfigurationReader.getProperty("hr2"));
            password.sendKeys(ConfigurationReader.getProperty("password"));

        }

        public void loginAs(String userValue, String passwordValue){
            userName.sendKeys(userValue);
            password.sendKeys(passwordValue);
            login.click();

        }

    }
//


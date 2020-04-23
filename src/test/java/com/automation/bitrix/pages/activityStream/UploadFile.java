package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;



public class UploadFile extends AbstractPageBase {

public void uploadFileImage(){
    WebElement uploadFile = driver.findElement(By.xpath("//input[@name='bxu_files[]' ]"));
    //String filePath = "C:/Users/semra/OneDrive/Masaüstü";
    String filePath = "C:\\Users\\semra\\IdeaProjects\\BugBustersBitrixProject\\Capture.PNG";
    uploadFile.sendKeys(filePath);

    driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();
}

    }



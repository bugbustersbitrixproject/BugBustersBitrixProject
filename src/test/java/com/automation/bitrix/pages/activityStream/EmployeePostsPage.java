package com.automation.bitrix.pages.activityStream;

import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

//User story 10-AC1
//1. User should be able to make a comment, like, or unfollow on other employees' posts.

public class EmployeePostsPage extends AbstractPageBase {


    @FindBy(linkText = "Like")
    private WebElement like;

    @FindBy(xpath = "//a[text()='Like']")
    private List<WebElement> likes;

    @FindBy(css = "[id^='bx-ilike-top-users']")
    private WebElement likeResult;

    @FindBy(linkText = "Comment")
    private WebElement commentButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement iframeCommentBox;

    @FindBy(xpath = "//body[@contenteditable='true']")
    private WebElement iframeBody;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-sm ui-btn-primary' and (text()='Send')]")    //kamran [id^="lhe_button_submit_blogCommentForm"]
    private  WebElement sendButton;

    @FindBy(xpath = "((//div[@class='feed-item-wrap'])[1]//div[@class='feed-com-text'])[last()]")
    private WebElement commentResult;


    @FindBy(css = "span[id^='log_entry_follow']")
   // @FindBy(linkText = "Unfollow")
    private WebElement followUnFollow;


    public void clickLike(){

        like.click();
        BrowserUtils.wait(1);
    }

    public void clickLikeRandomly(){
         Random random=new Random();
         int randomIndexNum=random.nextInt(likes.size());
         likes.get(randomIndexNum).click();
         BrowserUtils.wait(2);

    }

    public String  getTextLikeResult(){

       return likeResult.getText();

    }

    public void clickUnFollow(){

       followUnFollow.click();
    }

    public String getTextFollowUnFollowResult(){

        return followUnFollow.getText();
    }



    public void comment(String message){

        commentButton.click();
        driver.switchTo().frame(iframeCommentBox);
        iframeBody.sendKeys(message);
        driver.switchTo().defaultContent();
        sendButton.click();



    }

    public String getTextCommentResult(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//div[@class='feed-item-wrap'])[1]//div[@class='feed-com-text'])[last()]")));
        return commentResult.getText();
    }








}

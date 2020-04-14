package com.automation.bitrix.tests.activityStream;

import com.automation.bitrix.pages.LoginPage;
import com.automation.bitrix.pages.activityStream.EmployeePostsPage;
import com.automation.bitrix.tests.AbstractTestBase;
import com.automation.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//User story 10-AC1
//1. User should be able to make a comment, like, or unfollow on other employees' posts.
public class EmployeePostsTest extends AbstractTestBase {




       @Test(dataProvider = "loginCredentials")
       public void likeTest(String userName, String password){

              //if you have more one test, and 1st pass but others failing,
              //you are getting session id is null exception
              //because driver object was not initialized in time
              //just create page objects inside a test
              LoginPage loginPage=new LoginPage();
              EmployeePostsPage employeePostsPage=new EmployeePostsPage();

              test=report.createTest("Like other users posts");
              loginPage.loginAs(userName,password);
              test.info("login with "+userName+" credential");

<<<<<<< HEAD
              if(!employeePostsPage.getTextLikeResult().contains("You")){
                     employeePostsPage.clickLike();
                    // employeePostsPage.clickLikeRandomly();
=======
              //int index=employeePostsPage.randomNumber();

              if(!employeePostsPage.getTextLikeResult().contains("You")){
                     employeePostsPage.clickLike();
>>>>>>> 218558cc75200978fd0ce3a8c4c6bb2f10131751
                     test.info("user clicked like button");
              }else{
                     employeePostsPage.clickLike();
                     employeePostsPage.clickLike();
              }



              Assert.assertTrue(employeePostsPage.getTextLikeResult().contains("You"));

              test.pass("user able to click LIKE button");

             //employeePostsPage.clickLike();// clicked again to unlike for next test to not fail

       }

       @DataProvider
       public Object[][] loginCredentials(){
              return new Object[][]{
                      {"helpdesk29@cybertekschool.com","UserUser"},
                      {"helpdesk30@cybertekschool.com", "UserUser"},
                      {"marketing29@cybertekschool.com","UserUser"},
                      {"marketing30@cybertekschool.com","UserUser"},
                      {"hr29@cybertekschool.com","UserUser"},
                      {"hr30@cybertekschool.com","UserUser"}
              };
       }


       @Test(dataProvider = "loginCredentials")
       public  void unFollowTest(String username, String password){

              LoginPage loginPage=new LoginPage();
              EmployeePostsPage employeePostsPage=new EmployeePostsPage();

              test= report.createTest("Unfollowing other users post");

              loginPage.loginAs(username,password);
              test.info("login with "+username+" credential");

              if(employeePostsPage.getTextFollowUnFollowResult().equals("Unfollow")) {
                     employeePostsPage.clickUnFollow();
                     test.info("user clicked unfollow");
              }else{
                     employeePostsPage.clickUnFollow();
                     test.info("user clicked follow");
                     employeePostsPage.clickUnFollow();
                     test.info("user clicked unfollow");

              }

              Assert.assertEquals(employeePostsPage.getTextFollowUnFollowResult(),"Follow");


             test.pass("user can unfollow other users post");




       }

       @Test(dataProvider = "loginCredentials")
       public void makeComment(String username,String password){

              LoginPage loginPage=new LoginPage();
              EmployeePostsPage employeePostsPage=new EmployeePostsPage();

              test=report.createTest("User making comments");

              loginPage.loginAs(username,password);
              test.info("login with "+username+" credential");

             String commentMessage= ConfigurationReader.getProperty("message");
              employeePostsPage.comment(commentMessage);
              test.info("User is making comment");

              Assert.assertEquals(employeePostsPage.getTextCommentResult(),commentMessage);

              test.pass("user is able to make comment successfully under other employees posts");


       }



}

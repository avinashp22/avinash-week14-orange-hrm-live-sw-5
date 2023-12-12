package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ViewSystemUsersPage viewSystemUsersPage = new ViewSystemUsersPage();
    AddUserPage addUserPage = new AddUserPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }

    @Test  (groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        // Login to Application
        loginPage.loginSuccessfully("Admin", "admin123");
        //click On "Admin" Tab
        homePage.clickOnAdmin();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifyTextSystemUsers(), "System Users");
        //click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        //Verify "Add User" Text
        Assert.assertEquals(addUserPage.verifyTextAddUser(), "Add User");
        //Select User Role "Admin"
        viewSystemUsersPage.selectUserRoll();
        //enter Employee Name "Ananya Dash"
        viewSystemUsersPage.enterEmployeeName("Ananya Dash");
        //enter Username
        viewSystemUsersPage.enterUserName("Ananya.Dash");
        //Select status "Disable"
        viewSystemUsersPage.selectStatusFromDropdown();
        //enter password
        addUserPage.enterPassword("Admin321");
        //enter Confirm Password
        addUserPage.enterConfirmPassword("Admin321");
        //click On "Save" Button
        addUserPage.clickOnSaveButton();
        //verify message "Successfully Saved"
        String expectedMessage = "Successfully Saved";
        String actualMessage = addUserPage.verifyTextSuccessfullySaved();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test (groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        //Login to Application
        loginPage.loginSuccessfully("Admin", "admin123");
        //click On "Admin" Tab
        homePage.clickOnAdmin();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifyTextSystemUsers(), "System Users");
        //Enter Username
        viewSystemUsersPage.enterUserName("Ananya.Dash");
        //Select User Role
        viewSystemUsersPage.selectUserRoll();
        //Select Status
        viewSystemUsersPage.selectStatusFromDropdown();
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        //Verify the User should be in Result list.

        }


    @Test (groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        // Login to Application
        loginPage.loginSuccessfully("Admin", "admin123");
        //click On "Admin" Tab
        homePage.clickOnAdmin();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifyTextSystemUsers(), "System Users");
        //Enter Username
        viewSystemUsersPage.enterUserName("Ananya.Dash");
        //Select User Role
        viewSystemUsersPage.selectUserRoll();
        //Select Status
        viewSystemUsersPage.selectStatusFromDropdown();
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        String actual = driver.findElement(By.xpath("//div[normalize-space()='Ananya Dash']")).getText();
        String expected = "Ananya Dash";
        Assert.assertEquals(actual, expected);
        //Click on Check box
        viewSystemUsersPage.tickOnCheckBox();
        //Click on Delete Button
        viewSystemUsersPage.clickOnDeleteButton();
        //Popup will display
        viewSystemUsersPage.notifyAll();
        //Click on Ok Button on Popup
        viewSystemUsersPage.acceptAlert();
        //verify message "Successfully Deleted"
        Assert.assertEquals(viewSystemUsersPage.getTextFromAlert(), "Successfully Deleted");
    }



    @Test (groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageRecordFound(){
        // Login to Application
        loginPage.loginSuccessfully("Admin", "admin123");
        //click On "Admin" Tab
        homePage.clickOnAdmin();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifyTextSystemUsers(), "System Users");
        //Enter Username
        viewSystemUsersPage.enterUserName("Dominic.Chase");
        //Select User Role
        viewSystemUsersPage.selectUserRoll();
        //Enter EmployeeName <employeeName>
        viewSystemUsersPage.enterEmployeeName("Dominic Chase");
        //Select Status <status>
        viewSystemUsersPage.selectStatusFromDropdown();
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        //verify message "(1) Record Found"
        Assert.assertEquals(viewSystemUsersPage.verifyTextRecordFound(), "(1) Record Found");
        //Verify username <username>
        Assert.assertEquals(viewSystemUsersPage.verifyTextAdmin(), "Admin");
        //Click on Reset Tab
        viewSystemUsersPage.clickOnResetButton();
    }

}

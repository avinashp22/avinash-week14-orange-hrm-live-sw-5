package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void adminShouldAddUserSuccessFully() {


    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() {



        }


    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {



    }

    @Test
    public void searchTheUserAndVerifyTheMessageRecordFound() {



    }

}

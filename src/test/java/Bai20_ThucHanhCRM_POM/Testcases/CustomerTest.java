package Bai20_ThucHanhCRM_POM.Testcases;

import Bai20_ThucHanhCRM_POM.Pages.BasePage;
import Bai20_ThucHanhCRM_POM.Pages.CustomerPage;
import Bai20_ThucHanhCRM_POM.Pages.LoginPage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM();

        customerPage = new CustomerPage(driver);
        customerPage.clickMenuCustomerpage();

//        customerPage.verifyRedirectToCustomerPage();
//        int beforeTotal = customerPage.getTotalCus();
//
//        customerPage.clickButtonAddNewCustomer();
//        customerPage.submitDataForNewCustomer("[Ha Le] Company ABC 018");
//
//        customerPage.clickMenuCustomerpage();
//        int afterTotal = customerPage.getTotalCus();
//        Assert.assertEquals(afterTotal,beforeTotal + 1,"The total customer is incorrect");

        customerPage.searchCreateCustomer("[Ha Le] Company ABC 018");

        customerPage.clickOnCreatedCustomer();
        customerPage.verifyCreatedCustomerDetail("[Ha Le] Company ABC 018");

    }
}

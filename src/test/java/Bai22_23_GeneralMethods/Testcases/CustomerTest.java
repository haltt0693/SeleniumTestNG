package Bai22_23_GeneralMethods.Testcases;

import Bai22_23_GeneralMethods.Pages.CustomerPage;
import Bai22_23_GeneralMethods.Pages.LoginPage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    CustomerPage customerPage;
    String Customer_name = "[Ha Le] Company ABC 08152025HA004";

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM();

        customerPage = new CustomerPage(driver);
        customerPage.clickMenuCustomerpage();

        customerPage.verifyRedirectToCustomerPage();
        int beforeTotal = customerPage.getTotalCus();

//        customerPage.clickButtonAddNewCustomer();
//        customerPage.submitDataForNewCustomer(Customer_name);

//        customerPage.clickMenuCustomerpage();
//        int afterTotal = customerPage.getTotalCus();
//        Assert.assertEquals(afterTotal,beforeTotal + 1,"The total customer is incorrect");

        customerPage.searchCreateCustomer(Customer_name);

        customerPage.clickOnCreatedCustomer();
        customerPage.verifyCreatedCustomerDetail(Customer_name);

    }
}

package Bai20_ThucHanhCRM_POM.Testcases;

import Bai20_ThucHanhCRM_POM.Pages.DashboardPage;
import Bai20_ThucHanhCRM_POM.Pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testCheckDashboardTotal() throws InterruptedException {
        loginPage = new LoginPage(driver);
//        loginPage.loginCRM();
//
//        dashboardPage = new DashboardPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("1 / 3");

    }

}

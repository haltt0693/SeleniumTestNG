package Bai19_PageNavigations.Testcases;

import Bai19_PageNavigations.Pages.DashboardPage;
import Bai19_PageNavigations.Pages.LoginPage;
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

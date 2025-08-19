package Bai22_23_GeneralMethods.Testcases;

import Bai22_23_GeneralMethods.Pages.DashboardPage;
import Bai22_23_GeneralMethods.Pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testCheckDashboardTotal() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("1 / 3");

    }

}

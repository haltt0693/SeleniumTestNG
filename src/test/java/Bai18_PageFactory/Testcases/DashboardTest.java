package Bai18_PageFactory.Testcases;


import Bai18_PageFactory.Pages.DashboardPage;
import Bai18_PageFactory.Pages.LoginPage;
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
        dashboardPage.getMenuList();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("0 / 3");

    }

}

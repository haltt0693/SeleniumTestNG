package Bai19_PageNavigations.Testcases;

import Bai19_PageNavigations.Pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginSuccess() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.testLoginCRM("admin@example.com","123456");
        Thread.sleep(1000);
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid() throws InterruptedException {
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.testLoginCRM("admin123@example.com", "123456");
//        Thread.sleep(1000);
        loginPage.verifyLoginFail();
    }
}

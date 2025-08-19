package Bai17_PageObjectModel.Testcases;

import Bai17_PageObjectModel.Pages.LoginPage;
import KeyWords.WebUI;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginSuccess() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.testloginCRM("admin@example.com","123456");
        Thread.sleep(1000);
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid() throws InterruptedException {
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.testloginCRM("admin123@example.com", "123456");
//        Thread.sleep(1000);
        loginPage.verifyLoginFail();
    }
}

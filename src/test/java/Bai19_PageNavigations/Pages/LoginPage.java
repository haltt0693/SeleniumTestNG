package Bai19_PageNavigations.Pages;

import KeyWords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //driver = _driver;
        new WebUI(driver);//Khoi tao gia tri driver cho class WebUI

    }

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");


    private void setEmail(String email) {

        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {

        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {

        driver.findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess() {

        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Content of error massage NOT match.");
    }

    //Các hàm xử lý cho chính trang này
    public void testLoginCRM(String email, String password){
        //https://crm.anhtester.com/admin/authentication
//        driver.get("https://crm.anhtester.com/admin/authentication"); //Gọi từ class ConfigData dạng biến static
//        setEmail(email);
//        setPassword(password);
//        clickLoginButton();

        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
//        Thread.sleep(1000);
        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage loginCRM(){
//        //https://crm.anhtester.com/admin/authentication
////        driver.get("https://crm.anhtester.com/admin/authentication"); //Gọi từ class ConfigData dạng biến static
////        setEmail("admin@example.com");
////        setPassword("123456");
////        clickLoginButton();
        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        return new DashboardPage(driver);
    }

    public void loginCRM_1() {
        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");

        WebUI.clickElement(buttonLogin);

    }

}

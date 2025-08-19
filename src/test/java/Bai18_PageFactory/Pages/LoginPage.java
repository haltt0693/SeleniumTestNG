package Bai18_PageFactory.Pages;

import KeyWords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //driver = _driver;
        PageFactory.initElements(driver, this);//Khai bao Page Factory

    }

    //Khai báo các element dạng đối tượng WebElement
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerPage;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//div[@id='alerts']")
    private WebElement errorMessage;

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li[contains(@class,'menu-item')]"))
    private List<WebElement> menuElements;



    private void setEmail(String email) {

        inputEmail.sendKeys(email);
    }

    private void setPassword(String password) {

        inputPassword.sendKeys(password);
    }

    private void clickLoginButton() {

        buttonLogin.click();
    }

    public void verifyLoginSuccess() {

        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Content of error massage NOT match.");
    }

    //Các hàm xử lý cho chính trang này
    public void testLoginCRM(String email, String password) throws InterruptedException {
        https://crm.anhtester.com/admin/authentication
        driver.get("https://crm.anhtester.com/admin/authentication"); //Gọi từ class ConfigData dạng biến static
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void loginCRM() throws InterruptedException {
        https://crm.anhtester.com/admin/authentication
        driver.get("https://crm.anhtester.com/admin/authentication"); //Gọi từ class ConfigData dạng biến static
        setEmail("admin@example.com");
        setPassword("123456");
        clickLoginButton();
    }

}

package Bai11_Assertions;

import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demo_SoftAssert extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Login")
    public void testLoginSuccess() throws InterruptedException {

        driver.get("https://crm.anhtester.com/admin/authentication");

        //Kiem tra doi tuong header vaf gia tri header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(), "Header is not displayed");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(), "Login123", "Gia tri header khong dung");

        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        softAssert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(), "Menu Dashboard is not displayed");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).getText(),"Dashboard001","Menu Dashboard is incorrect");

        softAssert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.labelInvoincesAwaitingPayment)).getText().contains("Invoic123"),"sai oi ne");

        softAssert.assertAll();
    }

}

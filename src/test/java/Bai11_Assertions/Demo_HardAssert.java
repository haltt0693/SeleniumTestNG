package Bai11_Assertions;

import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_HardAssert extends BaseTest {
    @Test(description = "Login")
    public void testLoginSuccess() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Kiem tra doi tuong header vaf gia tri header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(),"Header is not displayed");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(),"Login","Gia tri header khong dung");

        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(),"Menu Dashboard is not displayed");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).getText(),"Dashboard","Menu Dashboard is incorrect");

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.labelInvoincesAwaitingPayment)).getText().contains("Invoice1"),"sai oi ne");//dung CONTAINS cua JAVA


    }
}

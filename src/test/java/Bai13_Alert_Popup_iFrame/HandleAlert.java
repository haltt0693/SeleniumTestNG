package Bai13_Alert_Popup_iFrame;

import common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HandleAlert extends BaseTest {
    @Test
    public void demoHandleAlertAccept() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);

        //Click vào nút "Click Me" thứ nhất
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Thread.sleep(1000);

//        //Khởi tạo class Alert
//        Alert alert1 = driver.switchTo().alert();
//        //Dùng hàm accept() để xác nhận Alert (tương ứng click vào nút OK)
//        alert1.accept();

        driver.switchTo().alert().accept();

        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertAppearAfter5s() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);

        //Click vào nút "Click Me" thứ nhất
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
        Thread.sleep(6000);

//        //Khởi tạo class Alert
//        Alert alert1 = driver.switchTo().alert();
//        //Dùng hàm accept() để xác nhận Alert (tương ứng click vào nút OK)
//        alert1.accept();

        driver.switchTo().alert().accept();

        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertDismiss() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);
// Scroll to element
        WebElement element = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        //Click vào nút "Click Me" thứ nhất
        element.click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();
        //Dùng hàm accept() để xác nhận Alert (tương ứng click vào nút OK)
        alert2.accept();

//        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='confirmResult']")).isDisplayed(),"Chua nhan dc nut");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText(),"You selected Cancel","Chua nhan dc nut");

        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertInputText() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        //Mở Alert Input text, click nút Click Me thứ ba
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Thread.sleep(2000);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();

        System.out.println(alert3.getText());
        alert3.sendKeys("Selenium");
        alert3.accept();



        Thread.sleep(2000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@id='promptResult']")).getText(),
                "You entered Selenium",
                "Chưa điền được text");

        Thread.sleep(1000);
        softAssert.assertAll();
    }
}

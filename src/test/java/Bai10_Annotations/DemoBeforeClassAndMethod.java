package Bai10_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class DemoBeforeClassAndMethod extends SetupClass{

    @Test(priority = 2, description = "demo 001")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("kenh14", Keys.ENTER);
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//h3[contains(text(),'Kênh tin tức giải trí - Xã hội - Kenh14.vn')]")).click();
//        Thread.sleep(2000);

    }


}

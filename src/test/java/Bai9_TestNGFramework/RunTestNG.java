package Bai9_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunTestNG {


    WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("kenh14", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[contains(text(),'Kênh tin tức giải trí - Xã hội - Kenh14.vn')]")).click();
        Thread.sleep(2000);

//        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Kênh tin tức giải trí - Xã hội - Kenh14.vn')]")).isDisplayed());

//        Bi show robot, ko tu dong chay
//        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("anhtester", Keys.ENTER);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']")).click();
//        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}


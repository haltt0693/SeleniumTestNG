package Bai13_Alert_Popup_iFrame;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleiFrame extends BaseTest {
    @Test
    public void totaliFrame() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);
        int sizeIFrame = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total: " + sizeIFrame);

        WebElement element = driver.findElement(By.xpath("//iframe[@id='frame2"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        driver.switchTo().frame(element);
        System.out.println(element.getText());
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Frames']")).getText());
        Thread.sleep(1000);
    }



}

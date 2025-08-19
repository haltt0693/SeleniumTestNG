package Bai13_Alert_Popup_iFrame;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleWindowPopup extends BaseTest {
    @Test
    public void testOpeninNewTab() {
        driver.get("https://anhtester.com");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://google.com");
    }

    @Test
    public void testOpeninNewWindow() {
        driver.get("https://anhtester.com");

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://google.com");
    }

    @Test
    public void demoNotSwitchToTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//button[@id='tabButton']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
        Thread.sleep(1000);
        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        Thread.sleep(1000);
    }

    @Test
    public void demoHandlePopupTypeTabWithForInterator() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        Thread.sleep(1000);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set < String > windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window: windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                Thread.sleep(1000);
                System.out.println("Đã chuyển đến Tab Window mới");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                Thread.sleep(1000);
                //Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

                // Tắt cái Tab Window mới.
                Thread.sleep(1000);
                driver.close();
            }
        }
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(1000);
    }


    @Test
    public void demoHandlePopupTypeTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath("//button[@id='tabButton']"));
        WebElement element2 = driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement element3 = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element1);
        element1.click();
        js.executeScript("arguments[0].scrollIntoView(true);", element2);
        element2.click();
        js.executeScript("arguments[0].scrollIntoView(true);", element3);
        element3.click();
        Thread.sleep(1000);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println("MainWindow: " + MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();
//        String firstWindow = (String) windows.toArray()[0]; //Cửa sổ đầu
        String secondWindow = (String) windows.toArray()[1]; //Cửa sổ thứ hai
        String thirdWindow = (String) windows.toArray()[2];
        String fourWindow = (String) windows.toArray()[3];
        System.out.println("Window 2: "+ secondWindow);
        System.out.println("Window 3: "+ thirdWindow);
        System.out.println("Window 4: "+ fourWindow);

        driver.switchTo().window(secondWindow);


        Thread.sleep(1000);
        System.out.println("Đã chuyển đến Tab Window mới");

        //Một số hàm hỗ trợ
        System.out.println("Title of new window: " + driver.switchTo().window(secondWindow).getTitle());
        System.out.println("URL of new window: " + driver.switchTo().window(secondWindow).getCurrentUrl());

        Thread.sleep(1000);
        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println("Header of page: " + driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

        // Tắt cái Tab Window mới.
        Thread.sleep(1000);
        driver.close();
// Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(1000);
    }
}


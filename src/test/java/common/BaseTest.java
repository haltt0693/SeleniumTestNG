package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Arrays;

public class BaseTest {

    public WebDriver driver;


    @BeforeMethod
    @Parameters ({"browser"})
    public void createDriver(String browser) {
        //Ẩn thanh "Chrome is being controlled..."
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
//        options.setExperimentalOption("useAutomationExtension", false);
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                System.out.println("Khoi chay trinh duyet Chrome...");
                break;

            case "edge":
                driver = new EdgeDriver();
                System.out.println("Khoi chay trinh duyet Edge...");
                break;

            case "firefox":
                driver = new FirefoxDriver();
                System.out.println("Khoi chay trinh duyet Firefox...");
                break;

            default:
                driver = new ChromeDriver();
                System.out.println("Khoi chay trinh duyet Chrome mac dinh...");
                break;
        }

//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}

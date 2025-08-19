package Bai20_ThucHanhCRM_POM.Pages;

import KeyWords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    private WebDriver driver;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    public By menuProject = By.xpath("//span[normalize-space()='Projects']");


    public void clickMenuCustomerpage(){
        WebUI.waitForElementVisible(menuCustomer);
        WebUI.clickElement(menuCustomer);
    }

    public void clickMenuProjectpage(){
        WebUI.waitForElementVisible(menuProject);
        WebUI.clickElement(menuProject);
    }
}

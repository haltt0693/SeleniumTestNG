package Bai18_PageFactory.Pages;

import KeyWords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li[contains(@class,'menu-item')]"))
    private List<WebElement> menuList;

    public void getMenuList(){
        System.out.println("Menu total: "+ menuList.size());
        for (int i = 0; i < menuList.size(); i++){
            System.out.println(menuList.get(i).getText());
        }
    }

//    @FindBy(how = How.XPATH,using = "//ul[@id='side-menu']/li[contains(@class,'menu-item')]")
//    private List<WebElement> menuList;

    public void verifyInvoicesAwaitingPaymentTotal(String total){
        Assert.assertTrue(driver.findElement(totalInvoicesAwaitingPayment).isDisplayed(), "The Invoices Awaiting Payment total label not display.");
        Assert.assertEquals(driver.findElement(totalInvoicesAwaitingPayment).getText(), total, "The Invoices Awaiting Payment total not match.");
    }
}

package Bai22_23_GeneralMethods.Pages;

import Bai22_23_GeneralMethods.Pages.BasePage;
import KeyWords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CustomerPage extends BasePage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);

    }

    //Customer page
    private By titleCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@type='search']"); //Search Customer

    private By itemCustomerFirst = By.xpath("//table[@id='clients']//tbody//tr[1]/td[3]/a");

    private By TotalCus = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    //Detail Customer
    private By headerProfile = By.xpath("//h4[normalize-space()='Profile']");

    //Add new Customer page
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVATNumber = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroups = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input");
    private By optionGroup_VIP = By.xpath("//span[normalize-space()='VIP']");
    private By optionGroup_GroupVIP = By.xpath("//span[normalize-space()='GroupVIP']");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By optionCurrency_EUR = By.xpath("//div[@class='dropdown-menu open']//a[@id='bs-select-2-2']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By optionLanguage_VNese = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    private By optionCountry_VN = By.xpath("//button[@data-id='country']/following-sibling::div//span[normalize-space()='Vietnam']");
    private By buttonSaveandCreate = By.xpath("//button[normalize-space()='Save and create contact']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save and create contact']/following-sibling::button");

//    private boolean checkElementExist(By by) { //Bay loi
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//            driver.findElement(by).isDisplayed();
//            return true;
//        } catch (NoSuchElementException e) {
//            return false; //Ko ban loi he thong
//        }
//    }

    public void verifyRedirectToCustomerPage() {      // Redirect/ Navigator
        System.out.println("===============================");
        Assert.assertTrue(WebUI.checkElementExist(titleCustomerPage),"The customer header page is not display");
        WebUI.assertEquals(WebUI.getText(titleCustomerPage), "Customers Summary","The customer header page is not correct");
    }

    public void clickButtonAddNewCustomer() {
        System.out.println("===============================");
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void submitDataForNewCustomer(String Customer_name){
        System.out.println("===============================");
        WebUI.setText(inputCompany, Customer_name);
        WebUI.setText(inputVATNumber, "11");
        WebUI.setText(inputPhone, "0987654321");
        WebUI.setText(inputWebsite, "https://afamily.vn/");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroups, "VIP");
        WebUI.clickElement(optionGroup_VIP);
        WebUI.clickElement(optionGroup_GroupVIP);
        WebUI.clickElement(dropdownGroups);
        WebUI.clickElement(dropdownCurrency);
        WebUI.clickElement(optionCurrency_EUR);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionLanguage_VNese);
        WebUI.setText(inputAddress, "Ha Noi");
        WebUI.setText(inputCity, "TP Ha Noi");
        WebUI.setText(inputState, "Hoan Kiem");
        WebUI.setText(inputZipCode, "670000");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Viet");
        WebUI.clickElement(optionCountry_VN);
        WebUI.clickElement(buttonSave);
    }
    public void searchCreateCustomer(String Customer_name){
        System.out.println("===============================");
        clickMenuCustomerpage();
        WebUI.setText(inputSearchCustomer, Customer_name);
        WebUI.sleep(3);
        String cusNameInTable = WebUI.getText(itemCustomerFirst);
        System.out.println("Customer is: " + cusNameInTable);
        WebUI.waitForElementVisible(itemCustomerFirst);
        WebUI.assertEquals(WebUI.getText(itemCustomerFirst),Customer_name,"Customer_name is incorrect");
    }
    public void clickOnCreatedCustomer(){
        System.out.println("===============================");
        System.out.println("Name of First Customer: " + WebUI.getText(itemCustomerFirst));
        WebUI.clickElement(itemCustomerFirst);
        WebUI.waitForElementVisible(headerProfile);
    }
    public void verifyCreatedCustomerDetail(String Customer_name){
        System.out.println("===============================");
//        System.out.println("Header of detail Customer page: " + WebUI.getText(headerProfile));
//        System.out.println("Company name: " + WebUI.getValue(inputCompany));
//        Assert.assertEquals(WebUI.getValue(inputCompany),Customer_name,"Customer_name is incorrect in detail page");
//        System.out.println("VAT Number: " + WebUI.getValue(inputVATNumber));
//        Assert.assertEquals(WebUI.getValue(inputVATNumber),"11","VATNumber is incorrect");
//        System.out.println("Phone: " + WebUI.getValue(inputPhone));
//        Assert.assertEquals(WebUI.getValue(inputPhone),"0987654321","Phone number is incorrect");
//        System.out.println("Website: " + WebUI.getValue(inputWebsite));
//        Assert.assertEquals(WebUI.getValue(inputWebsite),"https://afamily.vn/","Website is incorrect");
//        System.out.println("Groups: " + WebUI.getText(dropdownGroups));
//        Assert.assertEquals(WebUI.getText(dropdownGroups),"GroupVIP, VIP","Groups are incorrect");
//        System.out.println("Currency: " + WebUI.getTitle(dropdownCurrency));
//        System.out.println("Language: " + WebUI.getText(dropdownLanguage));
//        Assert.assertEquals(WebUI.getText(dropdownLanguage),"Vietnamese","Language is incorrect");
//        System.out.println("Address: " + WebUI.getValue(inputAddress));
//        System.out.println("City: " + WebUI.getValue(inputCity));
//        System.out.println("State: " + WebUI.getValue(inputState));
//        System.out.println("ZipCode: " + WebUI.getValue(inputZipCode));
//        System.out.println("Country: " + WebUI.getText(dropdownCountry));

        WebUI.getText(headerProfile);
        WebUI.getValue(inputCompany);
        WebUI.assertEquals(driver.findElement(inputCompany).getAttribute("value"),Customer_name,"Customer_name is incorrect in detail page");
        WebUI.getValue(inputVATNumber);
        WebUI.assertEquals(driver.findElement(inputVATNumber).getAttribute("value"),"11","VATNumber is incorrect");
        WebUI.getValue(inputPhone);
        WebUI.assertEquals(driver.findElement(inputPhone).getAttribute("value"),"0987654321","Phone number is incorrect");
        WebUI.getValue(inputWebsite);
        WebUI.assertEquals(driver.findElement(inputWebsite).getAttribute("value"),"https://afamily.vn/","Website is incorrect");
//        WebUI.getText(dropdownGroups);
        WebUI.assertEquals(WebUI.getText(dropdownGroups),"GroupVIP, VIP","Groups are incorrect");
        WebUI.assertEquals(WebUI.getTitle(dropdownCurrency),"EUR","Currency is incorrect");
        WebUI.assertEquals(WebUI.getText(dropdownLanguage),"Vietnamese","Language is incorrect");
        WebUI.assertEquals(WebUI.getValue(inputAddress),"Ha Noi","Address is incorrect");
        WebUI.assertEquals(WebUI.getValue(inputCity),"TP Ha Noi","City is incorrect");
        WebUI.assertEquals(WebUI.getValue(inputState),"Hoan Kiem","State is incorrect");
        WebUI.assertEquals(WebUI.getValue(inputZipCode),"670000","ZipCode is incorrect");
        WebUI.assertEquals(WebUI.getText(dropdownCountry),"Vietnam","Country is incorrect");
    }
    public int getTotalCus(){
        System.out.println("===============================");
        String totalCusString = WebUI.getText(TotalCus);
        System.out.println("Total of customer: " + totalCusString);
        return Integer.parseInt(totalCusString);
    }
}

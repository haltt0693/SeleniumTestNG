package ThucHanh;


import KeyWords.WebUI;
import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ThucHanhCRM_Part2 extends BaseTest {
    @Test
    public void ThucHanhCRM() throws InterruptedException {
        String Customer_name = "[Ha Le] Company ABC 013";

        new WebUI(driver); //Khoi tao class WebUI de truyen Driver vao

        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.clearText(By.xpath(LocatorsCRM.inputEmail));
        WebUI.clearText(By.xpath(LocatorsCRM.inputPassword));
        WebUI.setText(By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(By.xpath(LocatorsCRM.inputPassword), "123456");
        WebUI.clickElement(By.xpath(LocatorsCRM.buttonLogin));

        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomer));

        System.out.println("Title of Customer page: " + WebUI.getText(By.xpath(LocatorsCRM.titleCustomerPage)));

//        WebUI.clickElement(By.xpath(LocatorsCRM.buttonAddNewCustomer));
//        WebUI.setText(By.xpath(LocatorsCRM.inputCompany), Customer_name);
//        WebUI.setText(By.xpath(LocatorsCRM.inputVATNumber), "13");
//        WebUI.setText(By.xpath(LocatorsCRM.inputPhone), "0987654321");
//        WebUI.setText(By.xpath(LocatorsCRM.inputWebsite), "https://afamily.vn/");
//        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroups));
//        WebUI.setText(By.xpath(LocatorsCRM.inputSearchGroups), "VIP");
//        WebUI.clickElement(By.xpath(LocatorsCRM.optionGroup_VIP));
//        WebUI.clickElement(By.xpath(LocatorsCRM.optionGroup_GroupVIP));
//        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroups));
//        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownCurrency));
//        WebUI.clickElement(By.xpath(LocatorsCRM.optionCurrency_EUR));
//        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownLanguage));
//        WebUI.clickElement(By.xpath(LocatorsCRM.optionLanguage_VNese));
//        WebUI.setText(By.xpath(LocatorsCRM.inputAddress), "Ha Noi");
//        WebUI.setText(By.xpath(LocatorsCRM.inputCity), "TP Ha Noi");
//        WebUI.setText(By.xpath(LocatorsCRM.inputState), "Hoan Kiem");
//        WebUI.setText(By.xpath(LocatorsCRM.inputZipCode), "670000");
//        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownCountry));
//        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCountry), "Viet");
//        WebUI.clickElement(By.xpath(LocatorsCRM.optionCountry_VN));
//        WebUI.clickElement(By.xpath(LocatorsCRM.buttonSave));


        //Search and view detail created Customer
        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomer));
        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCustomer), Customer_name);
        Thread.sleep(2000);
        WebUI.waitForElementVisible(By.xpath(LocatorsCRM.itemCustomerFirst));
        Assert.assertEquals(WebUI.getText(By.xpath(LocatorsCRM.itemCustomerFirst)),Customer_name,"Chua hien ra ten dung");

        System.out.println("Name of First Customer: " + WebUI.getText(By.xpath(LocatorsCRM.itemCustomerFirst)));
        WebUI.clickElement(By.xpath(LocatorsCRM.itemCustomerFirst));
        WebUI.waitForElementVisible(By.xpath(LocatorsCRM.headerProfile));

        System.out.println("Header of detail Customer page: " + WebUI.getText(By.xpath(LocatorsCRM.headerProfile)));
        System.out.println("Company name: " + WebUI.getValue(By.xpath(LocatorsCRM.inputCompany)));
        Assert.assertEquals(WebUI.getValue(By.xpath(LocatorsCRM.inputCompany)),Customer_name,"Chua hien ra ten dung 002");
        System.out.println("VAT Number: " + WebUI.getValue(By.xpath(LocatorsCRM.inputVATNumber)));
        Assert.assertEquals(WebUI.getValue(By.xpath(LocatorsCRM.inputVATNumber)),"13","Chua hien ra ten dung 003");
        System.out.println("Phone: " + WebUI.getValue(By.xpath(LocatorsCRM.inputPhone)));
        System.out.println("Website: " + WebUI.getValue(By.xpath(LocatorsCRM.inputWebsite)));
        System.out.println("Groups: " + WebUI.getText(By.xpath(LocatorsCRM.dropdownGroups)));
        System.out.println("Currency: " + WebUI.getTitle(By.xpath(LocatorsCRM.dropdownCurrency)));
        System.out.println("Language: " + WebUI.getText(By.xpath(LocatorsCRM.dropdownLanguage)));
        System.out.println("Address: " + WebUI.getValue(By.xpath(LocatorsCRM.inputAddress)));
        System.out.println("City: " + WebUI.getValue(By.xpath(LocatorsCRM.inputCity)));
        System.out.println("State: " + WebUI.getValue(By.xpath(LocatorsCRM.inputState)));
        System.out.println("ZipCode: " + WebUI.getValue(By.xpath(LocatorsCRM.inputZipCode)));
        System.out.println("Country: " + WebUI.getText(By.xpath(LocatorsCRM.dropdownCountry)));


        closeDriver();
    }
}

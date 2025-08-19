package ThucHanh;


import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ThucHanhCRM_Part1 extends BaseTest {
    @Test
    public void ThucHanhCRM() throws InterruptedException {

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorsCRM.menuCustomer)).click();
        System.out.println("Title of Customer page: " + driver.findElement(By.xpath(LocatorsCRM.titleCustomerPage)).getText());
        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewCustomer)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("[Ha Le] Company ABC 006");
        driver.findElement(By.xpath(LocatorsCRM.inputVATNumber)).sendKeys("11");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0987654321");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://afamily.vn/");
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("VIP");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.optionGroup_VIP)).click();
        driver.findElement(By.xpath(LocatorsCRM.optionGroup_GroupVIP)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();

        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.optionCurrency_EUR)).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.optionLanguage_VNese)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("TP Ha Noi");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Hoan Kiem");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("670000");

        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Viet");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.optionCountry_VN)).click();

        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();
        Thread.sleep(1000);

        //Search and view detail created Customer
        driver.findElement(By.xpath(LocatorsCRM.menuCustomer)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).sendKeys("[Ha Le] Company ABC 006");
        System.out.println("Created Customer is displayed: " + driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).isDisplayed());
        System.out.println("Name of First Customer: " + driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).getText());
        driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).click();

        System.out.println("Header detail Customer page isDisplayed: " + driver.findElement(By.xpath(LocatorsCRM.headerProfile)).isDisplayed());
        System.out.println("Header of detail Customer page: " + driver.findElement(By.xpath(LocatorsCRM.headerProfile)).getText());

        System.out.println("Company name: " + driver.findElement(By.xpath(LocatorsCRM.inputCompany)).getAttribute("value"));
        System.out.println("VAT Number: " + driver.findElement(By.xpath(LocatorsCRM.inputVATNumber)).getAttribute("value"));
        System.out.println("Phone: " + driver.findElement(By.xpath(LocatorsCRM.inputPhone)).getAttribute("value"));
        System.out.println("Website: " + driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).getAttribute("value"));
        System.out.println("Groups: " + driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).getText());
        System.out.println("Currency: " + driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).getAttribute("title"));
        System.out.println("Language: " + driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).getText());
        System.out.println("Address: " + driver.findElement(By.xpath(LocatorsCRM.inputAddress)).getAttribute("value"));
        System.out.println("City: " + driver.findElement(By.xpath(LocatorsCRM.inputCity)).getAttribute("value"));
        System.out.println("State: " + driver.findElement(By.xpath(LocatorsCRM.inputState)).getAttribute("value"));
        System.out.println("ZipCode: " + driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).getAttribute("value"));
        System.out.println("Country: " + driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).getText());

        Thread.sleep(1000);

        closeDriver();
    }
}

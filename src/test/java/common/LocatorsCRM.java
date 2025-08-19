package common;

public class LocatorsCRM {
    //Login page
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String checkboxRememberme = "//input[@id='remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String alertLoginFailed = "//div[@id='alerts']/div";

    //Menu bar
    public static String menuDashboard = "//span[normalize-space()='Dashboard']";
    public static String menuCustomer = "//span[normalize-space()='Customers']";

    //Dashboard page
    public static String iconProfile = "//li[contains(@class,'header-user-profile')]";//khó lấy, chỉ là hình ảnh
    public static String labelInvoincesAwaitingPayment = "//span[normalize-space()='Invoices Awaiting Payment']";
    public static String totalInvoincesAwaitingPayment = "(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span";
    public static String totalConvertedLeads = "(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span";
    public static String totalProjectsInProgress = "(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span";
    public static String totalTasksNotFinished = "(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span";


    //Customer page
    public static String titleCustomerPage = "//span[normalize-space()='Customers Summary']";
    public static String buttonAddNewCustomer = "//a[normalize-space()='New Customer']";
    public static String buttonImportCustomers = "//a[normalize-space()='Import Customers']";
    public static String inputSearchCustomer = "//div[@id='clients_filter']//input[@type='search']"; //Search Customer

    //Add new Customer page
    public static String inputCompany = "//input[@id='company']";
    public static String inputVATNumber = "//input[@id='vat']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputWebsite = "//input[@id='website']";
    public static String dropdownGroups = "//button[@data-id='groups_in[]']";
    public static String inputSearchGroups = "//button[@data-id='groups_in[]']/following-sibling::div//input";
    public static String optionGroup_VIP = "//span[normalize-space()='VIP']";
    public static String optionGroup_GroupVIP = "//span[normalize-space()='GroupVIP']";
    public static String dropdownCurrency = "//button[@data-id='default_currency']";
    public static String optionCurrency_EUR= "//div[@class='dropdown-menu open']//a[@id='bs-select-2-2']";
    public static String dropdownLanguage = "//button[@data-id='default_language']";
    public static String optionLanguage_VNese = "//span[normalize-space()='Vietnamese']";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputCity = "//input[@id='city']";
    public static String inputState = "//input[@id='state']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry = "//button[@data-id='country']/following-sibling::div//input";
    public static String optionCountry_VN = "//button[@data-id='country']/following-sibling::div//span[normalize-space()='Vietnam']";
    public static String buttonSaveandCreate = "//button[normalize-space()='Save and create contact']";
    public static String buttonSave = "//button[normalize-space()='Save and create contact']/following-sibling::button";


    //Search Customer
    public static String createdCustomer = "//a[normalize-space()='[Ha Le] Company ABC']";
    public static String itemCustomerFirst = "//table[@id='clients']//tbody//tr[1]/td[3]/a";
    public static String itemCustomerSecond = "//table[@id='clients']//tbody//tr[2]/td[3]/a";
    public static String selectAnyCustomer = "//table[@id='clients']//tbody//tr[3]/td[3]/a";



    //Detail Customer
    public static String headerProfile = "//h4[normalize-space()='Profile']";



    //Sales page
    public static String menuSales = "//span[@class='menu-text'][normalize-space()='Sales']";
    public static String menuProposals = "//span[normalize-space()='Proposals']";
    public static String buttonNewProposal = "//a[normalize-space()='New Proposal']";

    //Tasks page
    public static String menuTasks = "//span[normalize-space()='Tasks']";
    public static String buttonNewTask = "//a[normalize-space()='New Task']";
}

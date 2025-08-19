package Bai10_Annotations;

import org.testng.annotations.*;

public class ParentClass {
    @BeforeSuite
    public void beforeSuite_PARENT() {
        System.out.println("Before Suite PARENT");
    }

    @AfterSuite
    public void afterSuite_PARENT() {
        System.out.println("After Suite PARENT");
    }

    @BeforeTest
    public void beforeTest_PARENT() {
        System.out.println("Before Test PARENT");
    }

    @AfterTest
    public void afterTest_PARENT() {
        System.out.println("After Test PARENT");
    }

    @BeforeClass
    public void beforeClass_PARENT() {
        System.out.println("Before Class PARENT");
    }

    @AfterClass
    public void afterClass_PARENT() {
        System.out.println("After Class PARENT");
    }
    @BeforeMethod
    public void beforeMethod_PARENT() {
        System.out.println("Before Method PARENT");
    }

    @AfterMethod
    public void afterMethod_PARENT() {
        System.out.println("After Method PARENT");
    }

}




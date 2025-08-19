package Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo_Parameters {
    @Test(priority = 1)
    @Parameters({"val1", "val2"})
    public void Sum1(int v1, int v2) {
        int finalSum = v1 + v2;
        System.out.println("Kết quả là: " + finalSum);
    }

    @Test(priority = 2)
    @Parameters({"val1", "val2", "val3"})
    public void Sum2(int v1, int v2, int v3) {
        int finalSum = v1 + v2 +v3;
        System.out.println("Kết quả là: " + finalSum);
    }

    @Test(priority = 3)
    @Parameters({"val1"})
    public void Minus(int v1) {
        int finalMinus = v1 - 9;
        System.out.println("Kết quả là: " + finalMinus);
    }
}

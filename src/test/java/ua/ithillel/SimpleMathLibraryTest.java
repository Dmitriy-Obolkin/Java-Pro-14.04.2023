package test.java.ua.ithillel;

import main.java.ua.ithillel.SimpleMathLibrary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMathLibraryTest {

    @Test
    public void addTest_success() {
        double a = 10;
        double b = 5;

        double expectedValue = 15;

        double actualValue = SimpleMathLibrary.add(a, b);

        if(actualValue == expectedValue){
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void subtractTest_success() {
        double a = 10;
        double b = 5;

        double expectedValue = 15;

        double actualValue = SimpleMathLibrary.minus(a, b);

        if(actualValue == expectedValue){
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
        assertEquals(expectedValue, actualValue);
    }
}

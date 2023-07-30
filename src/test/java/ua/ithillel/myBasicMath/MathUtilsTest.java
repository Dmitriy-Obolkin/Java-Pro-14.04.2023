package ua.ithillel.myBasicMath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {
    private static final double DELTA = 1e-15;

    @Test
    public void addTest_success() {
        assertEquals(5.0, MathUtils.add(2.0, 3.0), DELTA);
    }

    @Test
    public void subtractTest_success() {
        assertEquals(-1.0, MathUtils.subtract(2.0, 3.0), DELTA);
    }

    @Test
    public void multiplyTest_success() {
        assertEquals(6.0, MathUtils.multiply(2.0, 3.0), DELTA);
    }

    @Test
    public void divideTest_success() {
        assertEquals(2.0, MathUtils.divide(4.0, 2.0), DELTA);
    }

    @Test
    public void divideTest_throwsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(2.0, 0.0));
    }

    @Test
    public void sinTest_success() {
        assertEquals(1.0, MathUtils.sin(Math.PI / 2.0), DELTA);
    }

    @Test
    public void cosTest_success() {
        assertEquals(1.0, MathUtils.cos(0.0), DELTA);
    }

    @Test
    public void tanTest_success() {
        assertEquals(1.0, MathUtils.tan(Math.PI / 4.0), DELTA);
    }

    @Test
    public void cotTest_success() {
        assertEquals(1.0, MathUtils.cot(Math.PI / 4.0), DELTA);
    }

    @Test
    public void cotTest_throwsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.cot(0));
    }

    @Test
    public void sqrtTest_success() {
        assertEquals(2.0, MathUtils.sqrt(4.0), DELTA);
    }

    @Test
    public void absTest_success() {
        assertEquals(5.0, MathUtils.abs(-5.0), DELTA);
    }
}

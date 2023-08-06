package test.java.ua.ithillel;

import main.java.ua.ithillel.ArrayUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ArrayUtilsTest {
    @Test
    public void getElementsAfterLastFourTest_WithFourAtTheEnd() {
        assertArrayEquals(new int[]{}, ArrayUtils.getElementsAfterLastFour(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void getElementsAfterLastFourTest_WithElementsAfterLastFour() {
        assertArrayEquals(new int[]{5, 6}, ArrayUtils.getElementsAfterLastFour(new int[]{4, 4, 4, 5, 6}));
    }

    @Test
    public void getElementsAfterLastFourTest_WithOnlyOneFour() {
        assertArrayEquals(new int[]{5, 6, 7}, ArrayUtils.getElementsAfterLastFour(new int[]{4, 5, 6, 7}));
    }

    @Test
    public void getElementsAfterLastFourTest_WithoutFour() {
        assertThrows(RuntimeException.class, () -> ArrayUtils.getElementsAfterLastFour(new int[]{1, 2, 3}));
    }



    @Test
    public void containsOneAndFourTest_WithBothOneAndFour() {
        assertTrue(ArrayUtils.containsOneAndFour(new int[]{1, 4, 4, 1, 4}));
    }

    @Test
    public void containsOneAndFourTest_WithoutOne() {
        assertFalse(ArrayUtils.containsOneAndFour(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void containsOneAndFourTest_WithoutFour() {
        assertFalse(ArrayUtils.containsOneAndFour(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void containsOneAndFourTest_WithNeitherOneNorFour() {
        assertFalse(ArrayUtils.containsOneAndFour(new int[]{2, 3, 5, 6, 7}));
    }
}

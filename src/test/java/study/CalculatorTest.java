package study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testCalculate() {
        calculator ca = new calculator();

        assertEquals(10, ca.calculate("2 + 3 * 4 / 2"));
        assertEquals(5, ca.calculate("2 * 3 + 4 / 2"));
        assertEquals(3, ca.calculate("10 / 3"));
        assertEquals(15, ca.calculate("10 + 5"));
        assertEquals(-5, ca.calculate("10 - 15"));
    }
}

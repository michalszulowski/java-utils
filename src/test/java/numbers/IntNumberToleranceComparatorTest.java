package numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntNumberToleranceComparatorTest {
    private final static int VAL1_BIGGER = 1;
    private final static int VAL2_BIGGER = -1;
    private final static int VALS_EQUAL = 0;
    private static NumberToleranceComparator<Integer> comparator;
    private int result;

    @Test
    public void testEqualNumbersWithNoTolerance() {
        givenTolerance(1);
        whenComparing(10, 10);
        thenResultShouldBe(VALS_EQUAL);
    }

    @Test
    public void testDifferentNumbersWithinTolerance() {
        givenTolerance(1.11);
        whenComparing(10, 11);
        thenResultShouldBe(VALS_EQUAL);
    }

    @Test
    public void testDifferentNumbersOutOfToleranceSecondBigger() {
        givenTolerance(1.09);
        whenComparing(10, 11);
        thenResultShouldBe(VAL2_BIGGER);
    }

    @Test
    public void testDifferentNumbersOutOfToleranceFirstBigger() {
        givenTolerance(1.09);
        whenComparing(11, 10);
        thenResultShouldBe(VAL1_BIGGER);
    }

    @Test
    public void testHugeInts() {
        givenTolerance(1);
        whenComparing(Integer.MAX_VALUE, Integer.MAX_VALUE - 1);
        thenResultShouldBe(VAL1_BIGGER);
    }

    private void givenTolerance(double tolerance) {
        comparator = new NumberToleranceComparator<>(tolerance);
    }

    private void whenComparing(int val1, int val2) {
        result = comparator.compare(val1, val2);
    }

    private void thenResultShouldBe(int expectedResult) {
        assertEquals(expectedResult, result);
    }

}
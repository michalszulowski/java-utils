package numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongNumberToleranceComparatorTest {

    @Test
    public void testHugeLongComparison() {
        // given
        NumberToleranceComparator<Long> comparator = new NumberToleranceComparator<>(1);
        long l1 = Long.MAX_VALUE - 1;
        long l2 = Long.MAX_VALUE;

        // when then
        assertThrows(IllegalStateException.class, () ->
                comparator.compare(l1, l2)
        );
    }
}

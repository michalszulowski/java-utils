package numbers;

import java.util.Comparator;

public class NumberToleranceComparator<N extends Number> implements Comparator<N> {
    private final double relativeTolerance;
    private double val1ToVal2;
    private double val2ToVal1;

    public NumberToleranceComparator(double relativeTolerance) {
        this.relativeTolerance = relativeTolerance;
    }

    @Override
    public int compare(N val1, N val2) {
        val1ToVal2 = val1.doubleValue() /val2.doubleValue();
        val2ToVal1 = val2.doubleValue() /val1.doubleValue();
        if (isVal1TooBig()) {
            return 1;
        }
        if (isVal2TooBig()) {
            return -1;
        }
        return 0;
    }

    private boolean isVal1TooBig() {
        return val1ToVal2 > relativeTolerance;
    }

    private boolean isVal2TooBig() {
        return val2ToVal1 > relativeTolerance;
    }
}

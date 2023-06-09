package numbers;

public class FloatComparator extends NumberToleranceComparator<Float> {
    public FloatComparator(double relativeTolerance) {
        super(relativeTolerance);
    }

    public static FloatComparator ofTolerance(double tolerance) {
        return new FloatComparator(tolerance);
    }
}

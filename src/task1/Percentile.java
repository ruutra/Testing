package task1;

import java.util.Collections;
import java.util.List;

public class Percentile {
    public static double getPercentile(List<Double> latencies, double percentile) {
        Collections.sort(latencies);
        int index = (int) Math.ceil(percentile / 100.0 * latencies.size());
        return latencies.get(index - 1);
    }
}

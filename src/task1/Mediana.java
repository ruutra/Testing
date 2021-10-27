package task1;

import java.util.Collections;
import java.util.List;

public class Mediana {
    public static double getMediana(List<Double> latencies) {
        Collections.sort(latencies);
        int index = (int) Math.ceil(50 / 100.0 * latencies.size());
        Double mediana =  latencies.get(index - 1);
        return mediana;
    }
}

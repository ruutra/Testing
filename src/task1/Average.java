package task1;

import java.util.List;

public class Average {
    public static Double getAverage(List<Double> list) {
        double sum = 0;
        for (double i : list) {
            sum += i;
        }
        double average = sum / list.size();
        return average;
    }
}

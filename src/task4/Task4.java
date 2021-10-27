package task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<List<Double>> time = new ArrayList<>();
        List<Double> interval = new ArrayList<>();
        List<Integer> customers = new ArrayList<>();
        File file = new File("time");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                interval.add(Double.valueOf(line.split("-")[0].replace(":",".")));
                interval.add(Double.valueOf(line.split("-")[1].replace(":",".")));
                time.add(Arrays.asList(Double.valueOf(line.split("-")[0].replace(":",".")),Double.valueOf(line.split("-")[1].replace(":","."))));
            }
            Collections.sort(interval);
            for(int i = 0; i < interval.size()-1; i++) {
                customers.add(0);
                for (List<Double> t : time)
                    if (t.get(0) <= interval.get(i) && interval.get(i) < interval.get(i+1) && interval.get(i + 1) <= t.get(1))
                        customers.set(i, customers.get(i) + 1);
            }
            int max = Collections.max(customers);
            Double toWrite;
            for (int i = 1; i < interval.size()-1; i++){
                if ((max == customers.get(i)) && (i == 1 || max != customers.get(i-1)))
                {
                    toWrite = interval.get(i);
                    String.format("%.2f", toWrite).replace(".",":");
                    System.out.print(toWrite+"-");
                }
                if ((max != customers.get(i)) && (max == customers.get(i-1)))
                {
                     toWrite = interval.get(i);
                    String.format("%.2f", toWrite).replace(".",":");
                    System.out.println(toWrite);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

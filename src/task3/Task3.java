package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        double[] doubleArrayList = new double[16];
        for (int i = 0; i < 5; i++) {
            File file = new File("Cash" + (i + 1));
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int j = 0;
                while ((line = reader.readLine()) != null) {
                    doubleArrayList[j] += Double.valueOf(line);
                    j++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        double max = doubleArrayList[0];
        int res = 0;
        for (int i = 0; i < doubleArrayList.length; i++) {
            if (doubleArrayList[i] > max) {
                max = doubleArrayList[i];
                res = i;
            }
        }
        System.out.println(res+1);
    }
}

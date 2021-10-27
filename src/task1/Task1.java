package task1;

import task1.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        File file = new File("test1");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                doubleArrayList.add(Double.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%.2f%n", Percentile.getPercentile(doubleArrayList, 90));
        System.out.printf( "%.2f%n",Mediana.getMediana(doubleArrayList));
        System.out.printf( "%.2f%n", Max.getMax(doubleArrayList));
        System.out.printf( "%.2f%n", Min.getMin(doubleArrayList));
        System.out.printf( "%.2f%n", Average.getAverage(doubleArrayList));


    }
}

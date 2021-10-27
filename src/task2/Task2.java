package task2;

import task2.Point;
import task2.Tetragon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2<doubleArrayList> {
    public static void main(String[] args) {
        File file = new File("coor");
        List<Point> coors= new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

               List<String> s = Arrays.stream(line.split(" ")).collect(Collectors.toList());
                Point point = new Point(Double.valueOf(s.get(0)),Double.valueOf(s.get(1)));
                coors.add(point);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file2 = new File("form");
        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            String line2;
            List<Point> pointTetragon = new ArrayList<>();
            while ((line2 = reader2.readLine()) != null) {

                List<String> s2 = Arrays.stream(line2.split(" ")).collect(Collectors.toList());
                Point point = new Point(Double.valueOf(s2.get(0)),Double.valueOf(s2.get(1)));
                pointTetragon.add(point);

            }
            Tetragon tetragon = new Tetragon(pointTetragon);
            for (Point point:coors){
               if (tetragon.IsAtTop(point))
                   System.out.println("0");
               else if (tetragon.IsInside(point))
                   System.out.println("1");
               else if (tetragon.IsOnSide(point))
                   System.out.println("2");
               else
                   System.out.println("3");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

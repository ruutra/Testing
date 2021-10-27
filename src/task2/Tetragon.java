package task2;

import java.util.List;

public class Tetragon {
    private List<Point> points;

    public Tetragon(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Tetragon{" +
                "points=" + points +
                '}';
    }
    public boolean IsAtTop(Point point) {
        for (Point p: points) {
          if (p.equals(point)) {
              return true;
          }
        }
        return false;
    }
    public boolean IsOnSide(Point point) {
        double a = 0;
        double b = 0;
        for (int i = 0; i < points.size()-1; i++) {
            Point line1 = points.get(i);
            Point line2 = points.get(i+1);
            a = line2.getY() - line1.getY()/ line2.getX()- line1.getX();
            b = line2.getY() * line1.getX() - line1.getY() * line2.getX()/ line1.getX() - line2.getX();
            if (point.getY()==a * point.getX() + b){
                return true;
            }
        }
        return false;
    }
    public boolean IsInside(Point point) {
        int i = 0;
        int j = 0;
        boolean res = false;
        for ( i = 0, j = points.size()-1; i < points.size(); j = i++) {
            Double xi = points.get(i).getX();
            Double yi = points.get(i).getY();
            Double xj = points.get(j).getX();
            Double yj = points.get(j).getY();
            if ((yi > point.getY()) != (yj > point.getY()) && (point.getX() < (xj - xi) * (point.getY() - yi)/(yj - yi) + xi)){
               res = !res;
            }
        }
        return res;
    }
}

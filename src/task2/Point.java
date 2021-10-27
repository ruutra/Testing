package task2;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return ("x = "+x+" y ="+y);
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object other) {
        Point otherPoint = (Point) other;
        if (this.x == otherPoint.getX() && this.y == otherPoint.getY())
            return true;
        return false;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point other) {
        return new Point(this.x + other.x,this.y + other.y);
    }
    public Point sub (Point other) {
        return new Point(this.x - other.x,this.y - other.y);
    }
    public double mul (Point other) {
        return this.x * other.y - this.y * other.x;
    }
}


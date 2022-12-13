package de.stefan.progra.projects.homework8;
import java.math.*;

public class Point {
    private final BigDecimal x, y;

    public Point(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y) {
        this(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
    }

    public BigDecimal distance(Point other) {
        BigDecimal diffX = x.subtract(other.x);
        BigDecimal diffY = y.subtract(other.y);
        return BigDecimalUtility.sqrt(diffX.pow(2).add(diffY.pow(2)));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())) {
            Point target = (Point) obj;
            if(BigDecimalUtility.equalValues(x, target.x) &&
                BigDecimalUtility.equalValues(y, target.y)) {
                return true;
            }
        }
        return false;
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

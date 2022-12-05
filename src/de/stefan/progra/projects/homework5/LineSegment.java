package de.stefan.progra.projects.homework5;

import java.util.Random;

public class LineSegment {
    private Point start;
    private Point end;

    private static final Random rn = new Random();

    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public LineSegment(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public LineSegment(int max) {
        this(max, -1);
    }

    public LineSegment(int max, int length) {
        int x1 = rn.nextInt(max);
        int x2 = rn.nextInt(max);
        int y1 = rn.nextInt(max);
        int y2 = rn.nextInt(max);

        if (length > -1) {
            do {
                double angle = rn.nextInt(360) * Math.PI / 180;
                x2 = (int) (x1 + length * Math.cos(angle));
                y2 = (int) (y1 + length * Math.sin(angle));
            } while (x2 >= max || y2 >= max || x2 < 0 || y2 < 0);
        }
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    public static LineSegment[] spawnParallel(int distance, int n) {
        if (n < 2) return null;
        LineSegment[] lineArray = new LineSegment[n];
        for (int i = 0; i < n; i++) {
            lineArray[i] = new LineSegment(
                    new Point(0, (distance / (n - 1)) * i),
                    new Point(distance, (distance / (n - 1) * i))
            );
        }
        return lineArray;
    }

    private boolean intersectHorizontal(LineSegment l) {
        if (l.getA().y() != l.getB().y()) return false;
        return this.start.y() <= l.start.y() && this.end.y() >= l.start.y() ||
                this.start.y() >= l.start.y() && this.end.y() <= l.start.y();
    }

    private boolean intersectHorizontal(LineSegment[] parallel) {
        for (LineSegment l : parallel) {
            if (intersectHorizontal(l)) return true;
        }
        return false;
    }

    public static double computeValue(LineSegment[] parallel, LineSegment[] random) {
        int m = 0;
        for (LineSegment segment : random) {
            if (segment.intersectHorizontal(parallel)) {
                m++;
            }
        }
        if (m == 0) return 0d;
        return 2 * ((double) random.length / m);

    }


    public Point getA() {
        return start;
    }

    public Point getB() {
        return end;
    }

    public void setA(Point start) {
        this.start = start;
    }

    public void setB(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return start.toString() + " -- " + end.toString();
    }
}

package de.stefan.progra.projects.homework5;

import java.util.Random;

public class LineSegment {
    private Point start;
    private Point end;

    private static Random rn = new Random();

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

        if(length > -1) {
            do {
                double angle = rn.nextInt(360) * Math.PI / 180;
                x2 = (int) (x1 + length * Math.cos(angle));
                y2 = (int) (y1 + length + Math.sin(angle));
            } while(x2 >= max || y2 >= max);
        }
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    private LineSegment[] spawnParallel(int distance, int n) {
        LineSegment[] lineArray = new LineSegment[n];
        for(int i = 0; i < n; i++) {
            lineArray[i] = new LineSegment(
                    new Point(0, distance * i),
                    new Point(distance, distance * i)
            );
        }
        return lineArray;
    }


    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "(" + start.x() + "," + start.y() + ") -- " + "(" + start.x() + "," + start.y() + ")";
    }
}

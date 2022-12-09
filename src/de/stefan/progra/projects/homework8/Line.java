package de.stefan.progra.projects.homework8;

public sealed class Line
permits Ray {
    private final Point p1, p2;

    public Line(Point p1, Point p2) throws SinglePointException {
        if(p1.equals(p2)) throw new SinglePointException(p1);

        boolean switchPoints = false;
        switch (p1.getX().compareTo(p2.getX())) {
            case 1:
                switchPoints = true;
                break;
            case 0:
                if(p1.getY().compareTo(p2.getY()) < 0) {
                    switchPoints = true;
                }
        }
        this.p1 = switchPoints ? p2 : p1;
        this.p2 = switchPoints ? p1 : p2;
    }
}

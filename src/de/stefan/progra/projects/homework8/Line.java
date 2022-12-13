package de.stefan.progra.projects.homework8;

public sealed class Line implements ToInfinity
permits Ray {

    public static void main(String[] args) throws SinglePointException {
        Point p1 = new Point(5, 4);
        Point p2 = new Point(2, 4);
        Ray line = new Ray(p1, p2);

        Point p3 = new Point(5, 5);
        Point p4 = new Point(7, 6);

        Ray line2 = new Ray(p2, p1);

        System.out.println(line);
        System.out.println(line2);
        System.out.println(line.getStartingPoint());
        System.out.println(line2.getStartingPoint());

        System.out.println(line.equals(line2));
    }
    protected final Point p1, p2;

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

    protected boolean betweenP1P2(Point p0) {
        return p1.distance(p2).equals(p1.distance(p0).add(p0.distance(p2)));
    }

    protected boolean aheadOfP1(Point p0) {
        return p0.distance(p2).equals(p0.distance(p1).add(p1.distance(p2)));
    }

    protected boolean pastP2(Point p0) {
        return p1.distance(p0).equals(p1.distance(p2).add(p2.distance(p0)));
    }

    public boolean contains(Point p0) {
        return betweenP1P2(p0) || aheadOfP1(p0) || pastP2(p0);
    }

    @Override
    public boolean equals(Object obj) {
        if(!obj.getClass().equals(this.getClass())) return false;
        Line target = (Line) obj;
        if(!contains(target.p1) || !contains(target.p2)) return false;
        return true;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    @Override
    public String toString() {
        return "Gerade durch " + p1 + " und " + p2;
    }
}

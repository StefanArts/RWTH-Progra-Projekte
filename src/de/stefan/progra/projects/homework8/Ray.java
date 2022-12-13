package de.stefan.progra.projects.homework8;

public sealed class Ray extends Line implements ToInfinity
permits LineSegment {

    private final Point startingPoint;
    public Ray(Point a, Point b) throws SinglePointException {
        super(a, b);
        startingPoint = a;
    }

    public boolean startsFromP1() {
        return startingPoint.equals(p1);
    }
    public boolean startsFromP2() {
        return startingPoint.equals(p2);
    }

    public Line extend() {
        try {
            return new Line(p1, p2);
        } catch (SinglePointException e) {
            /*
             *  Dieser Fall darf nicht auftreten, da der Fehler bereits bei Erstellung der ersten Gerade
             *  geworfen worden waere.
             */
            throw new RuntimeException(e);
        }
    }

    public boolean contains(Point p0) {
        return betweenP1P2(p0) || pastP2(p0);
    }

    @Override
    public boolean equals(Object obj) {
        if(!obj.getClass().equals(this.getClass())) return false;
        Ray target = (Ray) obj;
        return target.startingPoint.equals(startingPoint) &&
                contains(target.p1.equals(target.startingPoint) ? p1 : p2);
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    @Override
    public String toString() {
        return p1 + " --> " + p2 + " -->";
    }
}

package de.stefan.progra.projects.homework8;

public sealed class Ray extends Line implements ToInfinity
permits LineSegment {

    private final Point startingPoint;
    public Ray(Point p1, Point p2) throws SinglePointException {
        super(p1, p2);
        //if(this.p1.equals(p1)) startingPoint = p1;
        //else startingPoint = p2;
        startingPoint = p1;
    }

    public boolean startsFromP1() {
        return startingPoint.equals(p1);
    }
    public boolean startsFromP2() {
        return startingPoint.equals(p2);
    }

    public Line extend() {
        return this;
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

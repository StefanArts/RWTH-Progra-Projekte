package de.stefan.progra.projects.homework8;

public final class LineSegment extends Ray {
    public LineSegment(Point p1, Point p2) throws SinglePointException {
        super(p1, p2);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Line) this).equals(obj);
    }

    public boolean contains(Point p0) {
        return betweenP1P2(p0);
    }

    public Ray extend(boolean swap) {
        try {
            if(swap) {
                return new Ray(p2, p1);
            } else {
                return this;
            }
        } catch (SinglePointException e) {
            /*
             *  Dieser Fall darf nicht auftreten, da der Fehler bereits bei Erstellung der ersten Gerade
             *  geworfen worden waere.
             */
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return p1 + " <--> " + p2;
    }
}

package de.stefan.progra.projects.homework8;

public class SinglePointException extends Exception {
    private final Point point;

    public SinglePointException(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Doppelte Benutzung des Punktes " + point;
    }
}

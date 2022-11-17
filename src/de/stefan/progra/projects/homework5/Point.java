package de.stefan.progra.projects.homework5;

public record Point(int x, int y) {

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ")";
    }

    private double norm2() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}

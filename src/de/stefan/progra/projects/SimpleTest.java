package de.stefan.progra.projects;

public class SimpleTest {

    private int a;
    private String b;
    private boolean z;

    public SimpleTest(int a, String b, boolean z) {
        this.a = a;
        this.b = b;
        this.z = z;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public boolean isZ() {
        return z;
    }

    public void setZ(boolean z) {
        this.z = z;
    }
}

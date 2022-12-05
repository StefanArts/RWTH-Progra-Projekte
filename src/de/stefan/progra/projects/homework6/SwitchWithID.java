package de.stefan.progra.projects.homework6;

import java.util.Random;

public class SwitchWithID extends Switch{

    public static int idGlobal = 0;
    private final int id = nextId();

    public static int nextId() {
        return idGlobal++;
    }

    public SwitchWithID(SwitchWithID... succs) {
        super(0, false, succs);
    }

    @Override
    public String toString() {
        return "SWITCH" + id;
    }
}

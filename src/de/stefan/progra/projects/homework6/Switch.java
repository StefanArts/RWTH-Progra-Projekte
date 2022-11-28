package de.stefan.progra.projects.homework6;

public class Switch {

    private Switch succ0;
    private Switch succ1;
    private Switch parent;

    private boolean activeSucc;

    public Switch(Switch succ0, Switch succ1) {
        this.succ0 = succ0;
        this.succ1 = succ1;
    }

    public Switch(Switch succ) {
        this.succ0 = this.succ1 = succ;
    }

    public Switch getSucc0() {
        return succ0;
    }

    public Switch getSucc1() {
        return succ1;
    }

}

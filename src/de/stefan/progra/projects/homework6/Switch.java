package de.stefan.progra.projects.homework6;

/**
 * Klasse Switch zur Modellierung eines Murmelbahnbausteins
 * @author Stefan H.
 * @version 1
 */
public class Switch {

    /**
     * Hilfsklassee SwitchContainer, um ein Array von Switches direkt bearbeiten zu koennen
     */
    static class SwitchContainer {
        Switch[] switches;

        /**
         * Standard-Konstruktor
         * @param switches Initialisierungswert des Switch-Arrays
         */
        SwitchContainer(Switch[] switches) {
            this.switches = switches;
        }
    }

    private Switch succ0, succ1, childSucc;

    private int succCount, succMax;

    /**
     * Konstruktor zur Erstellung eines Standard-Switches mit zwei Nachfolgern
     * @param succ0 Erster Nachfolger
     * @param succ1 Zweiter Nachfolger
     */
    public Switch(Switch succ0, Switch succ1) {
        this(0, false, succ0, succ1);
    }

    /**
     * Konstruktor zur Erstellung eines Straight-Switches mit einem Nachfolger
     * @param succ Nachfolger
     */
    public Switch(Switch succ) {
        this(0, false, succ, succ);
    }

    /**
     * Konstruktor zur Erstellung eines Multi-Switches mit drei Nachfolgern
     * @param succ0 Erster Nachfolger
     * @param succ1 Zweiter Nachfolger
     * @param succ2 Dritter Nachfolger
     */
    public Switch(Switch succ0, Switch succ1, Switch succ2) {
        this(0, false, succ0, succ1, succ2);
    }

    /**
     * Hilfskonstruktor, um Rekursion moeglich zu machen.
     * Mit diesem Konstruktor ist es moeglich, Multi-Switches mit n Nachfolgern zu erstellen.
     * succ0 und succ1 werden gesetzt, wenn sie existieren. Falls mehr als 2 Nachfolger existieren,
     * wird ein Child-Switch erstellt, um die naechsten zwei Nachfolger unterzubringen. Dies wird
     * so lange wiederholt, bis alle Nachfolger erstellt wurden.
     * @param index Rekursionsindex, Standard: 0
     * @param isChild wird true, wenn der aktuelle Switch nicht der erste Switch ist.
     * @param succs Alle Nachfolger als Varargs
     */
    public Switch(int index, boolean isChild, Switch... succs) {
        if(succs.length == 0)
            return;
        succCount = 0;
        succMax = succs.length;
        succ0 = succs[index];
        if(isChild) succ1 = succ0;
        if(succs.length - index > 1) succ1 = succs[index + 1];
        if(succs.length - index > 2) {
            childSucc = new Switch(index + 2, true, succs);
        }
    }

    /**
     * Funktion, um den naechsten Nachfolger zu bestimmen.
     * Dazu werden die Variablen des maximal moeglichen Nachfolgerindexes und des Nachfolgerzaehlers genutzt.
     * @return Nachfolger-Switch
     */
    public Switch next() {
        if(succMax == 0) return null;
        Switch next = next(succCount);
        succCount = (succCount + 1) % succMax;
        return next;
    }

    /**
     * Rekursive Hilfsfunktion.
     * Indem der Funktion eine Tiefe uebergeben werden kann, werden alle Child-Switches durchlaufen, bis der
     * aktuelle Nachfolger gefunden wurde.
     * @param depth
     * @return Nachfolger-Switch
     */
    public Switch next(int depth) {
        if(depth > 1) return childSucc.next(depth - 2);
        if(depth == 0) return succ0;
        return succ1;
    }

    /**
     * Funktion, die in allen zu durchlaufenden Switches ausgefuehrt wird, um einen Murmellauf zu simulieren
     * @return Der letzte Switch
     */
    public Switch findLast() {
        Switch last = next();
        if(last == null) return this;
        if(last.next() == null) return last;
        return last.findLast();
    }

    /**
     * Funktion, um die direkten Nachfolger (maximal 2) eines Switches zu erhalten.
     * @return Switch-Array mit maximal 2 Nachfolgern und keinen null-Werten
     */
    public Switch[] directSuccessors() {
        if(succ0 == null && succ1 == null) {
            return new Switch[0];
        }
        if(succ0 != null && succ0 == succ1) {
            return new Switch[]{succ0};
        }
        return new Switch[]{succ0, succ1};
    }

    /**
     * Wrapperfunktion fuer die rekursive Version, siehe unten
     * @return Switch-Array mit allen Nachfolgern eines Switches
     */
    public Switch[] allSuccessors() {
        return allSuccessors(new Switch[0]);
    }

    /**
     * Funktion, um rekursiv alle Nachfolger eines Switches zu bestimmen.
     * Es wird ueber alle Child-Switches iteriert.
     * @param succs Rekursionsvariable der bereits gesammelten Switches.
     * @return Switch-Array mit allen Nachfolgern eines Switches
     */
    public Switch[] allSuccessors(Switch[] succs) {
        Switch[] temp = directSuccessors();
        Switch[] out = new Switch[temp.length + succs.length];
        joinSuccessorArrays(temp, succs, out, 0, 0);
        if(childSucc == null) return out;
        return childSucc.allSuccessors(out);
    }

    /**
     * Funktion, um die Zahl aller einzigartigen Switches ausgehend von der aktuellen Instanz zu bestimmen
     * @return Zahl der Switches
     */
    public int countSwitches() {
        return collectAllUniqueSwitches().length;
    }

    /**
     * Funktion, um alle einzigartigen Switches ausgehend von der aktuellen Instanz zu bestimmen.
     * @return Switch-Array der einzigartigen Switches
     */
    public Switch[] collectAllUniqueSwitches() {
        Switch[] allSuccs = allSuccessors();
        SwitchContainer allUnique = new SwitchContainer(new Switch[0]);
        collectUniqueSwitchesFromArray(allUnique, allSuccs, 0);
        return allUnique.switches;
    }

    /**
     * Rekursive Methode, um einzigartige Switches aus einem Array zu bestimmen.
     * Fuer jedes Element aus successors wird geprueft, ob sich dieses bereits in switches befindet. Falls
     * nicht, wird es hinzugefuegt.
     * @param switches Switch-Container der Elemente, fuer die die Elemente aus successors einzigartig sein sollen.
     * @param successors Switch-Elemente, die ueberprueft und hinzugefuegt werden sollen.
     * @param index Rekursions-Index
     */
    public void collectUniqueSwitchesFromArray(SwitchContainer switches, Switch[] successors, int index) {
        if(index < successors.length) {
            Switch currentSucc = successors[index];
            Switch addedSucc = returnNewSwitchInArray(switches.switches, currentSucc, 0);
            if(addedSucc != null) {
                switches.switches = addSwitchIfNotInArray(switches.switches, addedSucc, 0);
                collectUniqueSwitchesFromArray(switches, addedSucc.allSuccessors(), 0);
            }
            collectUniqueSwitchesFromArray(switches, successors, index + 1);
        }
    }

    /**
     * Hilfsmethode, um zwei Switch-Arrays a und b zu einem zu kombinieren
     * @param a Switch-Array a
     * @param b Switch-Array b
     * @param output Zusammengefuegtes Switch-Array
     * @param indexA Rekursionsindex fuer Arrray a
     * @param indexB Rekursionsindex fuer Arrray b
     */
    private void joinSuccessorArrays(Switch[] a, Switch[] b, Switch[] output, int indexA, int indexB) {
        if(indexA < a.length) {
            output[indexA] = a[indexA];
            joinSuccessorArrays(a, b, output, indexA + 1, indexB);
            return;
        }
        if(indexB < b.length) {
            output[a.length + indexB] = b[indexB];
            joinSuccessorArrays(a, b, output, indexA, indexB + 1);
        }
    }

    /**
     * Hilfsfunktion, um einen Switch zu einem Switch-Array hinzuzufuegen, falls dieser noch nicht
     * im Array enthalten ist.
     * @param a Switch-Array, zu dem der Switch hinzugefuegt werden soll.
     * @param target Der zu hinzuzufuegende Switch.
     * @param index Rekursionsindex
     * @return Neues Switch-Array, entweder mit einem weiteren Element oder ohne.
     */
    private Switch[] addSwitchIfNotInArray(Switch[] a, Switch target, int index) {
        if(index < a.length) {
            if(a[index] == target) return a;
            return addSwitchIfNotInArray(a, target, index + 1);
        }
        Switch[] output = new Switch[a.length + 1];
        joinSuccessorArrays(a, new Switch[]{target}, output, 0, 0);
        return output;
    }

    /**
     * Hilfsfunktion, um einem einen Switch zu einem Switch-Array hinzuzufuegen, falls dieser noch nicht
     * im Array enthalten ist und diesen zurueckzugeben, falls er hinzugefuegt wurde, ansonsten null
     * @param a Switch-Array, zu dem der Switch hinzugefuegt werden soll.
     * @param target Switch, der hinzugefuegt werden soll.
     * @param index Rekursionsindex
     * @return Switch, falls er hinzugefuegt wurde, ansonsten null.
     */
    private Switch returnNewSwitchInArray(Switch[] a, Switch target, int index) {
        Switch[] output = addSwitchIfNotInArray(a, target, index);
        if(output.length > a.length) return target;
        return null;
    }

}

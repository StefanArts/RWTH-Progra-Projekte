package de.stefan.progra.projects.homework4;

public class Karte {

    Farbe farbe;
    Wert wert;

    @Override
    public String toString() {
        return farbe.name() + wert.name();
    }

    public static Karte neueKarte(Farbe farbe, Wert wert) {
        Karte karte = new Karte();
        karte.farbe = farbe;
        karte.wert = wert;
        return karte;
    }

    public static int kombinationen() {
        return (Farbe.values().length * Wert.values().length);
    }

    public static Karte[] skatblatt() {
        Karte[] ergebnis = new Karte[kombinationen()];
        for (int i = 0; i < Farbe.values().length; i++) {
            for (int j = 0; j < Wert.values().length; j++) {
                int pos = i * Wert.values().length + j;
                ergebnis[pos] = neueKarte(Farbe.values()[i], Wert.values()[j]);
            }
        }
        return ergebnis;
    }
}

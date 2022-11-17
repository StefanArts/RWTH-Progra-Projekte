package de.stefan.progra.projects.homework4;

public class Spieler {
    Karte[] kartenhand;
    int kartenanzahl;
    String name;

    public static void main(String[] args) {
        System.out.println("Gewinner:" + spiel(Spielverwaltung.generiereClub(8)));
    }

    @Override
    public String toString() {
        return name;
    }

    private Karte entferneKarte(int pos) {
        if (kartenhand[pos] != null) {
            Karte temp = kartenhand[pos];
            kartenhand[pos] = null;
            kartenanzahl--;
            handAufraeumen(pos);
            return temp;
        }
        return null;
    }

    private void handAufraeumen(int pos) {
        for (int i = pos; i < kartenhand.length - 1; i++){
            if (kartenhand[i + 1] == null) break;
            kartenhand[i] = kartenhand[i + 1];
        }
    }

    private Karte passendeKarte(Farbe f) {
        for (int i = 0; i < kartenhand.length; i++) {
            if (kartenhand[i] == null || kartenhand[i].farbe == f) {
                return entferneKarte(i);
            }
        }
        return null;
    }

    private Karte spieleKarte(Karte[] ks) {
        Karte temp;
        if (ks[0] == null) {
            temp = entferneKarte(0);
        }
        else {
            temp = passendeKarte(ks[0].farbe);
            if (temp == null) temp = kartenhand[0];
        }
        return temp;
    }

    public static int hoechsteKarte(Karte[] ks) {
        int hoechste = 0;
        for (int i = 1; i < ks.length; i++) {
            if (ks[i] == null) break;
            if (ks[i].farbe == ks[hoechste].farbe && ks[i].wert.ordinal() > ks[hoechste].wert.ordinal()) {
                hoechste = i;
            }
        }
        return hoechste;
    }

    public static Spieler spiel(Spieler... club) {
        Spielverwaltung.gibKarten(club, Karte.skatblatt());
        Karte[] stapel = new Karte[club.length];
        int gewinner = 0;
        int rundengewinner = gewinner;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < club.length; j++) {
                int aktuellerSpieler = (rundengewinner + j) % club.length;
                stapel[j] = club[aktuellerSpieler].spieleKarte(stapel);
                if (j == hoechsteKarte(stapel)) {
                    gewinner = aktuellerSpieler;
                }
            }
            stapel = new Karte[club.length];
            rundengewinner = gewinner;
        }
        return club[gewinner];
    }


}

package de.stefan.progra.projects;

import de.stefan.progra.util.SimpleIO;

public class DateCalculator {

    public static void main (String[] args) {
        int day = SimpleIO.getInt("Bitte geben Sie die Tageskomponente des Startdatums ein.");
        int month = SimpleIO.getInt("Bitte geben Sie die Monatskomponente des Startdatums ein.");
        int year = SimpleIO.getInt("Bitte geben Sie die Jahreskomponente des Startdatums ein.");
        int daysToAdd = SimpleIO.getInt("Bitte geben Sie die Anzahl an Tagen ein:");

        // Teste, ob der Nutzer eine nicht valide Eingabe gemacht hat
        if (day < 1 || day > getMaxDaysInMonth(month) ||
            month < 1 || month > 12 ||
            year < 1 || year == Integer.MAX_VALUE ||
            daysToAdd < 1 || daysToAdd == Integer.MAX_VALUE)  {
            SimpleIO.output("Eine Ihrer Eingaben ist nicht korrekt, bitte versuchen Sie es erneut");
            return;
        }

        /*
        Hauptschleife
        Diese Schleife zaehlt die Tage hoch, bis der letzte Tag des aktuellen Monats oder Jahres ueberschritten wird.
        Dann erhoeht sich der Monat oder das Jahr.
         */
        for (int i = 0; i < daysToAdd; i++) {
            day++;
            if (day > getMaxDaysInMonth(month)) {
                day = 1;
                month++;
            }
            if (month > 12) {
                month = 1;
                year++;
            }

        }
        SimpleIO.output("Das Datum " + day + "." + month + "." + year + " befindet sich " + daysToAdd +
                " Tage nach dem Startdatum");
    }

    /*
    Methode, um die Tage eines bestimmten Monats zu bestimmen
     */
    public static int getMaxDaysInMonth(int month) {
        if (month == 2) return 29;
        if (month % 2 == 0) return 30;
        return 31;
    }

}

package de.stefan.progra.projects.mathhelp;

public class Division {

    public static void main(String[] args) {
        System.out.println("" + (-56 % 47));
    }

    public static void einheiten(int i) {
        StringBuilder zahlen = new StringBuilder();
        int einheiten = 0;
        for (int j = 1; j < i; j++) {
            if(ggt(i, j) == 1) {
                zahlen.append(j).append(", ");
                einheiten++;
            }
        }
        System.out.println(zahlen);
        System.out.println(einheiten);
    }

        public static int ggt(int a, int b) {
            // Hier versuche ich Arbeitsaufwand (Rechnenzeit) zu sparen in dem ich
            // mir die kleinste Zahl suche.
            int h = (a > b) ? b : a;
            // Der GGT wird hier berechnet.
            for (int i = h; i > 1; i--) {
                if ((a % i) == 0 && (b % i) == 0) {
                    return i;
                }
            }
            // teilerfremde Zahlen haben immer den Teiler 1
            return 1;
        }


    public static int euclidAlgo(int a, int b) {
        int r = 0;
        int c;
        c = (a - r) / b;
        r = a % b;
        System.out.printf("c: %s r: %s \n", c, r);
        if(r != 0) {
            c = euclidAlgo(r, b);
        }
        return c;
    }
}

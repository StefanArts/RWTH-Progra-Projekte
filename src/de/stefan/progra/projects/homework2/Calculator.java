package de.stefan.progra.projects.homework2;

import de.stefan.progra.util.SimpleIO;

public class Calculator {

    public static final String MSG_INPUT_INT = "Bitte geben Sie eine Zahl ein:";
    public static final String MSG_INPUT_OP = "Bitte geben Sie eine Rechenoperation (ADD,SUB,MUL,DIV) oder STOP ein:";
    public static final String MSG_NOT_VALID = "Das ist keine gültige Eingabe!";
    public static final String MSG_CONFIRMATION = "Sind sie sicher, dass Sie mit der Zahl "
            + Integer.MAX_VALUE + " rechnen möchten? Falls ja, fahren Sie fort. " +
            "Falls nein, stoppen Sie das Programm und starten es neu";

    public static final String MSG_TEMP_RESULT = "Aktuelles Ergebnis: ";
    public static final String MSG_FINAL_RESULT = "Endergebnis: ";

    public static void main(String[] args) {

        int result = SimpleIO.getInt(MSG_INPUT_INT);
        if(result == Integer.MAX_VALUE)
            SimpleIO.output(MSG_CONFIRMATION);

        while(true) {

            String op = SimpleIO.getString(MSG_INPUT_OP);
            while(op == null || !isMathOp(op) && !op.equals("STOP")) {
                SimpleIO.output(MSG_NOT_VALID);
                op = SimpleIO.getString(MSG_INPUT_OP);
            }

            if(op.equals("STOP")) break;

            int y = SimpleIO.getInt(MSG_INPUT_INT);
            if(y == Integer.MAX_VALUE)
                SimpleIO.output(MSG_CONFIRMATION);

            result = calculate(result, y, op);
            SimpleIO.output(MSG_TEMP_RESULT + result);

        }
        SimpleIO.output(MSG_FINAL_RESULT + result);
    }

    public static boolean isMathOp(String op) {
        if( !op.equals("ADD") &&
            !op.equals("SUB") &&
            !op.equals("MUL") &&
            !op.equals("DIV")) return false;
        return true;
    }

    public static int calculate(int s1, int s2, String operation) {
        switch (operation) {
            case "ADD":
                return s1 + s2;
            case "SUB":
                return s1 - s2;
            case "MUL":
                return s1 * s2;
            case "DIV":
                return s1 / s2;
            default:
                throw new IllegalArgumentException("This operation does not exist");
        }
    }

}

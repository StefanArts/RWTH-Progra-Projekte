package de.stefan.progra.projects.homework3;

import de.stefan.progra.util.SimpleIO;

import java.util.Stack;

/**
 * Programm, welches einen einfachen Stack implementiert
 */
public class JavaStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    String userInput = "";
    boolean terminate = false;

    mainLoop: while(true) {
      if(terminate) {
        userInput = "PRINT";
      }
      if(userInput.equals("")) {
        userInput = SimpleIO.getString("Bitte geben Sie eine Operation (PUSH,POP,CLEAR,SETSIZE,PRINT,STOP) ein:");
      }

      switch (userInput) {
        case "PUSH"-> {
          String stackIn;
          while((stackIn = SimpleIO.getString("Bitte geben Sie den String ein, der zum Stack hinzugefuegt werden soll")) == null
                  || stackIn.equals("")) {
            SimpleIO.output("Der String darf nicht leer sein.");
          }
          stack.push(stackIn);
          SimpleIO.output("Das Element wurde erfolgreich hinzugefuegt!");
        }
        case "POP" -> {
          if(stack.empty()) {
            SimpleIO.output("Der Stack ist leer. Es koennen keine weiteren Objekte entfernt werden.");
            break;
          }
          stack.pop();
          SimpleIO.output("Das oberste Element des Stacks wurde erfolgreich entfernt.");
        }
        case "CLEAR" -> {
          stack.clear();
        }
        case "PRINT" -> {
          SimpleIO.output("Stack: " + stack);
          if(terminate) break mainLoop;
        }
        case "STOP" -> {
          terminate = true;
        }
      }
      userInput = "";
    }
  }
}

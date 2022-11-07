package de.stefan.progra.projects.homework3;

import de.stefan.progra.util.SimpleIO;

/**
 * Programm, welches einen einfachen Stack implementiert
 */

public class OurStack {

  public static void main(String[] args) {
    String[] stack = null;
    int currentSize = 0;
    String userInput = "";
    boolean initialized = false, terminate = false;

    mainLoop: while(true) {
      if(!initialized) {
        userInput = "SETSIZE";
        initialized = true;
      }
      if(terminate) {
        userInput = "PRINT";
      }
      if(userInput == "") {
        userInput = SimpleIO.getString("Bitte geben Sie eine Operation (PUSH,POP,CLEAR,SETSIZE,PRINT,STOP) ein:");
      }

      switch (userInput) {
        case "PUSH"-> {
          if(currentSize == stack.length) {
            SimpleIO.output("Der Stack ist voll. Es koennen keine weiteren Objekte hinzugefuegt werden.");
            break;
          }
          String stackIn;
          while((stackIn = SimpleIO.getString("Bitte geben Sie den String ein, der zum Stack hinzugefuegt werden soll")) == null
                  || stackIn.equals("")) {
            SimpleIO.output("Der String darf nicht leer sein.");
          }
          stack[currentSize] = stackIn;
          currentSize++;
          SimpleIO.output("Das Element wurde erfolgreich hinzugefuegt!");
        }
        case "POP" -> {
          if(currentSize == 0) {
            SimpleIO.output("Der Stack ist leer. Es koennen keine weiteren Objekte entfernt werden.");
            break;
          }
          stack[currentSize-1] = null;
          currentSize--;
          SimpleIO.output("Das oberste Element des Stacks wurde erfolgreich entfernt.");
        }
        case "CLEAR" -> {
          stack = new String[stack.length];
        }
        case "SETSIZE" -> {
          int newSize = -1;
          while(newSize < 1) {
            newSize = SimpleIO.getInt("Bitte gegen Sie die (nicht negative) Groesse des Stacks ein:");
          }
          String[] newStack = new String[newSize];
          currentSize = 0;
          if(stack != null) {
            for(int i = 0; i < newStack.length; i++) {
              if(i >= stack.length || stack[i] == null) break;
              newStack[i] = stack[i];
              currentSize++;
            }
          }
          stack = newStack;
        }
        case "PRINT" -> {
          if(currentSize == 0) SimpleIO.output("Der Stack ist leer.");
          else {
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < currentSize; i++) {
              if(output.isEmpty()){
                output.append("Stack: ").append(stack[i]);
                continue;
              }
              output.append(",").append(stack[i]);
            }
            SimpleIO.output("" + output);
          }
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

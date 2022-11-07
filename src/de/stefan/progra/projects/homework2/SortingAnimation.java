package de.stefan.progra.projects.homework2;

import java.util.concurrent.TimeUnit;

public class SortingAnimation {

    int[] array;

    /*
    NOTE: ONLY WORKS FOR NUMBERS SMALLER THAN 100
     */
    public SortingAnimation(int[] array) {
        this.array = array;
        outputArray();
    }

    public void swapAnimation(int posA, int posB) throws InterruptedException {
        posA = getPos(posA);
        posB = getPos(posB);
        if(posA == posB) {
            outputArray();
            return;
        }
        int diff = posA - posB;
        if(diff < 0) diff = diff * -1;

        StringBuilder output;
        int arrowA = posA;
        int arrowB = posB;

        for(int j = 0; j < diff; j++) {
            arrowA += 5;
            arrowB -= 5;
            output = new StringBuilder();
            for(int i = 1; i <= posB; i++) {
                if(i == arrowA) output.append(">");
                else if(i == arrowB) output.append("<");
                else output.append(" ");
            }
            System.out.println(output);
            outputArray();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void outputArray() {
        StringBuilder output = new StringBuilder("[ " + array[0]);
        for(int i = 1; i < array.length; i++) {
            if(array[i] < 10) output.append("0");
            output.append(" | ").append(array[i]);
        }
        System.out.println(output + " ]");
    }

    public int getPos(int pos) {
        return 3 + pos * 5;
    }
}

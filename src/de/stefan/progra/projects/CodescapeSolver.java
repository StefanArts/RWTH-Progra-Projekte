package de.stefan.progra.projects;

public class CodescapeSolver {

    public void test() {
        try {
            Runtime r = Runtime.getRuntime();
            String command = "tree";
            Process p = r.exec(command.split(" "));

            java.io.BufferedReader stdInput = new java.io.BufferedReader(new
                    java.io.InputStreamReader(p.getInputStream()));

            java.io.BufferedReader stdErrInput = new java.io.BufferedReader(new
                    java.io.InputStreamReader(p.getErrorStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            while ((s = stdErrInput.readLine()) != null) {
                System.out.println(s);
            }


        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void listAllFiles(java.io.File directory) {
        for (java.io.File file : directory.listFiles()) {
            if (file.isDirectory()) {
                listAllFiles(directory);
            } else {
                String name = file.getName();
                System.out.println("File: " + name + ", Dir: " + directory.getName());
            }
        }
    }
}

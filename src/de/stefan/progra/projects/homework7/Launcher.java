package de.stefan.progra.projects.homework7;

public class Launcher {

    public static void main(String[] args) {
        Operation[] operations = new Operation[] {
                new AddTextAtOperation(0, "Hello Aachen!"),
                new ReplaceTextSectionOperation(6, 12, "World"),
                new UndoOperation(),
                new ReplaceTextSectionOperation(0, 5, "Goodbye"),
                new RemoveTextSectionOperation(14, 15)
        };
        TextDocument document = new TextDocument("");
        for(Operation o : operations) {
            System.out.println(document.getContent());
            System.out.println(o.getDescription());
            document = o.apply(document);
        }
        System.out.println(document.getContent());
    }
}

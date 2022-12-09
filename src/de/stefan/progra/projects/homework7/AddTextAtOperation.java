package de.stefan.progra.projects.homework7;

public class AddTextAtOperation extends Operation {

    private int position;
    private String addition;

    public AddTextAtOperation(int position, String addition) {
        this.position = position;
        this.addition = addition;
    }

    @Override
    public TextDocument apply(TextDocument current) {
        return current.addTextAt(position, addition);
    }

    @Override
    public String getDescription() {
        return "adds the following text at position " + position + ": " + addition;
    }
}
package de.stefan.progra.projects.homework7;

public class RemoveTextSectionOperation extends Operation {

    private int beginIndex;
    private int endIndex;

    public RemoveTextSectionOperation(int beginIndex, int endIndex) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    @Override
    public TextDocument apply(TextDocument current) {
        return current.removeTextSection(beginIndex, endIndex);
    }

    @Override
    public String getDescription() {
        return "removes the text section from " + beginIndex + " to " + endIndex;
    }
}
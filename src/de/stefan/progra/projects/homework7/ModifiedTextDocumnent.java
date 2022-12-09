package de.stefan.progra.projects.homework7;

public class ModifiedTextDocumnent extends TextDocument{
    private TextDocument recentVersion;

    public ModifiedTextDocumnent(TextDocument document, String content) {
        super(content);
        recentVersion = document;
    }

    @Override
    public TextDocument undo() {
        return recentVersion;
    }
}

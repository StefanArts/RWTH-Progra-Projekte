package de.stefan.progra.projects.homework7;

public class ModifiedTextDocument extends TextDocument{
    private TextDocument recentVersion;

    public ModifiedTextDocument(TextDocument document, String content) {
        super(content);
        recentVersion = document;
    }

    @Override
    public TextDocument undo() {
        return recentVersion;
    }
}

package de.stefan.progra.projects.homework7;

public class TextDocument {
    private final String content;

    public TextDocument(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public TextDocument noop() {
        return new ModifiedTextDocumnent(this, content);
    }

    public TextDocument replaceTextSection(int beginIndex, int endIndex, String replacement) {
        String toReplace = content.substring(beginIndex, endIndex);
        String newContent = content.replace(toReplace, replacement);
        return new ModifiedTextDocumnent(this, newContent);
    }

    public TextDocument addTextAt(int position, String addition) {
        String newContent = addition;
        if(!content.equals("")) {
            newContent = content.replace(
                    content.charAt(position) + "",
                    content.charAt(position) + addition
            );
        }
        return new ModifiedTextDocumnent(this, newContent);
    }

    public TextDocument removeTextSection(int beginIndex, int endIndex) {
        return replaceTextSection(beginIndex, endIndex, "");
    }

    public TextDocument undo() {
        return this;
    }
}

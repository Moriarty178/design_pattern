package behavioral_patterns.memento_pattern.editor;

public class Document {
    private String content;

    public void setContent(String content) {
        this.content = content;
        System.out.println("Current content: " + this.content);
    }

    public String getContent() {
        return content;
    }

    public DocumentMemento save() {
        return new DocumentMemento(content);
    }

    public void restore(DocumentMemento memento) {
        this.content = memento.getContent();
        System.out.println("Restored content: " + this.content);
    }
}

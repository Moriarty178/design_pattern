package behavioral_patterns.memento_pattern.caretaker;

import behavioral_patterns.memento_pattern.editor.DocumentMemento;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class DocumentHistory {
    private Stack<DocumentMemento> history = new Stack<>();

    public void save(DocumentMemento memento) {
        history.push(memento);
    }

    public DocumentMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }
}

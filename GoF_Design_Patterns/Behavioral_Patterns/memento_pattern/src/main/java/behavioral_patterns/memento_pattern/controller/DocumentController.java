package behavioral_patterns.memento_pattern.controller;

import behavioral_patterns.memento_pattern.caretaker.DocumentHistory;
import behavioral_patterns.memento_pattern.editor.Document;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    private final Document document = new Document();
    private final DocumentHistory history;

    public DocumentController(DocumentHistory history) {
        this.history = history;
    }

    @PostMapping("/edit")
    public String edit(@RequestParam String content) {
        history.save(document.save());
        document.setContent(content);
        return "Edited: " + content;
    }

    @PostMapping("/undo")
    public String undo() {
        if (history.hasHistory()) {
            document.restore(history.undo());
            return "Undo performed: " + document.getContent();
        }

        return "No history to undo.";
    }

    @GetMapping("/current")
    public String current() {
        return "Current: " + document.getContent();
    }
}

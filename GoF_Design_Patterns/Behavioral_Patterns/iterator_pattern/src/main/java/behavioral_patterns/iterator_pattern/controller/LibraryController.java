package behavioral_patterns.iterator_pattern.controller;

import behavioral_patterns.iterator_pattern.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        return service.getAllBookTitles();
    }

    @GetMapping("/reverse")
    public List<String> getBookReversed() {
        return service.getAllBookTitlesReversed();
    }

    @GetMapping("/filter")
    public List<String> getFilteredBooks(@RequestParam String keyword) {
        return service.getFilteredBooks(keyword);
    }
}

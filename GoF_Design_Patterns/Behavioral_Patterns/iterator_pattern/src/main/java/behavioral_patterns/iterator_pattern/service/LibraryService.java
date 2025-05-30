package behavioral_patterns.iterator_pattern.service;

import behavioral_patterns.iterator_pattern.iterator.Iterator;
import behavioral_patterns.iterator_pattern.iterator.ReverseBookIterator;
import behavioral_patterns.iterator_pattern.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private final BookCollection bookCollection;

    public LibraryService(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
        initBooks();
    }

    private void initBooks() {
        bookCollection.addBook(new Book("Clean Code"));
        bookCollection.addBook(new Book("Effective Java"));
        bookCollection.addBook(new Book("Design Patterns Explained"));
    }

    public List<String> getAllBookTitles() {
        return getTitlesFromIterator(bookCollection.createIterator());
    }

    public List<String> getAllBookTitlesReversed() {
//        List<String> titles = new ArrayList<>();
//        Iterator<Book> iterator = bookCollection.createReverseIterator();
//        while(iterator.hasNext()) {
//            titles.add(iterator.next().getTitle());
//        }
//
//        return titles;
        return getTitlesFromIterator(bookCollection.createReverseIterator());

    }

    public List<String> getFilteredBooks(String keyword) {
        return getTitlesFromIterator(
                bookCollection.createFilteredIterator(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
        );
    }

    public List<String> getTitlesFromIterator(Iterator<Book> iterator) {
        List<String> titles = new ArrayList<>();
        while(iterator.hasNext()) {
            titles.add(iterator.next().getTitle());
        }

        return titles;
    }
}

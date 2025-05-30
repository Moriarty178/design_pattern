package behavioral_patterns.iterator_pattern.service;

import behavioral_patterns.iterator_pattern.iterator.BookIterator;
import behavioral_patterns.iterator_pattern.iterator.Iterator;
import behavioral_patterns.iterator_pattern.iterator.ReverseBookIterator;
import behavioral_patterns.iterator_pattern.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class BookCollection {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }

    public Iterator<Book> createReverseIterator() {
        return new ReverseBookIterator(books);
    }

    public Iterator<Book> createFilteredIterator(Predicate<Book> condition) {
        List<Book> filtered = books.stream().filter(condition).toList();
        return new BookIterator(filtered);
    }
}

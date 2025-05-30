package behavioral_patterns.iterator_pattern.iterator;

import behavioral_patterns.iterator_pattern.model.Book;

import java.util.List;

public class BookIterator implements Iterator<Book> {
    private final List<Book> books;
    private int position;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        return books.get(position++);
    }
}

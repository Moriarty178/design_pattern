package behavioral_patterns.iterator_pattern.iterator;

import behavioral_patterns.iterator_pattern.model.Book;

import java.util.List;

public class ReverseBookIterator implements Iterator<Book> {

    private final List<Book> books;
    private int position;

    public ReverseBookIterator(List<Book> books) {
        this.books = books;
        this.position = books.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Book next() {
        return books.get(position--);
    }
}

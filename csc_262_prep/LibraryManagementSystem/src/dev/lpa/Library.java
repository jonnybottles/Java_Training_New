package dev.lpa;

import dev.lpa.Book;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    private boolean isOpen;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.isOpen = false;

    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }


    public boolean openLibrary() {
        if (isOpen) {
            System.out.printf("Library %s is already open. Come on in!\n", getName());

        } else {
            this.isOpen = true;
            System.out.printf("Library %s has been opened!\n", getName());
        }

        return true;
    }

    public boolean closeLibrary() {
        if (!isOpen) {
            System.out.printf("Library %s is already closed!\n", getName());
        } else {
            this.isOpen = false;
            System.out.printf("Library %s has been closed!\n", getName());
        }

        return true;
    }

    public boolean addBook(Book book) {
        Book newBook = findBook(book.getTitle());
        if (newBook == null) {
            books.add(book);
            return true;
        } else {
            System.out.printf("Book %s already in library.\n", book.getTitle());
            return false;
        }
    }

    public boolean removeBook(Book book) {
        Book newBook = findBook(book.getTitle());
        if (newBook != null) {
            books.remove(book);
            return true;
        } else {
            System.out.println();
            System.out.printf("Book %s does not exist in library.\n", book.getTitle());
            return false;
        }
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }

        return null;

    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book.displayInfo());
        }
    }

}

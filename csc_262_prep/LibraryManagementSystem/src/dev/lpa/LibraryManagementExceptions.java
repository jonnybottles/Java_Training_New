package dev.lpa;

public class LibraryManagementExceptions {
    public static class BookNotFoundException extends Exception {

        public BookNotFoundException(String message) {
            super(message);
        }

    }

}


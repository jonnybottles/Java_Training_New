package dev.lpa;

public class Main {
    public static void main(String[] args) {
        Library theLibrary = new Library("Deposit Public Library");
        theLibrary.openLibrary();

//        Book theDevOpsHandBook = new Book("DevOps Handbook", "Gene Kim", 2017);
//        theDevOpsHandBook.addRating(5);
//        theDevOpsHandBook.addRating(3);
//        theLibrary.addBook(theDevOpsHandBook);

        EBook theGUIS = new EBook("Why GUIs are For Bitches", "Lorenzo Ireland", 2014, 69);
        theGUIS.addRating(5);
//        theGUIS.addRating(5);
        theLibrary.addBook(theGUIS);

        AudioBook the0689Book = new AudioBook("How to Become and Honorary 0689", "Paul Navarro", 2017, 100);
        the0689Book.addRating(1);
//        the0689Book.addRating(1);
        theLibrary.addBook(the0689Book);

        theLibrary.listBooks();
        theLibrary.closeLibrary();


    }
}
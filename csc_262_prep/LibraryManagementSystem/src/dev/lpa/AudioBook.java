package dev.lpa;

public class AudioBook extends Book{

    private int length;

    public AudioBook(String title, String author, int yearPublished, int length) {
        super(title, author, yearPublished);
        this.length = length;
    }

    public int getLength() {
        return length;
    }


    @Override
    public String displayInfo() {
        return super.displayInfo() + " Audio Book Length: " + getLength();
    }
}

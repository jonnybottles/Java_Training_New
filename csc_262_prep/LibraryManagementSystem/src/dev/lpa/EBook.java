package dev.lpa;

public class EBook extends Book{

    private int fileSize;

    public EBook(String title, String author, int yearPublished, int fileSize) {
        super(title, author, yearPublished);
        this.fileSize = fileSize;
    }

    public int getFileSize() {
        return fileSize;
    }


    @Override
    public String displayInfo() {
        return super.displayInfo() + " File Size: " + getFileSize() + "Mb";
    }
}

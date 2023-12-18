package dev.lpa;

public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private int[] ratings;
    private int currentRatingIndex;


    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.ratings = new int[]{-1};
        this.currentRatingIndex = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int[] getRatings() {
        return ratings;
    }

    public void addRating(int rating) {
        if (isValidRating(rating)) {
            if (currentRatingIndex >= ratings.length) {
                increaseRatingSize();
            }
            ratings[currentRatingIndex++] = rating;
        } else {
            System.out.println("Please enter a rating between 1 and 5");
        }
    }

    private void increaseRatingSize() {
        int[] newArray = new int[ratings.length + 1];
        System.arraycopy(ratings, 0, newArray, 0, ratings.length);
        ratings = newArray; // Assign the new array back to the ratings field
    }
    private boolean isValidRating(int rating) {
        if (rating >=1 && rating <=5) {
            return true;
        }
        return false;
    }

    private int averageRating() {
        if (ratings[0] != -1) {
            int sum = 0;
            for (int i = 0; i < ratings.length -1;  i++) {
                sum += ratings[i];
            }
            return sum / ratings.length;
        } else {
            System.out.printf("Book %s has no ratings.", getTitle());
            return -1;
        }
    }

    public String displayInfo() {
        return "Book Type: " + getClass().getSimpleName() + " Title: " + getTitle() +
                " Author: " + getAuthor() + " Year Published: " + getYearPublished() + " Average Rating " + averageRating();
    }
}

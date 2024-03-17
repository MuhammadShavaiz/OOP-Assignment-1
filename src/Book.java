class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;

    public Book(String bookId, String title, String author, String genre, boolean availabilityStatus) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }

    public void setAvailability(boolean availability) {
        this.availabilityStatus = availability;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + availabilityStatus;
    }
}

import java.util.ArrayList;
import java.util.List;
class User {
    private String userId;
    private String name;
    private String contactInfo;
    private List<Book> borrowedBooks;

    public User(String userId, String name, String contactInfo) {
        this.userId = userId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Contact Info: " + contactInfo;
    }
}


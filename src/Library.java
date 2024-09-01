import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void checkoutBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        if (book != null && user != null) {
            if (book.isAvailable()) {
                book.setAvailability(false);
                user.borrowBook(book);
                System.out.println("Book checked out successfully.");
            } else {
                System.out.println("Book is not available.");
            }
        } else {
            System.out.println("Book or user not found.");
        }
    }

    public void returnBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        if (book != null && user != null) {
            if (user.getBorrowedBooks().contains(book)) {
                book.setAvailability(true);
                user.returnBook(book);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book is not borrowed by this user.");
            }
        } else {
            System.out.println("Book or user not found.");
        }
    }

    public List<Book> searchBooksByTitleOrAuthor(String keyword) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public void saveBooksToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.println(book.getBookId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.isAvailable());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsersToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (User user : users) {
                writer.println(user.getUserId() + "," + user.getName() + "," + user.getContactInfo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBooksFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                Book book = new Book(parts[0], parts[1], parts[2], parts[3], Boolean.parseBoolean(parts[4]));
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Books file not found.");
        }
    }

    public void loadUsersFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                User user = new User(parts[0], parts[1], parts[2]);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Users file not found.");
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}


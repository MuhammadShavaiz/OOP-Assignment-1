import java.io.*;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private Library library;
    private Scanner scanner;

    public LibraryManagementSystem() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void createFiles() {
        try {
            File booksFile = new File("books.txt");
            File usersFile = new File("users.txt");

            if (booksFile.createNewFile()) {
                System.out.println("Books file created: " + booksFile.getAbsolutePath());
            } else {
                System.out.println("Books file already exists.");
            }

            if (usersFile.createNewFile()) {
                System.out.println("Users file created: " + usersFile.getAbsolutePath());
            } else {
                System.out.println("Users file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        Book book = new Book(bookId, title, author, genre, true);
        library.addBook(book);
    }

    public void addUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();
        User user = new User(userId, name, contactInfo);
        library.addUser(user);
    }

    public void displayBooks() {
        List<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books available:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void displayUsers() {
        List<User> users = library.getUsers();
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            System.out.println("Registered Users:");
            for (User user : users) {
                System.out.println(user);
                List<Book> borrowedBooks = user.getBorrowedBooks();
                if (!borrowedBooks.isEmpty()) {
                    System.out.println("Borrowed Books:");
                    for (Book book : borrowedBooks) {
                        System.out.println(book);
                    }
                } else {
                    System.out.println("No books borrowed.");
                }
            }
        }
    }

    public void borrowBook() {
        System.out.print("Enter Book ID to borrow: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        library.checkoutBook(bookId, userId);
    }

    public void returnBook() {
        System.out.print("Enter Book ID to return: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        library.returnBook(bookId, userId);
    }

    public void searchBooks() {
        System.out.print("Enter keyword (title or author): ");
        String keyword = scanner.nextLine();
        List<Book> foundBooks = library.searchBooksByTitleOrAuthor(keyword);
        if (!foundBooks.isEmpty()) {
            System.out.println("Books found:");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found.");
        }
    }

    public void searchUsers() {
        System.out.print("Enter User ID to search: ");
        String userId = scanner.nextLine();
        User user = library.findUserById(userId);
        if (user != null) {
            System.out.println("User found:");
            System.out.println(user);
            List<Book> borrowedBooks = user.getBorrowedBooks();
            if (!borrowedBooks.isEmpty()) {
                System.out.println("Borrowed Books:");
                for (Book book : borrowedBooks) {
                    System.out.println(book);
                }
            } else {
                System.out.println("No books borrowed.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void run() {
        createFiles();
        library.loadBooksFromFile("books.txt");
        library.loadUsersFromFile("users.txt");

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Display Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Books");
            System.out.println("8. Search Users");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    addUser();
                    break;
                case "3":
                    displayBooks();
                    break;
                case "4":
                    displayUsers();
                    break;
                case "5":
                    borrowBook();
                    break;
                case "6":
                    returnBook();
                    break;
                case "7":
                    searchBooks();
                    break;
                case "8":
                    searchUsers();
                    break;
                case "9":
                    library.saveBooksToFile("books.txt");
                    library.saveUsersToFile("users.txt");
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.run();
    }
}

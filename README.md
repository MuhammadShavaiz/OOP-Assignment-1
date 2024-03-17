# Library Management System

This is a simple command-line library management system written in Java. It allows users to manage books and users in a library, including functionalities like adding books and users, displaying available books, borrowing and returning books, and searching for books and users.

## Features

- **Add Book**: Allows users to add new books to the library by providing book ID, title, author, and genre.
- **Add User**: Enables users to register new users in the library by providing user ID, name, and contact information.
- **Display Books**: Displays the list of available books in the library, including their details such as title, author, and availability status.
- **Display Users**: Displays the list of registered users in the library along with their details and the books they have borrowed.
- **Borrow Book**: Allows users to borrow a book by providing the book ID and user ID. Checks if the book is available and updates the availability status accordingly.
- **Return Book**: Enables users to return a borrowed book by providing the book ID and user ID. Updates the availability status of the book and removes it from the user's borrowed books list.
- **Search Books**: Allows users to search for books by title or author. Displays the list of books matching the search keyword.
- **Search Users**: Allows users to search for users by user ID. Displays the user's details and the books they have borrowed.

## How to Use

1. **Setup**: Compile the Java files and run the `LibraryManagementSystem` class.
2. **Menu**: Follow the on-screen menu to perform different operations such as adding books/users, borrowing/returning books, and searching.
3. **Input**: Enter the required information prompted by the system for each operation.
4. **Exit**: Choose the "Exit" option from the menu to save changes and exit the program.

## File Handling

- Books and users data are stored in separate text files (`books.txt` and `users.txt`).
- Upon startup, the system checks for the existence of these files. If not found, they are created.
- When exiting the program, the system saves any changes made to books and users data back to the respective files.

## Dependencies

- No external dependencies are required to run this program.

## Contributors

- This project is maintained by Muhammad Shavaiz Butt.
- Contributions are welcome. Feel free to submit bug reports or feature requests.

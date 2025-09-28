package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (!book.isIssued()) {
                book.issue();
                System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
            } else {
                System.out.println("Book is already issued!");
            }
        } else {
            System.out.println("Book/User not found!");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book '" + book.getTitle() + "' returned.");
        } else {
            System.out.println("Book not found or not issued!");
        }
    }

    public void showBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) return book;
        }
        return null;
    }

    private User findUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) return user;
        }
        return null;
    }
}
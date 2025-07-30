import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return !isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Sorry, the book is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return title + " by " + author + (isBorrowed ? " [Borrowed]" : " [Available]");
    }
}

public class LibraryManagementSystem {
    private static List<Book> library = new ArrayList<>();

    public static void addBook(String title, String author) {
        library.add(new Book(title, author));
        System.out.println("Book added: " + title);
    }

    public static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\nLibrary Books:");
        for (Book book : library) {
            System.out.println(book);
        }
    }

    public static void borrowBook(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book not found or already borrowed.");
    }

    public static void returnBook(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    addBook(title, author);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    borrowBook(title);
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    returnBook(title);
                    break;
                case 5:
                    System.out.println("Exiting Library System...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

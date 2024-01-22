import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q10 {
    public static void main(String[] args) {
        BookShop bookShop = new BookShop();

        bookShop.addBook(new Book("Author 1", "Title 1", "Pub 1", 100, 10));
        bookShop.addBook(new Book("Author 2", "Title 2", "Pub 2", 200, 20));
        bookShop.addBook(new Book("Author 3", "Title 3", "Pub 3", 300, 30));
        bookShop.addBook(new Book("Author 4", "Title 4", "Pub 4", 400, 40));

        boolean wantToBuyBook = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (wantToBuyBook) {
                System.out.print("Enter author: ");
                String author = scanner.nextLine();

                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                bookShop.buyBook(author, title, scanner);

                System.out.print("Want to buy more book [y/n]: ");
                wantToBuyBook = scanner.nextLine().contains("y");
            }
        }
    }
}

class Book {
    Book(String author, String title, String publisher, double cost, int stockPosition) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.cost = cost;
        this.stockPosition = stockPosition;
    }

    String getAuthor() {
        return author;
    }

    String getTitle() {
        return title;
    }

    String getPublisher() {
        return publisher;
    }

    double getCost() {
        return cost;
    }

    int getStockPosition() {
        return stockPosition;
    }

    void setCost(double cost) {
        this.cost = cost;
    }

    void setStockPosition(int stockPosition) {
        this.stockPosition = stockPosition;
    }

    @Override
    public String toString() {
        return "\nAuthor: " + author +
                "\nTitle: " + title +
                "\nPublisher: " + publisher +
                "\nCost: " + cost + " INR";
    }

    private final String author;
    private final String title;
    private final String publisher;
    private double cost;
    private int stockPosition;
}

class BookShop {
    BookShop() {
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void buyBook(String author, String title, Scanner scanner) {
        for (Book book : books) {
            if (book.getAuthor().equals(author) && book.getTitle().equals(title)) {
                System.out.println(book);
                System.out.print("Enter quantity: ");

                int requestedCopies = Integer.valueOf(scanner.nextLine());

                if (requestedCopies <= book.getStockPosition()) {
                    System.out.println("Total cost: " + book.getCost() * requestedCopies);
                    return;
                }

                System.out.println("Requested amount of copies not in stock.");
                return;
            }
        }
        System.out.println("Book not available in shop.");
    }

    List<Book> getBooks() {
        return books;
    }

    private final List<Book> books;
}

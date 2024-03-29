package Ass1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q7 {
    public static void main(String[] args) {
        Library library = new Library();

        library.addPublication(new Book(100, 100.0, "Book 1", "Author 1", "Author 2", "Author 3"));
        library.addPublication(new Book(200, 200.0, "Book 2", "Author 1"));
        library.addPublication(new Book(300, 300.0, "Book 3", "Author 2"));

        library.addPublication(new Journal(100, 100.0, "Journal 1", "Author 1", "Author 2"));
        library.addPublication(new Journal(200, 200.0, "Journal 2", "Author 3"));

        for (Publication publication : library.getPublications()) {
            System.out.println(publication);
        }
    }
}

class Library {
    Library() {
        publications = new ArrayList<>();
    }

    void addPublication(Publication publication) {
        publications.add(publication);
    }

    List<Publication> getPublications() {
        return publications;
    }

    private final List<Publication> publications;
}

class Book extends Publication {
    Book(int noOfPages, double price, String publisherName, String... authors) {
        super(noOfPages, price, publisherName, Arrays.asList(authors));
    }
}

class Journal extends Publication {
    Journal(int noOfPages, double price, String publisherName, String... authors) {
        super(noOfPages, price, publisherName, Arrays.asList(authors));
    }
}

abstract class Publication {
    Publication(int noOfPages, double price, String publisherName, List<String> authors) {
        this.noOfPages = noOfPages;
        this.price = price;
        this.publisherName = publisherName;
        this.authors = authors;
    }

    void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setPublisherName(String publisherName) {
        if (publisherName != null) {
            this.publisherName = publisherName;
        }
    }

    int getNoOfPages() {
        return noOfPages;
    }

    double getPrice() {
        return price;
    }

    String getPublisherName() {
        return publisherName;
    }

    @Override
    public String toString() {
        return "\nNo Of Pages = " + noOfPages +
                "\nPrice = " + price +
                "\nPublisher Name = " + publisherName +
                (authors.size() == 1 ? "\nAuthor: " + authors.get(0) : "\nAuthors: " + String.join(", ", authors));
    }

    private int noOfPages;
    private double price;
    private String publisherName;
    private List<String> authors;
}

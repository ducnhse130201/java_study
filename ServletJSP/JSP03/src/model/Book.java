package model;

public class Book {
    private String isbn;
    private String title;
    private double price;

    public Book(String isbn, String title, double price)
    {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

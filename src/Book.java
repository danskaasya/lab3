/**
 * Модель книги згідно з таблицею
 */
public class Book {
    private String title;           // Назва
    private String author;          // Автор
    private String publisher;       // Видавництво
    private int year;              // Рік видання
    private int pages;             // Кількість сторінок
    private double price;          // Ціна

    public Book(String title, String author, String publisher, int year, int pages, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    // Геттери
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getYear() { return year; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }

    // Сеттери
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setYear(int year) { this.year = year; }
    public void setPages(int pages) { this.pages = pages; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("Назва: %s, Автор: %s, Видавництво: %s, Рік: %d, Сторінок: %d, Ціна: %.2f грн",
                title, author, publisher, year, pages, price);
    }
}
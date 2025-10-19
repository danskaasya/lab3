import java.util.List;
import java.util.Scanner;

/**
 * View для відображення меню та результатів роботи з книгами
 */
public class BookView {
    private Scanner scanner;

    public BookView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Відображення головного меню
     */
    public void displayMenu() {
        System.out.println("\n=== СИСТЕМА УПРАВЛІННЯ КНИГАМИ ===");
        System.out.println("1. Показати всі книги");
        System.out.println("2. Знайти книги за автором");
        System.out.println("3. Знайти книги за видавництвом");
        System.out.println("4. Знайти книги після вказаного року");
        System.out.println("5. Відсортувати книги за видавництвами");
        System.out.println("6. Автоматичний пошук (випадкові дані)");
        System.out.println("0. Вихід");
        System.out.print("Оберіть опцію: ");
    }

    /**
     * Відображення всіх книг
     */
    public void displayAllBooks(Book[] books) {
        System.out.println("\n=== ВСІ КНИГИ ===");
        if (books.length == 0) {
            System.out.println("Книги не знайдено.");
            return;
        }
        
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
        System.out.println("Всього книг: " + books.length);
    }

    /**
     * Відображення списку книг
     */
    public void displayBooks(List<Book> books, String title) {
        System.out.println("\n=== " + title + " ===");
        if (books.isEmpty()) {
            System.out.println("Книги не знайдено.");
            return;
        }
        
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println("Знайдено книг: " + books.size());
    }

    /**
     * Введення автора з клавіатури
     */
    public String inputAuthor() {
        System.out.print("Введіть автора: ");
        return scanner.nextLine().trim();
    }

    /**
     * Введення видавництва з клавіатури
     */
    public String inputPublisher() {
        System.out.print("Введіть видавництво: ");
        return scanner.nextLine().trim();
    }

    /**
     * Введення року з клавіатури
     */
    public int inputYear() {
        System.out.print("Введіть рік: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Некоректний рік. Встановлено 2000.");
            return 2000;
        }
    }

    /**
     * Відображення повідомлення про помилку
     */
    public void displayError(String message) {
        System.out.println("ПОМИЛКА: " + message);
    }

    /**
     * Відображення повідомлення про успіх
     */
    public void displaySuccess(String message) {
        System.out.println("✓ " + message);
    }

    /**
     * Очікування натискання Enter
     */
    public void waitForEnter() {
        System.out.print("\nНатисніть Enter для продовження...");
        scanner.nextLine();
    }

    /**
     * Відображення заголовка розділу
     */
    public void displaySectionHeader(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(title);
        System.out.println("=".repeat(50));
    }

    /**
     * Читання рядка з консолі
     */
    public String readLine() {
        return scanner.nextLine();
    }

    /**
     * Закриття сканера
     */
    public void close() {
        scanner.close();
    }
}
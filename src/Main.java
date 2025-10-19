import java.util.List;

/**
 * Головний клас MVC додатку для роботи з книгами
 */
public class Main {
    private static BookController controller;
    private static BookView view;

    public static void main(String[] args) {
        // Ініціалізація MVC компонентів
        controller = new BookController();
        view = new BookView();

        // Відображення привітання та вихідного масиву
        view.displaySectionHeader("ЛАБОРАТОРНА РОБОТА №3 - MVC ДОДАТОК ДЛЯ РОБОТИ З КНИГАМИ");
        view.displayAllBooks(controller.getAllBooks());
        view.waitForEnter();

        // Головний цикл меню
        boolean running = true;
        while (running) {
            try {
                view.displayMenu();
                String choice = view.readLine().trim();

                switch (choice) {
                    case "1":
                        handleShowAllBooks();
                        break;
                    case "2":
                        handleSearchByAuthor();
                        break;
                    case "3":
                        handleSearchByPublisher();
                        break;
                    case "4":
                        handleSearchByYear();
                        break;
                    case "5":
                        handleSortByPublisher();
                        break;
                    case "6":
                        handleAutomaticSearch();
                        break;
                    case "0":
                        running = false;
                        view.displaySuccess("Дякуємо за використання програми!");
                        break;
                    default:
                        view.displayError("Некоректний вибір. Спробуйте ще раз.");
                }

                if (running) {
                    view.waitForEnter();
                }
            } catch (Exception e) {
                view.displayError("Сталася помилка: " + e.getMessage());
                view.waitForEnter();
            }
        }

        view.close();
    }

    /**
     * Показати всі книги
     */
    private static void handleShowAllBooks() {
        view.displayAllBooks(controller.getAllBooks());
    }

    /**
     * Пошук книг за автором
     */
    private static void handleSearchByAuthor() {
        String author = view.inputAuthor();
        List<Book> books = controller.getBooksByAuthor(author);
        view.displayBooks(books, "КНИГИ ЗА АВТОРОМ: " + author);
    }

    /**
     * Пошук книг за видавництвом
     */
    private static void handleSearchByPublisher() {
        String publisher = view.inputPublisher();
        List<Book> books = controller.getBooksByPublisher(publisher);
        view.displayBooks(books, "КНИГИ ЗА ВИДАВНИЦТВОМ: " + publisher);
    }

    /**
     * Пошук книг після вказаного року
     */
    private static void handleSearchByYear() {
        int year = view.inputYear();
        List<Book> books = controller.getBooksAfterYear(year);
        view.displayBooks(books, "КНИГИ ПІСЛЯ " + year + " РОКУ");
    }

    /**
     * Сортування книг за видавництвами
     */
    private static void handleSortByPublisher() {
        view.displaySuccess("Сортування книг за видавництвами...");
        Book[] sortedBooks = controller.sortBooksByPublisher();
        view.displayAllBooks(sortedBooks);
    }

    /**
     * Автоматичний пошук з випадковими даними
     */
    private static void handleAutomaticSearch() {
        view.displaySectionHeader("АВТОМАТИЧНИЙ ПОШУК З ВИПАДКОВИМИ ДАНИМИ");

        // Пошук за випадковим автором
        String randomAuthor = controller.getRandomAuthor();
        List<Book> booksByAuthor = controller.getBooksByAuthor(randomAuthor);
        view.displayBooks(booksByAuthor, "КНИГИ ЗА ВИПАДКОВИМ АВТОРОМ: " + randomAuthor);

        // Пошук за випадковим видавництвом
        String randomPublisher = controller.getRandomPublisher();
        List<Book> booksByPublisher = controller.getBooksByPublisher(randomPublisher);
        view.displayBooks(booksByPublisher, "КНИГИ ЗА ВИПАДКОВИМ ВИДАВНИЦТВОМ: " + randomPublisher);

        // Пошук за випадковим роком
        int randomYear = controller.getRandomYear();
        List<Book> booksAfterYear = controller.getBooksAfterYear(randomYear);
        view.displayBooks(booksAfterYear, "КНИГИ ПІСЛЯ ВИПАДКОВОГО РОКУ: " + randomYear);
    }
}
import java.util.*;

/**
 * Контролер для обробки масиву даних книг
 */
public class BookController {
    private Book[] books;
    private Random random;

    public BookController() {
        this.random = new Random();
        initializeBooks();
    }

    /**
     * Ініціалізація масиву книг з тестовими даними
     */
    private void initializeBooks() {
        String[] titles = {
            "1984", "Війна і мир", "Гаррі Поттер", "Володар кілець", "Анна Кареніна",
            "Маленький принц", "Дон Кіхот", "Гамлет", "Макбет", "Ромео і Джульєтта",
            "Фауст", "Божественна комедія", "Іліада", "Одіссея", "Енеїда"
        };

        String[] authors = {
            "Джордж Орвелл", "Лев Толстой", "Джоан Роулінг", "Джон Толкін", "Лев Толстой",
            "Антуан де Сент-Екзюпері", "Мігель де Сервантес", "Вільям Шекспір", "Вільям Шекспір", "Вільям Шекспір",
            "Йоганн Вольфганг фон Гете", "Данте Аліг'єрі", "Гомер", "Гомер", "Вергілій"
        };

        String[] publishers = {
            "А-ба-ба-га-ла-ма-га", "Фоліо", "А-Стрикс", "Клуб сімейного дозвілля", "Книжковий клуб",
            "Наш формат", "Країна мрій", "Віват", "Фабула", "Основи"
        };

        books = new Book[15];
        for (int i = 0; i < books.length; i++) {
            int year = 1950 + random.nextInt(74); // 1950-2024
            int pages = 100 + random.nextInt(900); // 100-1000 сторінок
            double price = 50 + random.nextInt(500); // 50-550 грн
            
            books[i] = new Book(
                titles[i],
                authors[i],
                publishers[i % publishers.length],
                year,
                pages,
                price
            );
        }
    }

    /**
     * Отримати список книг зазначеного автора
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Отримати список книг, які видані зазначеним видавництвом
     */
    public List<Book> getBooksByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Отримати список книг, виданих пізніше вказаного року
     */
    public List<Book> getBooksAfterYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Відсортувати книги за видавництвами
     */
    public Book[] sortBooksByPublisher() {
        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, (book1, book2) -> 
            book1.getPublisher().compareToIgnoreCase(book2.getPublisher()));
        return sortedBooks;
    }

    /**
     * Отримати вихідний масив книг
     */
    public Book[] getAllBooks() {
        return books.clone();
    }

    /**
     * Отримати випадковий автор з наявних
     */
    public String getRandomAuthor() {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        String[] authorArray = authors.toArray(new String[0]);
        return authorArray[random.nextInt(authorArray.length)];
    }

    /**
     * Отримати випадкове видавництво з наявних
     */
    public String getRandomPublisher() {
        Set<String> publishers = new HashSet<>();
        for (Book book : books) {
            publishers.add(book.getPublisher());
        }
        String[] publisherArray = publishers.toArray(new String[0]);
        return publisherArray[random.nextInt(publisherArray.length)];
    }

    /**
     * Отримати випадковий рік для пошуку
     */
    public int getRandomYear() {
        return 1950 + random.nextInt(50); // 1950-2000
    }
}
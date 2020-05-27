import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Book book1;
    private Book book2;
    private Book book3;

    private Library library;
    private Library library2;

    private Borrower borrower;

    @Before
    public void setup() throws Exception {
        book1 = new Book("The Gods Themselves", "Issac Asimov", "Sci-fi");
        book2 = new Book("Forza Italia", "Paddy Agnew", "Sports");
        book3 = new Book("Inverting the Pyramid", "Jonathan Wilson", "Sports");

        borrower = new Borrower("Chris");

        library = new Library(1);
        library = new Library(4);
    }

    @Test
    public void canReportCapacity() {
        assertEquals(true, library.hasCapacity());
    }

    @Test
    public void canAddBook__whenThereIsRoom(){
        library.addBook(book1);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void cantAddBook__whenNoRoom(){
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(1, library.bookCount());
    }

    @Test
    public void checkBookAvailable(){
        assertEquals(false, library.checkInStock(book1));
    }

    @Test
    public void checkBookAvailable__true(){
        library.addBook(book1);
        assertEquals(true, library.checkInStock(book1));
    }

    @Test
    public void testCanLendBook(){
        library.addBook(book1);
        library.loanBook(book1, borrower);
        assertEquals(1,borrower.bookCount());
        assertEquals(0,library.bookCount());
        assertEquals(false, library.checkInStock(book1));
    }

    @Test
    public void updatesGenreHashMap__whenBookAdded(){
        library2.addBook(book1);
        library2.addBook(book2);
        library2.addBook(book3);

        assertEquals(2, library2.checkGenreFrequency("Sports"));
        assertEquals(1, library2.checkGenreFrequency("Sci-Fi"));
    }

}

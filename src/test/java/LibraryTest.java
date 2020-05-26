import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Book book;

    @Before
    public void before() {
        book = new Book("The Gods Themselves", "Issac Asimov", "Sci-Fi");
    }

    @Test
    public void bookHasTitle() {
        assertEquals();
    }

    @Test
    public void bookHasAuthor() {
        assertEquals();
    }

    @Test
    public void bookHasGenre() {
        assertEquals();
    }

    @Test
    public void canAddBookToLibrary() {

    }
}

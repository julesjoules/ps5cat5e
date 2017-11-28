package pkgEmpty;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import pkgException.BookException;
import pkgLibrary.Book;
import pkgLibrary.Catalog;

public class BookTest {
	@Test
	public void GetBookTest() throws BookException {
		Book b = new Book("bk101");
		assertEquals("Computer", b.getGenre());
		
	}
	
	@Test
	public void AddBookTest() throws BookException {
		Book b = new Book("bk122", "who cares", "Serena", "Fantasy", 4.95, new Date(2000,2,3), 
				"lady macbeth takes on the wild west", 3.56);
		Catalog c = b.ReadXMLFile();
		c.AddBook(b);
		assertEquals("Serena", new Book("bk120").getTitle());
	}

}

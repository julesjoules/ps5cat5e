package pkgEmpty;

import static org.junit.Assert.*;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkgException.BookException;
import pkgLibrary.Book;
import pkgLibrary.Catalog;

public class BookTest {
	private static Book b = new Book("bk122", "who cares", "Serena", "Fantasy", 4.95, new Date(2000,2,3), 
			"lady macbeth takes on the wild west", 3.56);
	@Test
	public void GetBookTest() throws BookException {
		Book b = new Book("bk101");
		assertEquals("Computer", b.getGenre());
		
	}
	
	@Test
	public void GetBookTest2() throws BookException {
		Book b = new Book("bk102");
		assertEquals("Ralls, Kim", b.getAuthor());
	}
	
	@Test
	public void AddBookTest() throws BookException{
		Catalog cat = pkgLibrary.Book.ReadXMLFile();
		cat.AddBook(new Book("bk113","author", "title","genre", 50.0, new Date(2016,4,1),
			"description", 22.10));
		Book b = new Book("bk113");
		assertEquals("description",b.getDescription());
	}
	/*@Before
	public static void SetUp() {
		RemoveBook(b);
	}
	@After
	public static void TearDown() {
		RemoveBook(b);
	}
	
	private static void RemoveBook() {
		
		
	}*/
	@Test
	public void AddBookTest1() throws BookException {
		Book b = new Book("bk122", "who cares", "Serena", "Fantasy", 4.95, new Date(2000,2,3), 
				"lady macbeth takes on the wild west", 3.56);
		Catalog c = b.ReadXMLFile();
		c.AddBook(b);
		assertEquals("Serena", new Book("bk120").getTitle());
	}

}

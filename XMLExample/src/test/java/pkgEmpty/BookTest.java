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
	private static Book b = new Book("bk122", "cares, who", "Serena", "Fantasy", 4.95, new Date(2000,2,3), 
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
		cat.AddBook(new Book("bk113","Hitler, Adolf", "Mein Kof","Biography", 50.0, new Date(1930,3,1),
			"Rise to power", 22.10));
		Book b = new Book("bk113");
		assertEquals("Rise to power",b.getDescription());
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
		for (Book b : this.getBooks()) {
			if (b.getId().equals(Book.getId())) {
				this.books.remove(Book);
			}
		}
		WriteToXMLFile(this);}
	}
		
		
	}*/
	@Test
	public void AddBookTest1() throws BookException {
		Catalog cat = pkgLibrary.Book.ReadXMLFile();
		cat.AddBook(new Book("bk122", "who cares", "Serena", "Fantasy", 4.95, new Date(2000,2,3), 
				"lady macbeth takes on the wild west", 3.56));
		Book b = new Book("bk113");
		assertEquals("Serena", new Book("bk122").getTitle());
	}

}

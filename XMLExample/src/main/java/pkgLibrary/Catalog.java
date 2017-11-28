package pkgLibrary;

import java.util.ArrayList;
import java.io.File;
import javax.xml.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import pkgException.BookException;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	

	public void AddBook(Book Book) throws BookException {
		for (Book b : this.getBooks()) {
			if (b.getId().equals(Book.getId())) {
				System.out.println("Book is Already in This Catalog");
				throw new BookException(Book);
				
			}
		}
		this.books.add(Book);
		WriteToXMLFile(this);
	}
	
	private static void WriteToXMLFile(Catalog c) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(c, file);
			jaxbMarshaller.marshal(c, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}	
	
}

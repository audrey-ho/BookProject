import java.util.*;
/**
 * A BookShelf class is a model to contain a collection of books.
 * @author audreyho
 *
 */

public class BookShelf {

	private ArrayList<Book> Books;
	
	/**
	 * constructor
	 */
	public BookShelf() {
		Books = new ArrayList<>();
	}
	
	/**
	 * Allows the user to add a specific Book x to the BookShelf Books
	 * @param x is the Book that the user wants to add
	 */
	public void add(Book x) {
		Books.add(x);
	}
	/**
	 * Allows the user to remove a specific Book x from the BookShelf Books
	 * @param x refers to the Book that the user wants to remove
	 */
	public void remove(Book x) {
		Books.remove(x);
	}
	
	/**
	 * String representation of a BookShelf
	 * @return BookShelf
	 */
	public String toString() {
		String x = "";
		for (Book a : Books) {
			x += a.toString() + "\n";
		}
		return x;
	}
	
	/**
	 * Provides an ArrayList of the current collection of books
	 * @return Books
	 */
	public ArrayList<Book> getBooks() {
		return Books;
	}
	
	/**
	 * Obtain current count of books on BookShelf
	 * @return the number of Books in the BookShelf Books
	 */
	public int getNumBooks() {
		return Books.size();
	}

}

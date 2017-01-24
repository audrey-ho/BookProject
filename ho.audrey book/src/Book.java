import java.util.*;

/**
 * A Book Class is model representing key information about books.
 * 
 * @author audreyho
 *
 */
public class Book implements Comparable<Book> {

	private String title;
	private String author;
	private long isbn;
	private float rating;
	private ArrayList<Review> reviews;

	/**
	 * constructor that creates a Book object
	 * 
	 * @param title refers to and sets the title of the Book
	 * @param author refers to and sets the author of the Book
	 * @param isbn refers to and sets the ISBN of the Book
	 */
	public Book(String title, String author, long isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.reviews = new ArrayList<Review>();
	}

	/**
	 * Obtain the author information.
	 * @return author name
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Obtain the IBSN number
	 * @return the ISBN number of the book
	 */
	public long getISBN() {
		return isbn;
	}

	/**
	 * Obtain the average rating of a book
	 * @return the average rating
	 */
	public double getAverageRating() {
		return rating;
	}

	/**
	 * String representation of a Book.
	 * @return book information
	 */
	public String toString() {
		return "ISBN : " + isbn + " Author : " + author + " Title : " + title;
	}

	/**
	 * checks if two books have the same ISBN number
	 * 
	 * @param a refers to a specific Book
	 * @return boolean value to check if ISBN numbers are the same or not
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Book) {
			Book b = (Book) obj;
			if (isbn == b.isbn) {
				return true;
			} 
		}
		return false;
	}

	/**
	 * checks if the ISBN number of a book is less than, equal to, or greater
	 * than the IBSN number of another book
	 * 
	 * @return -1 if this ISBN is less than the other, 1 if this ISBN is
	 *         greater, 0 if this ISBN is the same
	 * @param a refers to the other Book that is being compared to
	 */
	public int compareTo(Book a) {
		if (isbn < a.isbn) {
			return -1;
		} else if (isbn > a.isbn) {
			return 1;
		}
		return 0;
	}

	/**
	 * Add review to existing book.
	 * 
	 * @param r refers to the Review object
	 */
	public void addReview(Review r) {
		rating *= reviews.size();
		reviews.add(r);
		rating += r.getRating();
		rating /= reviews.size();
	}

}

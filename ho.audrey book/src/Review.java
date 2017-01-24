/**
 * A Review class is a model of a Review of a book
 * @author audreyho
 *
 */
public class Review {

	private String commenter;
	private int rating;
	private String comment;
	
	/**
	 * a constructor
	 * @param commenter: name of person creating the review
	 * @param rating: numeric value of the rating
	 * @param comment: description of a person's opinion of the book
	 */
	public Review(String commenter, int rating, String comment) {
		this.commenter = commenter;
		this.rating = rating;
		this.comment = comment;
	}
	
	/**
	 * Provides the comment of a book
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	
	/**
	 * Provides the rating of a book
	 * @return the rating of a Book
	 */
	public int getRating() {
		return rating;
	}
	
	/**
	 * Provides the commenter's name
	 * @return the commenter
	 */
	public String getCommenter() {
		return commenter;
	}
	
	/**
	 * Provides a string representation of the Review object
	 */
	public String toString() {
		return "Commenter: " + commenter + " Rating: " + rating + " Comment: " + comment;
	}
}

import java.io.*;
import java.util.*;
/**
 * @author audreyho
 *
 */

public class HoBookReviewDriver {

	public static void main(String[] args) throws FileNotFoundException {

		try {
			
			BookShelf wishlist = new BookShelf();
			BookShelf purchasedBooks = new BookShelf();
			Scanner input = new Scanner(System.in);
			
			System.out.println("Do you have a book wish list? (y/n)");
			String answer = input.nextLine();
			if (answer.equals("y")) {
				System.out.println("What is the filename of your wish list?");
				loadWishList(wishlist, input);
			} else {
				System.out.println("Add a book to your wish list.");
				addBook(input, wishlist);
			}

			while (true) {
				System.out.println(Menu());
				int command = getInt(1, 6, input);
				if (command == 1) {
					System.out.println("You have " + wishlist.getBooks().size() + " books in your wish list.");
					displayBooks(wishlist);
				} else if (command == 2) {
					addBook(input, wishlist);
				} else if (command == 3) {
					rateBook(wishlist, input);
				} else if (command == 4) {
					purchaseBook(wishlist, purchasedBooks, input);
				} else if (command == 5) {	
					displayBooks(purchasedBooks);
				} else if (command == 6) {
					return;
				}
			}
		}

		catch (Exception e) {
			System.out.println("The file was not found.");
		}

	}
	/**
	 * Loads the user's wish list from a file
	 * @param shelf refers to a BookShelf
	 * @param input refers to the user's input
	 * @throws FileNotFoundException if the file is not found
	 */
	private static void loadWishList(BookShelf shelf, Scanner input) throws FileNotFoundException {
		String fileName = input.nextLine();
		File inputFile = new File(fileName);
		Scanner inFile = new Scanner(inputFile);

		String[] data;
		String x = inFile.nextLine();
		while (inFile.hasNextLine()) {
			x = inFile.nextLine().replaceAll("\"", "");
			data = x.split(",");
			long y = Long.parseLong(data[3]);
			shelf.add(new Book(data[1], data[2], y));
		}
		inFile.close();
	}

	/**
	 * Provides a menu for the user
	 * @return the menu 
	 */
	private static String Menu() {
		String string = "";
		string += "*********MENU*********\n";
		string += "1 - Display Wish List\n";
		string += "2 - Add a book to the Wish List\n";
		string += "3 - Review a book on the Wish list\n";
		string += "4 - Purchase a book from the Wish List\n";
		string += "5 - Display purchased Books\n";
		string += "6 - Quit";
		return string;
	}

	/**
	 * Adds the user's input as a Book to a BookShelf
	 * @param input refers to the user's input
	 * @param shelf refers to a BookShelf
	 */
	private static void addBook(Scanner input, BookShelf shelf) {
		System.out.println("What is the title of the book?");
		String book = input.next();
		input.nextLine();
		System.out.println("What is the author's first and last name?");
		String name = input.nextLine();
		System.out.println("What is the ISBN number?");
		Long isbn = getLong(input);
		input.nextLine();
		shelf.add(new Book(book, name, isbn));
	}

	/**
	 * Ensures that the user returns a long data type
	 * @param input refers to the user's input
	 * @return the long input that the user put in
	 */
	private static long getLong(Scanner input) {
		while (!input.hasNextLong()) {
			System.out.println("Invalid ISBN. Please put in a long.");
			input.nextLine();
		}
		return input.nextLong();
	}

	/**
	 * Displays the books in the BookShelf
	 * @param BookShelf
	 */
	private static void displayBooks(BookShelf shelf) {
		Collections.sort(shelf.getBooks());
		int c = 1;
		for (Book a : shelf.getBooks()) {
			System.out.println(c + ": " + a);
			c++;
		}
	}

	/**
	 * Allows the user to input a rating and a review for a specific book from a BookShelf
	 * @param BookShelf
	 * @param user's input
	 */
	private static void rateBook(BookShelf shelf, Scanner input) {
		Collections.sort(shelf.getBooks());
		displayBooks(shelf);
		
		System.out.println("Choose the number of a book you would like to add a rating/review to.");
		int chosenBook = getInt(shelf, input) - 1;
		System.out.println("Give the book an integer rating out of 5.");
		int rating = getInt(1, 5, input);
		System.out.println("Please input a comment.");
		String review = input.nextLine();
		System.out.println("Please give the name of the commenter.");
		String commenter = input.nextLine();
		shelf.getBooks().get(chosenBook).addReview(new Review(commenter, rating, review));
	}

	/**
	 * Ensures that the user enters an integer 
	 * @param x is the smallest integer that the user can input
	 * @param y is the largest integer that the user can input
	 * @param user's input
	 * @return the user input
	 */
	private static int getInt(int x, int y, Scanner input) {
		while (!input.hasNextInt()) {
			System.out.println("Enter an integer please.");
			input.next();
		}
		int rt = input.nextInt();
		while (!(rt >= x && rt <= y)) {
			System.out.println("Enter an integer within the appropriate range.");
			rt = input.nextInt();
		}
		input.nextLine();
		return rt;
	}

	/**
	 * Ensures the user input is an appropriate integer for the corresponding BookShelf
	 * @param BookShelf
	 * @param user input
	 * @return the user input
	 */
	private static int getInt(BookShelf shelf, Scanner input) {
		while (!input.hasNextInt()) {
			System.out.println("Enter an integer please.");
			input.next();
		}
		int i = input.nextInt();
		while (!(i >= 1 && i <= shelf.getNumBooks())) {
			System.out.println("Invalid input. Enter an integer that corresponds to a book.");
			i = input.nextInt();
		}
		input.nextLine();
		return i;
	}

	/**
	 * Allows the user to purchase a book, which transfers the Book from one BookShelf to another
	 * @param w refers to the BookShelf that the user is purchasing a specific book from
	 * @param p refers to the BookShelf containing the book that the user just purchased
	 * @param input refers to the user input
	 */
	private static void purchaseBook(BookShelf w, BookShelf p, Scanner input){
		displayBooks(w);
		System.out.println("Enter the number of the book you would like to purchase.");
		int chosenBook = getInt(1, w.getNumBooks(), input);
		p.add(w.getBooks().get(chosenBook - 1));
		w.remove(w.getBooks().get(chosenBook - 1));
	}
}
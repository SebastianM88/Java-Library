import java.util.Scanner;

public class book {

    // Class data members
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    Scanner input = new Scanner(System.in);

    // Method used for adding the book details
    public book()  {

        // adding the serial number
        System.out.println("Enter Serial Number of Book:");
        this.sNo = input.nextInt();
        input.nextLine();

        // adding the name of the book
        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        // adding the Author Name
        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        // adding the Quantity of Books
        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}

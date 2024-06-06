import java.util.Scanner;

// Class
public class student {

    // Definition class variables
    String studentName;
    String regNum;

    book borrowedBooks[] = new book[3];
    public int booksCount = 0;

    /* Creating object of Scanner class to take input from user */
    Scanner input = new Scanner(System.in);

    // Here is the Constructor which will contain the student data
    public student()  {

        System.out.println("Enter Student Name:");

        // Code for choosing the name of the student
        this.studentName = input.nextLine();

        // Code for choosing the Registration Number of the student
        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}

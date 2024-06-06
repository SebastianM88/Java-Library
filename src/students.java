import java.util.Scanner;

// Class
public class students {

    // Creating objects of Scanner and students class which will be an Array type with a limit of 30 people
    Scanner input = new Scanner(System.in);
    student theStudents[] = new student[30];

    public static int count = 0;

    // Method 1, for adding students
    public void addStudent(student s)  {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {

                // Print statement
                System.out.println(
                        "Student of Reg Num " + s.regNum
                                + " is Already Registered.");

                return;
            }
        }

        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }

    // Method 2, for Displaying all students
    public void showAllStudents()  {
        // The code used for printing the student name and his register number
        System.out.println("Student Name \t\t Register Number");
        for (int i = 0; i < count; i++) {

            System.out.println(theStudents[i].studentName
                    + "\t\t\t\t\t"
                    + theStudents[i].regNum);
        }
    }

    // Method 3, for checking if a student is registered of not
    public int isStudent()  {

        System.out.println("Enter Reg Number:");
        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (theStudents[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }

        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    // Method 4,This method is used to allow a student to borrow a book.
    public void checkOutBook(books book)  {
        // // Check if the student is registered
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");

            book.showAllBooks();

            /* Try to borrow a book, and if the book is available
            the method will make the book borrowable as well
             */
            book b = book.checkOutBook();

            /* Code that will add the borrowed book to the list of
            borrowed books of the student, however if the book is
            no longer available will run a message of availability and will
            announce the maximum limit of borrowed books*/
            System.out.println("checking out");
            if (b != null) {

                if (theStudents[studentIndex].booksCount <= 3) {

                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks
                            [theStudents[studentIndex].booksCount] = b;
                    theStudents[studentIndex].booksCount++;

                    return;
                }
                else {

                    System.out.println(
                            "Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    // Method 5, it presents the code for returning borrowed books
    public void checkInBook(books book)  {

        int studentIndex = this.isStudent();

        if (studentIndex != -1) {

            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");

            student s = theStudents[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {

                System.out.println(
                        s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }

            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");

            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo
                    + "not Found");
        }
    }
}

import java.util.Scanner;

public class books {

    // Class data members which will be an Array type with a limit of 200 books
    book theBooks[] = new book[200];
    public static int count;

    Scanner input = new Scanner(System.in);

    // Method 1, is for displaying us the menu
    public void dispMenu()  {

        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out a Book. ");
        System.out.println("Press 8 to Check In a Book");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    // Method 2, used to compare books
    public int compareBookObjects(book b1, book b2)  {

        // If book name matches
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {

            // Printing book exists
            System.out.println(
                    "Book of this Name Already Exists.");
            return 0;
        }

        // if book serial matches
        if (b1.sNo == b2.sNo) {

            // Print book exists
            System.out.println(
                    "Book of this Serial No Already Exists.");

            return 0;
        }
        return 1;
    }

    // Method 3, used to add a book in the library
    public void addBook(book b)  {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i])
                    == 0)
                return;
        }

        if (count < 50) {

            theBooks[count] = b;
            count++;
        }
        else {

            System.out.println(
                    "No Space to Add More Books.");
        }
    }

    // Method 4, used to search by a serial number of a book
    public void searchBySno()  {

        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        // Class data members
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        // The code meant to show us if the serial number is valid all the data of book
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(
                        theBooks[i].sNo + "\t\t"
                                + theBooks[i].bookName + "\t\t"
                                + theBooks[i].authorName + "\t\t"
                                + theBooks[i].bookQtyCopy + "\t\t"
                                + theBooks[i].bookQty);
                flag++;
                return;
            }
        }

        // And if the serial number of the book is not valid to give us a message
        if (flag == 0)
            System.out.println("There is no Book found for the serial number "
                    + sNo);
    }

    // Method 5, is used for searching after the author name
    public void searchByAuthorName()  {

        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY AUTHOR'S NAME");

        input.nextLine();

        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        int flag = 0;

        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            // if author matches any of its book
            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {

                // Print below corresponding credentials
                System.out.println(
                        theBooks[i].sNo + "\t\t"
                                + theBooks[i].bookName + "\t\t"
                                + theBooks[i].authorName + "\t\t"
                                + theBooks[i].bookQtyCopy + "\t\t"
                                + theBooks[i].bookQty);
                flag++;
            }
        }

        // Else no book matches for this name of author
        if (flag == 0)
            System.out.println("No Books of " + authorName
                    + " has been found.");
    }

    // Method 6, used for displaying all books
    public void showAllBooks()  {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    theBooks[i].sNo + "\t\t"
                            + theBooks[i].bookName + "\t\t\t\t"
                            + theBooks[i].authorName + "\t\t\t\t"
                            + theBooks[i].bookQtyCopy + "\t\t\t\t\t"
                            + theBooks[i].bookQty);
        }
    }

    // Method 7, aims to update the number of books already existing in the library
    public void upgradeBookQty()  {

        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                // Display message
                System.out.println(
                        "Enter No of Books to be Added:");

                // Code used to be able to add our new book to the total of existing ones
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    // Method 8, which are for the purpose of searching for us in the library if the requested book still exists
    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {

                    System.out.println(
                            "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number is present in the library");
        return -1;
    }

    // Method 9, meant to make it possible to borrow a book from the library
    public book checkOutBook()  {

        System.out.println("Enter Serial No of Book to be Checked Out.");

        int sNo = input.nextInt();

        // Code to check if the book still exists
        int bookIndex = isAvailable(sNo);

        // the code that aims to eliminate the number of books borrowed from their total quantity
        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    // Method 10, which are intended to carry out the return of borrowed books
    public void checkInBook(book b)
    {
        for (int i = 0; i < count; i++) {

            if (b.equals(theBooks[i])) {

                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}
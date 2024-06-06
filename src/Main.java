import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        // Creating object of Scanner class to take input from user
        Scanner input = new Scanner(System.in);

        // Displaying menu
        System.out.println(
                "\n--------------- Welcome to the SLD Library! -----------------\n");
        System.out.println(
                "             Select From The Following Options:                  ");
        System.out.println(
                "\n*-------------------------------------------------------------\n");

        // Creating the object of book and students of class
        books ob = new books();
        students obStudent = new students();

        int choice;
        int searchChoice;

        // Creating manu functionalities
        do {

            ob.dispMenu();
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    book b = new book();
                    ob.addBook(b);
                    break;

                case 2:
                    ob.upgradeBookQty();
                    break;

                case 3:

                    System.out.println(
                            " press 1 to Search with Book Serial No.");
                    System.out.println(
                            " Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();

                    // This is Nested switch
                    switch (searchChoice) {

                        // Case
                        case 1:
                            ob.searchBySno();
                            break;

                        // Case
                        case 2:
                            ob.searchByAuthorName();
                    }
                    break;

                case 4:
                    ob.showAllBooks();
                    break;

                case 5:
                    student s = new student();
                    obStudent.addStudent(s);
                    break;

                case 6:
                    obStudent.showAllStudents();
                    break;


                case 7:
                    obStudent.checkOutBook(ob);
                    break;


                case 8:
                    obStudent.checkInBook(ob);
                    break;

                // Default case that will run if the number accessed will be greater than 8
                default:

                    // Print statement
                    System.out.println("ENTER BETWEEN 0 TO 8.");
            }

        }

        // Checking condition at last where we are
        // checking case entered value is not zero
        while (choice != 0);
    }
}
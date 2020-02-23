 /***********************************************************
 * Programming Project 1 - Inheritance - Faculty  Class     *
 * -------------------------------------------------------- *
 * A Staff member is a specific type of Employee.           *
 * -------------------------------------------------------- *
 * Roy Chung                                                *
 * 20200124                                                 *
 * CMSC 256 Section 902                                     *
 ***********************************************************/

package cmsc256;

public class Staff extends Employee {
    //instance variable
    private String title;

    //default constructor
    public Staff() {
        super();
        title = "None given";
    }

    //parameterized constructor
    public Staff(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office, int salary, int month, int day, int year, String title) {
        // everything except for title is an attribute of Employee, it is therefore passed to the superclass constructor
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
        this.title = title;
    }

    public String toString() {
        return super.toString() + "\nTitle: " + title;
    }
}

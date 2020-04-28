 /***********************************************************
 * Programming Project 1 - Inheritance - Faculty  Class     *
 * -------------------------------------------------------- *
 * A Faculty member is a specific type of Employee.         *
 * -------------------------------------------------------- *
 * Roy Chung                                                *
 * 20200124                                                 *
 * CMSC 256 Section 902                                     *
 ***********************************************************/

package cmsc256.project01;

public class Faculty extends Employee {
    //instance variable
    private String rank;

    //default constructor
    public Faculty() {
        super();
        rank = "Instructor";
    }

    //parameterized constructor
    public Faculty(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office, int salary, int month, int day, int year, String rank) {
        // everything except for rank is an attribute of Employee, it is therefore passed to the superclass constructor
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);

        //throw error if rank is invalid
        if (isValidRank(rank)) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException("Invalid level. Valid entries are: Adjunct, Instructor, Assistant Professor, Associate Professor, and Professor.");
        }
    }

    private boolean isValidRank (String rank) {
        if (rank.equals("Adjunct") || rank.equals("Instructor") || rank.equals("Assistant Professor") || rank.equals("Associate Professor") || rank.equals("Professor")) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString() + "\nRank: " + rank;
    }
}

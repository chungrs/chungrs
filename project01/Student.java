 /***********************************************************
 * Programming Project 1 - Inheritance - Student Class      *
 * -------------------------------------------------------- *
 * A student is a specific type of Person.                  *
 * -------------------------------------------------------- *
 * Roy Chung                                                *
 * 20200124                                                 *
 * CMSC 256 Section 902                                     *
 ***********************************************************/

package cmsc256.project01;

public class Student extends Person {
    //instance variable
    private String level;

    //default constructor
    public Student() {
        super(); //uses default constructor of superclass
        level = "Freshman";
    }

    //parameterized constructor
    public Student (String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String level) {
        super(first, middle, last, homeAddress, phoneNumber, email);

        //throw error if level is not valid.
        if (isValidLevel(level)) {
            this.level = level;
        } else {
            throw new IllegalArgumentException("Invalid level. Valid entries are: Freshman, Sophomore, Junior, Senior, and Graduate.");
        }
    }

    //method used for checking whether or not level is valid.
    private boolean isValidLevel (String level) {
        if (level.equals("Freshman") || level.equals("Sophomore") || level.equals("Junior") || level.equals("Senior") || level.equals("Graduate")) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString() + "\nStudent Level: " + level;
    }
}

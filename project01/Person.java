 /***********************************************************
 * Programming Project 1 - Inheritance - Person Class       *
 * -------------------------------------------------------- *
 * Person class contains all of the common and most basic   *
 * information of all students, staff, and faculty.         *
 * -------------------------------------------------------- *
 * Roy Chung                                                *
 * 20200124                                                 *
 * CMSC 256 Section 902                                     *
 ***********************************************************/

package cmsc256;

public class Person {
    //instance variables
    private Name name;
    private String phoneNumber, email;
    private Address homeAddress;
    private int id;
    static int RecordNumber = 0;

    //default constructor
    public Person() {
        this.name = new Name();
        this.homeAddress = new Address();
        this.phoneNumber = "None given";
        this.email = "None given";

        //increment RecordNumber each time it is assigned to an ID number.
        RecordNumber++;
        this.id = RecordNumber;
    }

    //parameterized constructor
    public Person(String first, String middle, String last, Address homeAddress, String phoneNumber, String email) {
        this.name = new Name(first, middle, last);
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;

        RecordNumber++;
        this.id = RecordNumber;
    }

    //name getter
    public String getName() {
        return name.toString();
    }

    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                "---------------------------------------\n" +
                name.toString() + "\n" +
                "---------------------------------------\n" +
                "Home Address: " + homeAddress.toString() + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email Address: " + email + "\n" +
                "ID: " + id;
    }
}

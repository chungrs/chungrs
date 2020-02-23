 /***********************************************************
 * Programming Project 1 - Inheritance - Employee Class     *
 * -------------------------------------------------------- *
 * Employees are a subclass of Person, with two subclasses  *
 * of its own, namely Staff and Faculty.                    *
 * -------------------------------------------------------- *
 * Roy Chung                                                *
 * 20200124                                                 *
 * CMSC 256 Section 902                                     *
 ***********************************************************/

package cmsc256;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {
    //instance variables
    private String office;
    private int salary;
    private LocalDate hireDate;

    //default constructor
    public Employee() {
        super();
        office = "Unassigned";
        salary = 0;
        hireDate = null;
    }

    //parameterized constructor
    public Employee(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office, int salary, int month, int day, int year) {
        super(first, middle, last, homeAddress, phoneNumber, email);
        this.office = office;

        //Check for negative salary
        if (salary >= 0) {
            this.salary = salary;
        } else{
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        hireDate = LocalDate.of(year, month, day);
    }

    public String toString() {
        //date variable used for formatted date.
        String date;

        //Display "Not applicable" if hireDate is null. Otherwise, return formatted.
        try {
            date = hireDate.format(DateTimeFormatter.ofPattern("M/d/YYYY"));
        } catch(NullPointerException e) {
            date = "Not applicable";
        }

        return super.toString() +
                "\nOffice: " + office +
                "\nSalary: $" + salary +
                "\nDate Hired: " + date;
    }
}

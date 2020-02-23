package cmsc256;

/**
 * A class that represents a Name consisting of a first, optional middle, 
 * and last name.
 * 
 * @author as0238 modified 1/2020 by Debra Duke 
 * @version 2.0
 */
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
   
    
    /**
	 * Sets default values for the object. 
	 *  Default values for first name and last name are "Not provided".
	 *  Default value for middle name is null;
	 */
	public Name() {
		this("Not provided", null, "Not provided");
	}

	/**
     * Sets up this Name object with the specified data.
     * 
     * @param firstName		the first name	
     * @param middleName	the middle name
     * @param lastName		the last name
     */
    public Name (String firstName, String middleName, String lastName)
    {
        this.firstName =firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    
    /**
     * Sets up this Name object with the specified data and sets middle name
     * to an empty string
     * 
     * @param firstName		the first name
     * @param lastName		the last name
     */
    public Name (String firstName, String lastName)
    {
        this(firstName, null, lastName);
    }
        
    /**
     *	Returns the components of the Name as a formatted String
     */
    public String toString()
    { if (this.middleName == null || this.middleName.length() == 0)
       return this.firstName + " " + this.lastName;
    else
       return this.firstName + " " + this.middleName + " " + this.lastName;
    }
    
}

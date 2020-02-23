package cmsc256;


/**
 *  A class that represents a street address and provides
 *  a formatted string representation of the instance variables.
 *
 * @author as0238 modified 1/2020 by Debra Duke to add validation
 * @version 2.0
 */
public class Address {

	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
	

	/**
	 *  Sets default values for the object. 
	 *  Default values for street address and city are "None given".
	 *  Default state is VA and default zipcode is 00000.
	 */
	public Address() {
		streetAddress = "None given";
		city = "None given";
		state = "VA";
		zipCode = "00000";
	}

	/**
	 *  Sets up this Address object with the specified data.
	 *
	 *  The class does not allow null parameters and the zipCode must be a positive,
	 *  five-digit number
	 *  @param	streetAddress	the number and street, cannot be null
	 *  @param	city			the city, cannot be null
	 *  @param	state			the 2-letter state abbreviation
	 *  @param	zipCode			standard 5-digit or zip + 4 format
	 */
	public Address (String streetAddress, String city, String state, String zipCode)
	{
		if(streetAddress == null)
			throw new IllegalArgumentException("The streetAddress cannot be null.");
		if(city == null)
			throw new IllegalArgumentException("The city cannot be null.");
		if(!isValidState(state))
			throw new IllegalArgumentException("The state abbreviation is incorrect.");
		isValidZipCode(zipCode);
		
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	//-----------------------------------------------------------------
	//  Validates state abbreviation.
	//-----------------------------------------------------------------
	private boolean isValidState(String stateVar)
	{
		if(stateVar.length() != 2)
			throw new IllegalArgumentException("The address should use the 2-letter state abbreviation.");

		String[] stateList = {"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL",
				"GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA",
				"MA", "MD","ME",  "MH", "MI", "MN", "MO", "MS", "MT", "NC",
				"ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR",
				"PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA",
				"VI", "VT", "WA", "WI", "WV", "WY"
		};

		for(int i = 0; i < stateList.length; i++)
			if(stateList[i].equals(stateVar))
				return true;

		return false;
	}


	//-----------------------------------------------------------------
	//  Validates that the zipcode is either 5 digits or is
	//   10 characters in length usign the zip + 4 format.
	//-----------------------------------------------------------------
	private boolean isValidZipCode(String zip)
	{
		boolean isValid = true;
		int zipLength = zip.length();

		if(!(zipLength == 5 || zipLength == 10))
			throw new IllegalArgumentException("The zip code is not formatted correctly.");

		if(zipLength == 5){      // Short zip code should be all digits
			for(int i = 0; i < zip.length(); i++) {
				Character ch = zip.charAt(i);
				if(!Character.isDigit(ch))
					isValid = false;
			}
			
			if(!isValid)
				throw new IllegalArgumentException("The 5-digit zip code is incorrect.");
		}

		if(zipLength == 10)
			for(int i = 0; i < zipLength; i++){
				char ch = zip.charAt(i);

				if(i == 5 && ch != '-')  			// sixth character must be a dash
					isValid = false;
				if(i != 5 && !Character.isDigit(ch))		// all other characters must be digits
					isValid = false;
			}

		if(!isValid)
			throw new IllegalArgumentException("The 10-digit zip code is incorrect.");

		return isValid;
	}


	/**
	 *	Returns this Address object as a string.
	 */
	public String toString()
	{
		String result;

		result = streetAddress + "\n";
		result += city + ", " + state + "  " + zipCode;

		return result;
	}
}

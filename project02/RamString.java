 /***********************************************************
 * Programming Project 2 - Inheritance - Employee Class     *
 * -------------------------------------------------------- *
 * Roy Chung                                                *
 * 20200207                                                *
 * CMSC 256 Section 902                                     *
 ***********************************************************/

package cmsc256.project02;

public class RamString implements WackyStringInterface {
    private String wackyString;

    //Default constructor sets wackyString to "Rodney, the Ram"
    public RamString() {
        setWackyString("Rodney, the Ram");
    }

    //Parameterized constructor
    public RamString(String wackyString) {
        setWackyString(wackyString);
    }

    //Sets wacky string
    public void setWackyString(String wackyString) {
        if (wackyString == null) {
            throw new IllegalArgumentException("String cannot be null.");
        }
        this.wackyString = wackyString;
    }

    //wacky string getter
    public String getWackyString() {
        return wackyString;
    }

    public String getEveryThirdCharacter() {
        String originalString = getWackyString();
        String newString = "";

        //If the string length is less than three, then there will not be a third character. Begin for loop at 3rd character of string, increase i by 3 after every loop, and add each character at index i to new string
        if (originalString.length() >= 3) {
            for (int i = 2; i < originalString.length(); i += 3) {
                newString += originalString.charAt(i);
            }
        }

        return newString;
    }

    public String getEvenOrOddCharacters(String evenOrOdd) {
        String originalString = getWackyString();
        String newString = "";

        //If user enters "even," get every other character starting at the second character. If user enters "odd," do the same but start at the first character
        if (evenOrOdd.equalsIgnoreCase("even")) {
            for (int i = 1; i < originalString.length(); i += 2) {
                newString += originalString.charAt(i);
            }
        } else if ((evenOrOdd.equalsIgnoreCase("odd"))) {
            for (int i = 0; i < originalString.length(); i += 2) {
                newString += originalString.charAt(i);
            }
        } else { //if the user enters anything other than "even" or "odd," the program will throw an error
            throw new IllegalArgumentException("Invalid input. Please enter \"even\" or \"odd.\"");
        }

        return newString;
    }

    public int countDoubleDigits() {
        int count = 0;

        String str = getWackyString();

        //if string length is less than two, there cannot be a double digit
        if (str.length() == 2) {
            if (Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(1))) {
                count++;
            }
        }

        //if string length is greater than two, perform these tasks
        if (str.length() > 2) {
            //If the first and second characters are digits but the third is not, increment count
            if (Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(1)) && !Character.isDigit(str.charAt(2))) {
                count++;
            }
            //starting from the third character, test and see if the character at index i is a digit. If it is, test to see if the character before is also a digit. If it is and the character at i-2 is NOT a digit, and if the character at i+1 is also not a digit, then we have a double digit.
            for (int i = 2; i < str.length() - 1; i++) {
                if (!Character.isDigit(str.charAt(i - 2)) && Character.isDigit(str.charAt(i - 1)) && Character.isDigit(str.charAt(i)) && !Character.isDigit(str.charAt(i + 1))) {
                    count++;
                }
            }

            //Test the last two characters in the string
            if (!Character.isDigit(str.charAt(str.length() - 3)) && Character.isDigit(str.charAt(str.length() - 2)) && Character.isDigit(str.charAt(str.length() - 1))) {
                count++;
            }
        }

        return count;
    }

    public boolean isValidVCUEmail() {
        String email = getWackyString();
        String prefix = "";
        String suffix = "";

        //String is a valid email address unless an invalid condition is detected
        boolean isValid = true;

        //If the string contains no @ or more than one @ then it cannot be a valid email address. If valid, split it into prefix and suffix
        if (email.contains("@") && (email.indexOf("@") == email.lastIndexOf("@"))) {
            prefix += email.substring(0, email.indexOf("@"));
            suffix += email.substring(email.indexOf("@") + 1);
        } else {
            isValid = false;
        }

        //a valid email address cannot have two dots in a row
        if (prefix.contains("..")) {
            isValid = false;
        }
        //email prefix cannot be empty
        if (prefix.equals("")) {
            isValid = false;
        } else { //if the first or final character of the prefix is a dot then the email address is invalid
            if (prefix.charAt(0) == '.' || prefix.charAt(prefix.length() - 1) == '.') {
                isValid = false;
            }
        }

        //any suffix that is not vcu.edu or mymail.vcu.edu is rejected
        if (!suffix.equalsIgnoreCase("vcu.edu") && !suffix.equalsIgnoreCase("mymail.vcu.edu")) {
            isValid = false;
        }

        return isValid;
    }

    public void ramifyString() {
        String str = getWackyString();

        //if string length is 1 and the string is "0," change it to GoRams
        if (str.length() == 1 && str.charAt(0) == '0') {
            str = "GoRams";
        }

        //Test if first character of string is a 0 followed by a non-zero
        if (str.length() > 1){
            if (str.charAt(0) == '0' && str.charAt(1) != '0') {
                str = "GoRams" + str.substring(1);
            }
        }

        //if string length is greater than two, perform these tasks
        if (str.length() > 2) {
            //If the first and second characters are zeros but the third is not, replace the first two characters with CS@VCU
            if (str.charAt(0) == '0' && str.charAt(1) == '0' && str.charAt(2) != '0') {
                str = "CS@VCU" + str.substring(2);
            }
            //starting from the third character, test and see if the character at index i is a 0. If it is, test to see if the character before is also a 0. If it is and the character at i-2 is NOT a 0, and if the character at i+1 is also not a 0, then we have a set of double zeros that need to be replaced.
            for (int i = 2; i < str.length() - 1; i++) {
                if (str.charAt(i - 2) != '0' && str.charAt(i - 1) == '0' && str.charAt(i) == '0' && str.charAt(i + 1) != '0') {
                    str = str.substring(0, i - 1) + "CS@VCU" + str.substring(i + 1);
                }
            }

            //Test the last two characters in the string
            if (str.charAt(str.length() - 3) != '0' && str.charAt(str.length() - 2) == '0' && str.charAt(str.length() - 1) == '0') {
                str = str.substring(0, str.length() - 2) + "CS@VCU";
            }

            //similar to the for loop above but for one zero.
            for (int i = 1; i < str.length() - 1; i++) {
                if (str.charAt(i - 1) != '0' && str.charAt(i) == '0' && str.charAt(i + 1) != '0') {
                    str = str.substring(0, i) + "GoRams" + str.substring(i + 1);
                }
            }
        }

        //test final character in string for single 0.
        if (str.length() > 1) {
            if (str.charAt(str.length() - 2) != '0' && str.charAt(str.length() - 1) == '0') {
                str = str.substring(0, str.length() - 1) + "GoRams";
            }
        }

        setWackyString(str);
    }

    public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition) {
        String originalString = getWackyString();
        String newString = "";
        if (startPosition < 1 || startPosition > originalString.length() || endPosition < 1 || endPosition > originalString.length()) {
            throw new MyIndexOutOfBoundsException("Start and/or end position out of bounds.");
        }

        if (startPosition > endPosition) {
            throw new IllegalArgumentException("Start position cannot be smaller than end position.");
        }

        //Create character array from string
        char[] array = new char[originalString.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = originalString.charAt(i);
        }

        //New string is substring from the beginning of the string until startPosition
        newString += originalString.substring(0, startPosition - 1);

        //if character in array is a numeral from 1 to 9, add Roman numeral equivalent to newString
        for (int i = startPosition - 1; i < endPosition; i++){
            if (array[i] == '1') {
                newString += "I";
            } else if (array[i] == '2') {
                newString += "II";
            } else if (array[i] == '3') {
                newString += "III";
            } else if (array[i] == '4') {
                newString += "IV";
            } else if (array[i] == '5') {
                newString += "V";
            } else if (array[i] == '6') {
                newString += "VI";
            } else if (array[i] == '7') {
                newString += "VII";
            } else if (array[i] == '8') {
                newString += "VIII";
            } else if (array[i] == '9') {
                newString += "IX";
            } else {
                newString += array[i];
            }
        }

        //Fill remainder of newString with portion of original string after end position, if any.
        newString += originalString.substring(endPosition);

        setWackyString(newString);
    }
}
package cmsc256;

public class RamMain {
    public static void main(String[] args){
        RamString esketit = new RamString("aaaaaaaaaaaaaaaa");

        System.out.println(esketit.countDoubleDigits());
        System.out.println(esketit.getEvenOrOddCharacters("even"));

        RamString email = new RamString("chungrs@vcu.edu");
        System.out.println(email.getWackyString() + "\n" + email.isValidVCUEmail());

        RamString numbaz = new RamString("678099908212");
        System.out.println(numbaz.getWackyString());
        numbaz.convertDigitsToRomanNumeralsInSubstring(5, 12);
        System.out.println(numbaz.getWackyString());

        RamString ramify = new RamString("000 00 0 00 000");
        System.out.println(ramify.getWackyString());
        ramify.ramifyString();
        System.out.println(ramify.getWackyString());

        RamString nullTest = new RamString(null);
    }
}

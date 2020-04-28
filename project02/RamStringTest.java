package cmsc256.project02;
////
//// this is a collection of tests written by you and your
//// peers that you can use to test your code for project 2.
//// the results of these tests do not ensure your grade
//// and none of the tests written by Professor Duke that 
//// will be used to grade your project are included
////

import static org.junit.Assert.*;

import cmsc256.project02.MyIndexOutOfBoundsException;
import cmsc256.project02.RamString;
import org.junit.Test;

public class RamStringTest {
/*********************************************************
 * tests for getEveryThirdCharacter()
 *********************************************************/

	@Test
	public void testGetEveryThirdCharacter1() {
		RamString rams1 = new RamString("ABCDE");
		String result = rams1.getEveryThirdCharacter();
		assertEquals("C", result);
	}
	@Test
	public void testGetEveryThirdCharacter2() {
		RamString rams1 = new RamString();
		String result = rams1.getEveryThirdCharacter();
		assertEquals("dyt m", result);
	}
	@Test
	public void testGetEveryThirdCharacter3() {
		RamString rams1 = new RamString("Believe it team 7");
		String result = rams1.getEveryThirdCharacter();
		assertEquals("lvitm", result);
	}
	@Test
	public void testGetEveryThirdCharacter4() {
		RamString rams1 = new RamString("123456");
		String result = rams1.getEveryThirdCharacter();
		assertEquals("36", result);
	}
	@Test
	public void testGetEveryThirdCharacter5() {
		RamString rams1 = new RamString("   ");
		String result = rams1.getEveryThirdCharacter();
		assertEquals(" ", result);
	}

	@Test
	public void testGetEveryThirdCharacter6() {
		RamString s = new RamString("Test");
		String everyThird = s.getEveryThirdCharacter();
		assertTrue("s".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter7() {
		RamString s = new RamString("abcdefghi");
		String everyThird = s.getEveryThirdCharacter();
		assertTrue("cfi".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter8() {
		RamString s = new RamString("a r e d b u c k e t");
		String everyThird = s.getEveryThirdCharacter();
		assertTrue("r b k ".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter9() {
		RamString s = new RamString("");
		String everyThird = s.getEveryThirdCharacter();
		assertTrue("".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter10() {
		RamString text = new RamString("Dillon Forte");
		String everyThird = text.getEveryThirdCharacter();
		assertTrue("lnoe".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter11() {
		RamString text = new RamString("AABAABAABAAB");
		String everyThird = text.getEveryThirdCharacter();
		assertTrue("BBBB".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter12() {
		RamString defaultString = new RamString("SF");
		String everyThird = defaultString.getEveryThirdCharacter();
		assertTrue("".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter13() {
		RamString defaultString = new RamString("February 04, 2020");
		String everyThird = defaultString.getEveryThirdCharacter();
		assertTrue("ba ,0".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter14() {
		RamString defaultString = new RamString("heLlo wOrld");
		String everyThird = defaultString.getEveryThirdCharacter();
		assertTrue("L r".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter15() {
		RamString everyThird = new RamString("Cupcake");
		String result = everyThird.getEveryThirdCharacter();
		assertTrue("pk".equals(result));
	}

	@Test
	public void testGetEveryThirdCharacter16() {
		RamString everyThird = new RamString("a");
		String result = everyThird.getEveryThirdCharacter();
		assertTrue("".equals(result));
	}

	@Test
	public void testGetEveryThirdCharacter17() {
		RamString hiString = new RamString("Hi");
		String everyThird = hiString.getEveryThirdCharacter();
		assertTrue("".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter18() {
		RamString alphaNumericString = new RamString("Hello world123");
		String everyThird = alphaNumericString.getEveryThirdCharacter();

		assertTrue("l r1".equals(everyThird));
	}

	@Test
	public void testGetEveryThirdCharacter19(){
		RamString s = new RamString("111");
		String stringWithNumbers = s.getEveryThirdCharacter();
		assertTrue("1".equals(stringWithNumbers));
	}

	@Test
	public void testGetEveryThirdCharacter20(){
		RamString s = new RamString("HOW ARE YOU");
		String inCaps = s.getEveryThirdCharacter();
		assertTrue("WRY".equals(inCaps));
	}


/*********************************************************
 * tests for getEvenOrOddCharacters(String evenOrOdd)
 *********************************************************/


	@Test
	public void testGetEvenOrOddCharacters1() {
		RamString rams1 = new RamString("Believe it team 7");
		String result = rams1.getEvenOrOddCharacters("even");
		assertEquals("eiv tta ", result);
	}
	
	@Test
	public void testGetEvenOrOddCharacters2() {
		RamString rams1 = new RamString();
		String result = rams1.getEvenOrOddCharacters("odd");
		assertEquals("Rde,teRm", result);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetEvenOrOddCharacters3() {
		RamString rams1 = new RamString("What it do");
		String result = rams1.getEvenOrOddCharacters("boop");
		assertEquals("Wa td", result);
	}
	
	@Test
	public void testGetEvenOrOddCharacters4() {
		RamString rams1 = new RamString("What's up");
		String result = rams1.getEvenOrOddCharacters("even");
		assertEquals("htsu", result);
	}
	
	@Test
	public void testGetEvenOrOddCharacters5() {
		RamString rams1 = new RamString("Got that");
		String result = rams1.getEvenOrOddCharacters("odd");
		assertEquals("Gtta", result);
	}

	@Test
	public void testGetEvenOrOddCharacters6() {
		String evenOrOdd = "even";
		RamString defaultString = new RamString();
		String evenOdd = defaultString.getEvenOrOddCharacters(evenOrOdd);
		assertTrue("ony h a".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters7() {
		String evenOrOdd = "odd";
		RamString defaultString = new RamString();
		String evenOdd = defaultString.getEvenOrOddCharacters(evenOrOdd);
		assertTrue("Rde,teRm".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters8() {
		String evenOrOdd = "even";
		RamString s = new RamString("Test");
		String evenOdd = s.getEvenOrOddCharacters(evenOrOdd);
		assertTrue("et".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters9() {
		String evenOrOdd = "odd";
		RamString defaultString = new RamString("Test");
		String evenOdd = defaultString.getEvenOrOddCharacters(evenOrOdd);
		assertTrue("Ts".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters10() {
		String evenOrOdd = "even";
		RamString defaultString = new RamString();
		String evenOdd = defaultString.getEvenOrOddCharacters(evenOrOdd);
		assertTrue("ony h a".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters11() {
		RamString text = new RamString("even");
		String evenOdd = text.getEvenOrOddCharacters("even");
		assertTrue("vn".equals(evenOdd));
	}
	
	@Test
	public void testGetEvenOrOddCharacters12() {
		RamString text = new RamString("odd");
		String evenOdd = text.getEvenOrOddCharacters("odd");
		assertTrue("od".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters13() {
		RamString text = new RamString("even");
		String evenOdd = text.getEvenOrOddCharacters("odd");
		assertTrue("ee".equals(evenOdd));
	}
	
	@Test
	public void testGetEvenOrOddCharacters14() {
		RamString text = new RamString("Dillon");
		String evenOdd = text.getEvenOrOddCharacters("odd");
		assertTrue("Dlo".equals(evenOdd));
	}
	
	@Test
	public void testGetEvenOrOddCharacters15() {
		RamString defaultString = new RamString();
		String evenOdd = defaultString.getEvenOrOddCharacters("even");
		assertTrue("ony h a".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters16() {
		RamString defaultString = new RamString();
		String evenOdd = defaultString.getEvenOrOddCharacters("odd");
		assertTrue("Rde,teRm".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters17() {
		RamString defaultString = new RamString("S");
		String evenOdd = defaultString.getEvenOrOddCharacters("even");
		assertTrue("".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters18() {
		RamString defaultString = new RamString("S");
		String evenOdd = defaultString.getEvenOrOddCharacters("odd");
		assertTrue("S".equals(evenOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters19(){
		RamString s = new RamString("Hello");
		String testEven = s.getEvenOrOddCharacters("even");
		assertTrue("el".equals(testEven));
	}

	@Test
	public void testGetEvenOrOddCharacters20(){
		RamString s = new RamString("Hello");
		String testOdd = s.getEvenOrOddCharacters("odd");
		assertTrue("Hlo".equals(testOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters21(){
		RamString s = new RamString("SARA DEMPSEY");
		String testCaseEven = s.getEvenOrOddCharacters("even");
		assertTrue("AADMSY".equals(testCaseEven));
	}

	@Test
	public void testGetEvenOrOddCharacters22() {
		RamString test = new RamString("N");
		test.getEvenOrOddCharacters("odd");
		assertTrue("N".equals(test.getWackyString()));
	}

	@Test
	public void testGetEvenOrOddCharacters23() {
		RamString evenOdd = new RamString("pope");
		String result = evenOdd.getEvenOrOddCharacters("even");
		assertEquals("oe", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetEvenOrOddCharacters24() {
		RamString evenOdd = new RamString("b");
		String result = evenOdd.getEvenOrOddCharacters("cat");
	}

	@Test
	public void testGetEvenOrOddCharacters25() {
		RamString oddString = new RamString("Hello world");
		String evenOrOdd = oddString.getEvenOrOddCharacters("odd");
		assertTrue("Hlowrd".equals(evenOrOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters26() {
		RamString evenString = new RamString("Hello world");
		String evenOrOdd = evenString.getEvenOrOddCharacters("even");
		assertTrue("el ol".equals(evenOrOdd));
	}

	@Test
	public void testGetEvenOrOddCharacters27() {
		RamString emptyString = new RamString("");
		String evenOrOdd = emptyString.getEvenOrOddCharacters("even");
		assertTrue("".equals(evenOrOdd));
	}

/*********************************************************
 * tests for countDoubleDidgits()
 *********************************************************/


	@Test
	public void testCountDoubleDidgits1() {
		RamString rams1 = new RamString("12 abc 2");
		int result = rams1.countDoubleDigits();
		assertEquals(1, result);
	}

	@Test
	public void testCountDoubleDidgits3() {
		RamString rams1 = new RamString("90 879 7632 374 84");
		int result = rams1.countDoubleDigits();
		assertEquals(2, result);
	}
	@Test
	public void testCountDoubleDidgits4() {
		RamString rams1 = new RamString(".00");
		int result = rams1.countDoubleDigits();
		assertEquals(1, result);
	}
	@Test
	public void testCountDoubleDidgits5() {
		RamString rams1 = new RamString("3890871249834");
		int result = rams1.countDoubleDigits();
		assertEquals(0, result);
	}

	@Test
	public void testCountDoubleDidgits6() {
		RamString defaultString = new RamString();
		int count = defaultString.countDoubleDigits();
		assertTrue(count == 0);
	}

	@Test
	public void testCountDoubleDidgits7() {
		RamString s = new RamString("H00 C01");
		int count = s.countDoubleDigits();
		assertTrue(count == 2);
	}

	@Test
	public void testCountDoubleDidgits8() {
		RamString s = new RamString("1111111");
		int count = s.countDoubleDigits();
		assertTrue(count == 0);
	}

	@Test
	public void testCountDoubleDidgits9() {
		RamString s = new RamString("");
		int count = s.countDoubleDigits();
		assertTrue(count == 0);
	}

	@Test
	public void testCountDoubleDidgits10() {
		RamString s = new RamString("I H81GHT vegg1es");
		int count = s.countDoubleDigits();
		assertTrue(count == 1);
	}

	@Test
	public void testCountDoubleDidgits11() {
		RamString text = new RamString("PO12");
		int doubleDigit = text.countDoubleDigits();
		assertTrue(1==doubleDigit);
	}
	@Test
	public void testCountDoubleDidgits12() {
		RamString text = new RamString("PO");
		int doubleDigit = text.countDoubleDigits();
		assertTrue(0==doubleDigit);
	}

	@Test
	public void testCountDoubleDidgits13() {
		RamString text = new RamString("1212");
		int doubleDigit = text.countDoubleDigits();
		assertTrue(0==doubleDigit);
	}
	@Test
	public void testCountDoubleDidgits14() {
		RamString text = new RamString("1 2");
		int doubleDigit = text.countDoubleDigits();
		assertTrue(0==doubleDigit);
	}

	@Test
	public void testCountDoubleDidgits15() {
		RamString defaultString = new RamString();
		int count = defaultString.countDoubleDigits();
		assertTrue(0 == count);
	}

	@Test
	public void testCountDoubleDidgits16() {
		RamString defaultString = new RamString("00abc");
		int count = defaultString.countDoubleDigits();
		assertTrue(1 == count);
	}

	@Test
	public void testCountDoubleDidgits17() {
		RamString defaultString = new RamString("Hello00 World00");
		int count = defaultString.countDoubleDigits();
		assertTrue(2 == count);
	}

	@Test
	public void testCountDoubleDidgits18() {
		RamString defaultString = new RamString("Hello 0");
		int count = defaultString.countDoubleDigits();
		assertTrue(0 == count);
	}

	@Test
	public void testCountDoubleDidgits19() {
		RamString defaultString = new RamString("Hello 000");
		int count = defaultString.countDoubleDigits();
		assertTrue(0 == count);
	}

	@Test
	public void testCountDoubleDidgits20(){
		RamString s = new RamString("Sara00Demp");
		int value = s.countDoubleDigits();
		assertTrue(1 == value);
	}

	@Test
	public void testCountDoubleDidgits21(){
		RamString s = new RamString("123");
		int moreThanTwoDigits = s.countDoubleDigits();
		assertTrue(0 == moreThanTwoDigits);
	}

	@Test
	public void testCountDoubleDidgits22(){
		RamString s = new RamString("Sara Dempsey");
		int noDigits = s.countDoubleDigits();
		assertTrue(0 == noDigits);
	}

	@Test
	public void testCountDoubleDidgits23(){
		RamString s = new RamString("ABC12DEF34");
		int moreThanOneSetOfDoubles = s.countDoubleDigits();
		assertTrue(2 == moreThanOneSetOfDoubles);
	}

	@Test
	public void testCountDoubleDidgits24(){
		RamString s = new RamString("ABC12DEF34GHI56JKL78");
		int lotsOfDoubles = s.countDoubleDigits();
		assertTrue(4 == lotsOfDoubles);
	}

	@Test
	public void testCountDoubleDidgits25() {
		RamString fourDigits = new RamString("1337");
		int doubleDigits = fourDigits.countDoubleDigits();
		assertEquals(0, doubleDigits);
	}

	@Test
	public void testCountDoubleDidgits26() {
		RamString oneDigit = new RamString("1Hia3");
		int doubleDigits = oneDigit.countDoubleDigits();
		assertEquals(0, doubleDigits);
	}

	@Test
	public void testCountDoubleDidgits27() {
		RamString countDigits = new RamString();
		int result = countDigits.countDoubleDigits();
		assertEquals(0, result);
	}

	@Test
	public void testCountDoubleDidgits28() {
		RamString countDigits = new RamString("12a24");
		int result = countDigits.countDoubleDigits();
		assertEquals(2, result);
	}

	@Test
	public void testCountDoubleDidgits39() {
		RamString countDigits = new RamString("100a");
		int result = countDigits.countDoubleDigits();
		assertEquals(0, result);
	}


/*********************************************************
 * tests for isValidVCUEmail()
 *********************************************************/

	@Test
	public void testIsValidVCUEmail1() {
		RamString rams1 = new RamString("mymail.vcu.edu");
		boolean result = rams1.isValidVCUEmail();
		assertEquals(false, result);
	}
	
	@Test
	public void testIsValidVCUEmail2() {
		RamString rams1 = new RamString("asdfl;@vcu.edu");
		boolean result = rams1.isValidVCUEmail();
		assertEquals(true, result);
	}
	
	@Test
	public void testIsValidVCUEmail3() {
		RamString rams1 = new RamString("jasdf@mmail.vcu.edu");
		boolean result = rams1.isValidVCUEmail();
		assertEquals(false, result);
	}
	
	@Test
	public void testIsValidVCUEmail4() {
		RamString rams1 = new RamString("@vcu.edu");
		boolean result = rams1.isValidVCUEmail();
		assertEquals(false, result);
	}

	@Test
	public void testIsValidVCUEmail5() {
		RamString defaultString = new RamString("RodenyTheRam@vcu.edu");
		boolean validEmail = defaultString.isValidVCUEmail();
		assertTrue(true == validEmail);
	}

	@Test
	public void testIsValidVCUEmail6() {
		RamString defaultString = new RamString("helloworld@mymail.vcu.edu");
		boolean validEmail = defaultString.isValidVCUEmail();
		assertTrue(true == validEmail);
	}

	@Test
	public void testIsValidVCUEmail7() {
		RamString defaultString = new RamString("myVCUEmail@gmail.com");
		boolean validEmail = defaultString.isValidVCUEmail();
		assertTrue(false == validEmail);

	}

	@Test
	public void testIsValidVCUEmail8() {
		RamString defaultString = new RamString("john123@vcu.edu");
		boolean validEmail = defaultString.isValidVCUEmail();
		assertTrue(true == validEmail);

	}

	@Test
	public void testIsValidVCUEmail9() {
		RamString defaultString = new RamString("red@gmail.com");
		boolean validEmail = defaultString.isValidVCUEmail();
		assertTrue(false == validEmail);
	}

	@Test
	public void testIsValidVCUEmail10() {
		RamString text = new RamString("t@vcu.edu");
		boolean validEmail = text.isValidVCUEmail();
		assertTrue(validEmail == true);
	}
	
	@Test
	public void testIsValidVCUEmail11() {
		RamString text = new RamString("t.vcu.edu");
		boolean validEmail = text.isValidVCUEmail();
		assertTrue(validEmail == false);
	}

	@Test
	public void testIsValidVCUEmail12() {
		RamString text = new RamString("@vcu.edu");
		boolean validEmail = text.isValidVCUEmail();
		assertTrue(validEmail == false);
	}
	@Test
	public void testIsValidVCUEmail13() {
		RamString text = new RamString("new@gmail.com");
		boolean validEmail = text.isValidVCUEmail();
		assertTrue(validEmail == false);
	}

	@Test
	public void testIsValidVCUEmail14() {
		RamString defaultString = new RamString();
		boolean result = defaultString.isValidVCUEmail();
		assertTrue(result == false);
	}

	@Test
	public void testIsValidVCUEmail15() {
		RamString defaultString = new RamString("votb@vcu.edu");
		boolean result = defaultString.isValidVCUEmail();
		assertTrue(result == true);
	}

	@Test
	public void testIsValidVCUEmail16() {
		RamString defaultString = new RamString("abc@mymail.vcu.edu");
		boolean result = defaultString.isValidVCUEmail();
		assertTrue(result == true);
	}

	@Test
	public void testIsValidVCUEmail17() {
		RamString defaultString = new RamString("abc@vcu.edu");
		boolean result = defaultString.isValidVCUEmail();
		assertTrue(result == true);
	}

	@Test
	public void testIsValidVCUEmail18(){
		RamString s = new RamString("123@vcu.edu");
		boolean withNumbers = s.isValidVCUEmail();
		assertTrue(withNumbers);
	}

	@Test
	public void testIsValidVCUEmail19(){
		RamString s = new RamString("dempseys3@vcu.edu");
		boolean defaultEmail = s.isValidVCUEmail();
		assertTrue(defaultEmail);
	}

	@Test
	public void testIsValidVCUEmail20(){
		RamString s = new RamString("dempseys2@mymail.vcu.edu");
		boolean myMail = s.isValidVCUEmail();
		assertTrue(myMail);
	}

	@Test
	public void testIsValidVCUEmail21(){
		RamString s = new RamString("123@gmail.com");
		boolean notVCUEmail = s.isValidVCUEmail();
		assertFalse(notVCUEmail);
	}

	@Test
	public void testIsValidVCUEmail22(){
		RamString s = new RamString("DS3@VCU.EDU");
		boolean caps = s.isValidVCUEmail();
		assertTrue(caps);
	}

	@Test
	public void testIsValidVCUEmail23(){
		RamString s = new RamString("DS3@vuc.eud");
		boolean dyslexicEmail = s.isValidVCUEmail();
		assertFalse(dyslexicEmail);
	}

	@Test
	public void testIsValidVCUEmail24() {
		RamString rodney = new RamString("RodneyTheRam@vcu.edu");
		boolean isValid = rodney.isValidVCUEmail();
		assertEquals(true, isValid);
	}

	@Test
	public void testIsValidVCUEmail25() {
		RamString rodneyMymail = new RamString("RodneyTheRam@mymail.vcu.edu");
		boolean isValid = rodneyMymail.isValidVCUEmail();
		assertEquals(true, isValid);
	}

	@Test
	public void testIsValidVCUEmail26() {
		RamString gmail = new RamString("email123@gmail.com");
		boolean isValid = gmail.isValidVCUEmail();
		assertEquals(false, isValid);
	}

	@Test
	public void testIsValidVCUEmail27() {
		RamString noPrefix = new RamString("@vcu.edu");
		boolean isValid = noPrefix.isValidVCUEmail();
		assertEquals(false, isValid);
	}

	@Test
	public void testIsValidVCUEmail28() {
		RamString nonEmailString = new RamString("google.com");
		boolean isValid = nonEmailString.isValidVCUEmail();
		assertEquals(false, isValid);
	}

	@Test
	public void testIsValidVCUEmail29() {
		RamString validEmail = new RamString("RamFam@gmail.com");
		assertFalse(validEmail.isValidVCUEmail());
	}

	@Test
	public void testIsValidVCUEmail30() {
		RamString validEmail = new RamString("joe@mymail.vcu.edu");
		assertTrue(validEmail.isValidVCUEmail());
	}

	@Test
	public void testIsValidVCUEmail31() {
		RamString validEmail = new RamString("@vcu.edu@vcu.edu");
		assertFalse(validEmail.isValidVCUEmail());
	}

/*********************************************************
 * tests for ramifyString()
 *********************************************************/

	@Test
	public void testRamifyString1() {
		RamString rams1 = new RamString("867530009");
		rams1.ramifyString();
		assertEquals("867530009", rams1.getWackyString());
	}
	
	@Test
	public void testRamifyString2() {
		RamString rams1 = new RamString("86753009");
		rams1.ramifyString();
		assertEquals("86753CS@VCU9", rams1.getWackyString());
	}
	
	@Test
	public void testRamifyString3() {
		RamString rams1 = new RamString("8675309");
		rams1.ramifyString();
		assertEquals("86753GoRams9", rams1.getWackyString());
	}
	
	@Test
	public void testRamifyString4() {
		RamString rams1 = new RamString("WhickWhackPattyWhack");
		rams1.ramifyString();
		assertEquals("WhickWhackPattyWhack", rams1.getWackyString());
	}
	
	@Test
	public void testRamifyString5() {
		RamString rams1 = new RamString("..  @vcu.edu");
		rams1.ramifyString();
		assertEquals("..  @vcu.edu", rams1.getWackyString());
	}

	@Test
	public void testRamifyString6() {
		RamString defaultString = new RamString();
		defaultString.ramifyString();
		assertTrue("Rodney, the Ram".equals(defaultString.getWackyString()));
	}

	@Test
	public void testRamifyString7() {
		RamString s = new RamString("0");
		s.ramifyString();
		assertTrue("GoRams".equals(s.getWackyString()));
	}

	@Test
	public void testRamifyString8() {
		RamString s = new RamString("a0a");
		s.ramifyString();
		assertTrue("aGoRamsa".equals(s.getWackyString()));
	}

	@Test
	public void testRamifyString9() {
		RamString s = new RamString("a00a");
		s.ramifyString();
		assertTrue("aCS@VCUa".equals(s.getWackyString()));
	}

	@Test
	public void testRamifyString10() {
		RamString defaultString = new RamString();
		defaultString.ramifyString();
		String newDefault = defaultString.getWackyString();
		assertTrue("Rodney, the Ram".equals(newDefault));
	}

	@Test
	public void testRamifyString11() {
		RamString defaultString = new RamString("Hello 0");
		defaultString.ramifyString();
		String newDefault = defaultString.getWackyString();
		assertTrue("Hello GoRams".equals(newDefault));
	}

	@Test
	public void testRamifyString12() {
		RamString defaultString = new RamString("Hello 00");
		defaultString.ramifyString();
		String newDefault = defaultString.getWackyString();
		assertTrue("Hello CS@VCU".equals(newDefault));
	}

	@Test
	public void testRamifyString13() {
		RamString defaultString = new RamString("Hello 000");
		defaultString.ramifyString();
		String newDefault = defaultString.getWackyString();
		assertTrue("Hello 000".equals(newDefault));
	}

	@Test
	public void testRamifyString14() {
		RamString defaultString = new RamString("H00llo");
		defaultString.ramifyString();
		String newDefault = defaultString.getWackyString();
		assertTrue("HCS@VCUllo".equals(newDefault));
	}

	@Test
	public void testRamifyString15(){
		RamString s = new RamString("Sara");
		s.ramifyString();
		assertTrue(s.getWackyString().equals("Sara"));
	}

	@Test
	public void testRamifyString16(){
		RamString s = new RamString("S00R");
		s.ramifyString();
		assertTrue(s.getWackyString().equals("SCS@VCUR"));
	}

	@Test
	public void testRamifyString17(){
		RamString s = new RamString("H0EY");
		s.ramifyString();
		assertTrue(s.getWackyString().equals("HGoRamsEY"));
	}

	@Test
	public void testRamifyString18(){
		RamString s = new RamString("H000EY");
		s.ramifyString();
		assertTrue(s.getWackyString().equals("H000EY"));
	}

	@Test
	public void testRamifyString19() {
		RamString singleZero = new RamString("0");
		singleZero.ramifyString();
		String ramifiedString = singleZero.getWackyString();
		assertTrue("GoRams".equals(ramifiedString));
	}

	@Test
	public void testRamifyString20() {
		RamString tripleZero = new RamString("000");
		tripleZero.ramifyString();
		String ramifiedString = tripleZero.getWackyString();
		assertTrue("000".equals(ramifiedString));
	}

	@Test
	public void testRamifyString21() {
		RamString helloZero = new RamString("Hello0");
		helloZero.ramifyString();
		String ramifiedString = helloZero.getWackyString();
		assertTrue("HelloGoRams".equals(ramifiedString));
	}

	@Test
	public void testRamifyString22() {
		RamString helloSingleDoubleZero = new RamString("0Hello00");
		helloSingleDoubleZero.ramifyString();
		String ramifiedString = helloSingleDoubleZero.getWackyString();
		assertTrue("GoRamsHelloCS@VCU".equals(ramifiedString));
	}

	@Test
	public void testRamifyString23() {
		RamString test = new RamString("Rodney, the Ram");
		test.ramifyString();
		assertTrue("Rodney, the Ram".equals(test.getWackyString()));
	}

	@Test
	public void testRamifyString24() {
		RamString test = new RamString("1234");
		test.ramifyString();
		assertTrue("1234".equals(test.getWackyString()));	
	}

	@Test
	public void testRamifyString25() {
		RamString test = new RamString("10");
		test.ramifyString();
		assertTrue("1GoRams".equals(test.getWackyString()));
	}

	@Test
	public void testRamifyString26() {
		RamString test = new RamString("100");
		test.ramifyString();
		assertTrue("1CS@VCU".equals(test.getWackyString()));
	}

	@Test
	public void testRamifyString27() {
		RamString ramifyString = new RamString("r00t");
		ramifyString.ramifyString();
		assertTrue("rCS@VCUt".equals(ramifyString.getWackyString()));
	}

	@Test
	public void testRamifyString28() {
		RamString ramifyString = new RamString("root");
		ramifyString.ramifyString();
		assertTrue("root".equals(ramifyString.getWackyString()));
	}

/*********************************************************
 * tests for convertDigitsToRomanNumeralsInSubstring()
 *********************************************************/

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring1() {
		RamString rams1 = new RamString("867530009");
		rams1.convertDigitsToRomanNumeralsInSubstring(1, 3);
		assertEquals("VIIIVIVII530009", rams1.getWackyString());
	}
	
	@Test (expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring2() {
		RamString rams1 = new RamString("86753009");
		rams1.convertDigitsToRomanNumeralsInSubstring(0,3);
		assertEquals("86753CS@VCU9", rams1.getWackyString());
	}
	
	@Test(expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring3() {
		RamString rams1 = new RamString("8675309");
		rams1.convertDigitsToRomanNumeralsInSubstring(-2, 4);
		assertEquals("86753GoRams9", rams1.getWackyString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring4() {
		RamString rams1 = new RamString("WhickWhackPattyWhack");
		rams1.convertDigitsToRomanNumeralsInSubstring(4,2);
		assertEquals("WhickWhackPattyWhack", rams1.getWackyString());
	}
	
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring5() {
		RamString rams1 = new RamString("1234");
		rams1.convertDigitsToRomanNumeralsInSubstring(1,1);
		assertEquals("I234", rams1.getWackyString());
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring6(){
		RamString s = new RamString("Hello");
		s.convertDigitsToRomanNumeralsInSubstring(1,5);
		assertTrue(s.getWackyString().equals("Hello"));
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring7(){
		RamString s = new RamString("123");
		s.convertDigitsToRomanNumeralsInSubstring(1,3);
		assertTrue(s.getWackyString().equals("IIIIII"));
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring8(){
		RamString s = new RamString("300");
		s.convertDigitsToRomanNumeralsInSubstring(1,3);
		assertTrue(s.getWackyString().equals("III00"));
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring9(){
		RamString s = new RamString("557");
		s.convertDigitsToRomanNumeralsInSubstring(1,3);
		assertTrue(s.getWackyString().equals("VVVII"));
	}

	@Test (expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring10() {
		RamString test = new RamString("Rodney, the Ram");
		test.convertDigitsToRomanNumeralsInSubstring(0, 13);
		assertTrue("Rodney, the Ram".equals(test.getWackyString()));
	}

	@Test (expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring11() {
		RamString test = new RamString("123");
		test.convertDigitsToRomanNumeralsInSubstring(0, 5);
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring12() {
		RamString romanNums = new RamString();
		romanNums.convertDigitsToRomanNumeralsInSubstring(1,15);
		assertTrue ("Rodney, the Ram".equals(romanNums.getWackyString()));
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring13() {
		RamString romanNums = new RamString("Rodney1");
		romanNums.convertDigitsToRomanNumeralsInSubstring(1,7);
		assertTrue ("RodneyI".equals(romanNums.getWackyString()));

	}

	@Test(expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring14() {
		RamString romanNums = new RamString("Rodney1");
		romanNums.convertDigitsToRomanNumeralsInSubstring(0,6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring15() {
		RamString romanNums = new RamString("Rodney1");
		romanNums.convertDigitsToRomanNumeralsInSubstring(7,6);
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring16() {
		RamString defaultString = new RamString();
		defaultString.convertDigitsToRomanNumeralsInSubstring(1, 4);
		String newDefault = defaultString.getWackyString();
		assertTrue("Rodney, the Ram".equals(newDefault));
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring17() {
		RamString defaultString = new RamString();
		defaultString.convertDigitsToRomanNumeralsInSubstring(2,6);
		String exp = "Rodney, the Ram";
		assertTrue("Rodney, the Ram".equals(exp));
	}
	
	@Test(expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring18() {
		RamString defaultString = new RamString();
		defaultString.convertDigitsToRomanNumeralsInSubstring(1,17);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring19() {
		RamString defaultString = new RamString();
		defaultString.convertDigitsToRomanNumeralsInSubstring(4,2);
	}


}

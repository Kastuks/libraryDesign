package design;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class PhoneValidatorTests {
	
	PhoneValidator phoneValidator;

	@BeforeEach
	void setUp() {
		phoneValidator = new PhoneValidator();

	}
	
	@Test
	void testIfPhoneNumberContainsOnlyNumbers() {
		boolean isValid = phoneValidator.validatePhoneNumberSymbols("86423479B");
		assertTrue(isValid);
	}
	@Test
	void testIfPhoneNumberIsNotEmpty() {
		boolean isValid = phoneValidator.validatePhoneNumberNotEmpty("   ");
		assertTrue(isValid);
	}
	@Test
	void testIfPhoneNumberPrefixChangesCorrectly() {
		boolean isValid = phoneValidator.validatePhoneNumberPrefix("86423495");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberCountryIsCorrect() {
		String validNumber = phoneValidator.validateIfPhoneNumberIsCorrect("LT", "+37068843942");
		assertEquals("Phone number is correct", validNumber);
	}
	

}

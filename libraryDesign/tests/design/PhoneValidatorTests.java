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
	void testIfPhoneNumberIsNotEmpty_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumberNotEmpty("   ");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberIsNotNull_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumberNotEmpty(null);
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberContainsOnlyNumbers_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumberSymbols("86423479B");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberContainsOnlyNumbers_shouldReturnTrue() {
		boolean isValid = phoneValidator.validatePhoneNumberSymbols("864234793");
		assertTrue(isValid);
	}
	
	
	
	@Test
	void testIfPhoneNumberPrefixChangesCorrectly_shouldReturnTrue() {
		boolean isValid = phoneValidator.validatePhoneNumberPrefix("86423495");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberCountryIsCorrect_shouldReturnTrue() {
		boolean isValid = phoneValidator.validateIfPhoneNumberIsCorrect("LT", "+37068843942");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberIsTooLong_shouldReturnFalse() {
		boolean isValid = phoneValidator.validateIfPhoneNumberIsTooLong("+3706884394242");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberIsTooShort_shouldReturnFalse() {
		boolean isValid = phoneValidator.validateIfPhoneNumberIsTooShort("+37064242");
		assertTrue(isValid);
	}
	

}

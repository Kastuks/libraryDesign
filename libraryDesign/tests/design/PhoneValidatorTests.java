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
		boolean isValid = phoneValidator.validatePhoneNumber("");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberIsNotNull_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumber(null);
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberContainsOnlyNumbers_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumber("+3706423479B");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberContainsOnlyNumbers_shouldReturnTrue() {
		boolean isValid = phoneValidator.validatePhoneNumber("+37064234793");
		assertTrue(isValid);
	}
	
	
//	@Test
//	void testIfPhoneNumberPrefixChangesCorrectly_shouldReturnTrue() {
//		boolean isValid = phoneValidator.validatePhoneNumberPrefix("864234958");
//		assertTrue(isValid);
//	}
	
	@Test
	void testIfPhoneNumberCountryIsCorrect_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumber("LT", "+37168843942");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberCountryIsCorrect_shouldReturnTrue() {
		boolean isValid = phoneValidator.validatePhoneNumber("LT", "+37068843942");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberIsTooLong_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumber("+3706884394242");
		assertTrue(isValid);
	}
	
	@Test
	void testIfPhoneNumberIsTooShort_shouldReturnFalse() {
		boolean isValid = phoneValidator.validatePhoneNumber("+37064242");
		assertTrue(isValid);
	}
	
	@Test
	void testIfOtherCountryPhoneNumberContainsOnlyNumbers_shouldReturnFalse() {
		boolean isValid = phoneValidator.validateOtherCountryPhoneNumber("+402134793427B");
		assertTrue(isValid);
	}
	
	@Test
	void testIfOtherCountryPhoneNumberContainsOnlyNumbers_shouldReturnTrue() {
		boolean isValid = phoneValidator.validateOtherCountryPhoneNumber("+402134793598");
		assertTrue(isValid);
	}
	
	@Test
	void testIfOtherCountryPhoneNumberCountryIsCorrect_shouldReturnFalse() {
		boolean isValid = phoneValidator.validateOtherCountryPhoneNumber("LV", "+37168843942");
		assertTrue(isValid);
	}
	
	@Test
	void testIfOtherCountryPhoneNumberCountryIsCorrect_shouldReturnTrue() {
		boolean isValid = phoneValidator.validateOtherCountryPhoneNumber("LV", "+37168843942");
		assertTrue(isValid);
	}
	
	@Test
	void testIfOtherCountryPhoneNumberIsTooLong_shouldReturnFalse() {
		boolean isValid = phoneValidator.validateOtherCountryPhoneNumber("+371688439234242");
		assertTrue(isValid);
	}
	
	@Test
	void testIfOtherCountryPhoneNumberIsTooShort_shouldReturnFalse() {
		boolean isValid = phoneValidator.validateOtherCountryPhoneNumber("+37164242");
		assertTrue(isValid);
	}
	

}

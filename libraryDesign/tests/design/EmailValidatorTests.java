package design;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class EmailValidatorTests {
	
	EmailValidator emailValidator;
	
	@BeforeEach
	void setUp() {
		emailValidator = new EmailValidator();;

	}
	
	@Test
	void testIfEmailIsCorrect_shouldReturnTrue() {
		boolean isValid = emailValidator.validateEmail("vardenis@gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailIsEmpty_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail("");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailIsNull_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail(null);
		assertTrue(isValid);
	}
	
	
	@Test
	void testIfEmailContainsAtSign_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail("name.surname.gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsIllegalSymbols_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail("name.s¿@gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsCorrectDomain_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail("name.surname@gmai.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsCorrectTLD_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail("name.surname@gmail.co");
		assertTrue(isValid);
	}
	
}

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
	void testIfEmailContainsAtSign() {
		boolean isValid = emailValidator.validateEmail("name.surname.gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsIllegalSymbols() {
		boolean isValid = emailValidator.validateEmail("name.s*/-@gmail.com");
		assertTrue(isValid);
	}
	@Test
	void testIfEmailContainsCorrectDomain() {
		boolean isValid = emailValidator.validateEmail("name.surname@gmai.com");
		assertTrue(isValid);
	}
	@Test
	void testIfEmailContainsCorrectTLD() {
		boolean isValid = emailValidator.validateEmail("name.surname@gmail.co");
		assertTrue(isValid);
	}
	
}